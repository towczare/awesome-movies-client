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

    private static final String MOVIE_LIST = "movie-list";
    private static final String MOVIE_DETAILS_VIEW = "movie-details-view";
    private static final String MOVIES_VIEW = "movies";
    private static final String MOVIES_SEARCH = "movie-search";

    @Autowired
    public MovieClientController(MovieClientService movieClientService, CategoryClientService categoryClientService) {
        this.movieClientService = movieClientService;
        this.categoryClientService = categoryClientService;
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryClientService.getAllCategories();
    }
    @RequestMapping({"/"})
    public String getMoviesView(Model model){
        model.addAttribute("movies", movieClientService.getAllMovies());
        model.addAttribute("filterCriteria", new MovieFilterCriteria());
        return MOVIES_VIEW;
    }

    @RequestMapping({"/movielist"})
    public String getMovieList(Pageable pageable, Model model) {
        Page<Movie> allMovies = movieClientService.getAllMovies(pageable);
        model.addAttribute("movies", allMovies.getContent());
        model.addAttribute("filterCriteria", new MovieFilterCriteria());
        return MOVIE_LIST;
    }

    @RequestMapping("/movie/{id}")
    public String showMovieDetails(@PathVariable String id, Model model) {
        model.addAttribute("movie", movieClientService.getMovie(Long.valueOf(id)));
        return MOVIE_DETAILS_VIEW;
    }

    @PostMapping("/filterMovies")
    public String filterMovies(@RequestParam String searchName, Model model) {
        List<Movie> filteredMovies = movieClientService.filterMovies(searchName);
        model.addAttribute("movies", filteredMovies);
        return MOVIE_LIST;
    }

    @GetMapping("/advancedSearch")
    public String searchForMoviesForm(Model model) {
        model.addAttribute("filterCriteria", new MovieFilterCriteria());
        return MOVIES_SEARCH;
    }

    @PostMapping("/advancedSearch")
    public String searchForMovies(@ModelAttribute MovieFilterCriteria movieFilterCriteria, Model model){
        List<Movie> movies = movieClientService.searchForMovies(movieFilterCriteria);
        model.addAttribute("movies", movies);
        return MOVIES_VIEW;
    }
}
