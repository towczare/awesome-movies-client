package pl.sda.awesomemovies.client.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.awesomemovies.client.movie.FilterCriteria;
import pl.sda.awesomemovies.client.movie.Movie;
import pl.sda.awesomemovies.client.movie.MovieClientService;

import java.util.List;

@Controller
public class CategoryClientController {
    private final CategoryClientService categoryClientService;
    private final MovieClientService movieClientService;
    private static final String MOVIES_BY_CATEGORY = "movie-list";


    @Autowired
    public CategoryClientController(CategoryClientService categoryClientService, MovieClientService movieClientService) {
        this.categoryClientService = categoryClientService;
        this.movieClientService = movieClientService;
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryClientService.getAllCategories();
    }

    @RequestMapping("/categories/{name}")
    public String showMovieDetails(@PathVariable String name, Model model) {
        FilterCriteria categoryFilter = new FilterCriteria();
        categoryFilter.setName("");
        categoryFilter.setCategory(name);
        List<Movie> movies = movieClientService.searchForMovies(categoryFilter);
        model.addAttribute("movies", movies);
        return MOVIES_BY_CATEGORY;
    }
}