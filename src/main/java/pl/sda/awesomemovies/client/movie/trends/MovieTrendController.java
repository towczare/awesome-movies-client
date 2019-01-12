package pl.sda.awesomemovies.client.movie.trends;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.awesomemovies.client.category.Category;
import pl.sda.awesomemovies.client.movie.Movie;
import pl.sda.awesomemovies.client.movie.MovieFilterCriteria;

import java.util.List;

@Controller
public class MovieTrendController {
    private final MovieTrendService movieTrendService;

    private static final String MOVIE_TREND_LIST = "movie-trend-list";

    @Autowired
    public MovieTrendController(MovieTrendService movieTrendService) {
        this.movieTrendService = movieTrendService;
    }

    @RequestMapping({"/movie/trend"})
    public String getMovieTrendView(Model model){
        model.addAttribute("trends", movieTrendService.getTrends());
        return MOVIE_TREND_LIST ;
    }
}
