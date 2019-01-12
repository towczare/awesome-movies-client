package pl.sda.awesomemovies.client.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.awesomemovies.client.category.Category;
import pl.sda.awesomemovies.client.category.CategoryClientService;

import java.util.List;

@Controller
public class MovieClientController {
    private final MovieClientService movieClientService;
    private final CategoryClientService categoryClientService;

    private static final String CATEGORIES_MODEL = "categories";
    private static final String MOVIES_MODEL = "movies";
    private static final String FILTER_CRITERIA_MODEL = "filterCriteria";
    private static final String MOVIE_MODEL = "movie";

    private static final String MOVIE_LIST_VIEW = "movie-list-view";
    private static final String MOVIE_DETAILS_VIEW = "movie-details-view";
    private static final String MOVIES_VIEW = "movies-view";
    private static final String MOVIES_SEARCH_VIEW = "movie-search-view";

    @Autowired
    public MovieClientController(MovieClientService movieClientService, CategoryClientService categoryClientService) {
        this.movieClientService = movieClientService;
        this.categoryClientService = categoryClientService;
    }

    @ModelAttribute(CATEGORIES_MODEL)
    public List<Category> categories() {
        return categoryClientService.getAllCategories();
    }

    @RequestMapping({"/"})
    public String getMoviesView(Model model){
        model.addAttribute(MOVIES_MODEL, movieClientService.getAllMovies());
        model.addAttribute(FILTER_CRITERIA_MODEL, new FilterCriteria());
        return MOVIES_VIEW;
    }

    @RequestMapping({"/movielist"})
    public String getMovieList(Pageable pageable, Model model) {
        Page<Movie> allMovies = movieClientService.getAllMovies(pageable);
        model.addAttribute(MOVIES_MODEL, allMovies.getContent());
        model.addAttribute(FILTER_CRITERIA_MODEL, new FilterCriteria());
        return MOVIE_LIST_VIEW;
    }

    @RequestMapping("/movie/{id}")
    public String showMovieDetails(@PathVariable String id, Model model) {
        model.addAttribute(MOVIE_MODEL, movieClientService.getMovie(Long.valueOf(id)));
        return MOVIE_DETAILS_VIEW;
    }

    @PostMapping("/filterMovies")
    public String filterMovies(@RequestParam String searchName, Model model) {
        List<Movie> filteredMovies = movieClientService.filterMovies(searchName);
        model.addAttribute(MOVIES_MODEL, filteredMovies);
        return MOVIE_LIST_VIEW;
    }

    @GetMapping("/advancedSearch")
    public String searchForMoviesForm(Model model) {
        model.addAttribute(FILTER_CRITERIA_MODEL, new FilterCriteria());
        return MOVIES_SEARCH_VIEW;
    }

    @PostMapping("/advancedSearch")
    public String searchForMovies(@ModelAttribute FilterCriteria filterCriteria, Model model){
        List<Movie> movies = movieClientService.searchForMovies(filterCriteria);
        model.addAttribute(MOVIES_MODEL, movies);
        return MOVIES_VIEW;
    }
}
