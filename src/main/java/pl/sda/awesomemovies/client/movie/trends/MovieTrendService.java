package pl.sda.awesomemovies.client.movie.trends;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieTrendService {

    private final MovieTrendRestService movieTrendRestService;

    @Autowired
    public MovieTrendService(MovieTrendRestService movieTrendRestService) {
        this.movieTrendRestService = movieTrendRestService;
    }

    public MovieTrendPage<MovieTrend> getTrends() {
        return movieTrendRestService.getMovieTrends();
    }
}
