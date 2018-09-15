package pl.sda.awesomemovies.client.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieClientController {

    private final MovieClientService movieClientService;

    @Autowired
    public MovieClientController(MovieClientService movieClientService) {
        this.movieClientService = movieClientService;
    }

    @RequestMapping("/")
    public String getMovieList(Model model) {
        model.addAttribute("movies", movieClientService.getAllMovies());
        return "movies";
    }

    @RequestMapping("/movie/{id}/show")
    public String showMovieDetails(@PathVariable String id, Model model) {
        model.addAttribute("movie", movieClientService.getMovie(Long.valueOf(id)));
        return "movie";
    }
}
