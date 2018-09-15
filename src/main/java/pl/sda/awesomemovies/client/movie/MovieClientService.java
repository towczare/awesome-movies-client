package pl.sda.awesomemovies.client.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class MovieClientService {

    private final MovieRestService movieRestService;

    @Autowired
    public MovieClientService(MovieRestService movieRestService) {
        this.movieRestService = movieRestService;
    }

    public List<Movie> getAllMovies() {
        try {
            Movie[] movies = movieRestService.provide().getForObject(
                    movieRestService.getEndpointUrl() + "/movies",
                    Movie[].class);
            return Arrays.asList(movies);
        } catch (ResourceAccessException e) {
            return Collections.emptyList();
        }
    }

    public Movie getMovie(Long id) {
        try {
            return movieRestService.provide().getForObject(
                    movieRestService.getEndpointUrl() + "/movie/" + id + "/show",
                    Movie.class);
        } catch (ResourceAccessException e) {
            return new Movie();
        }
    }
}
