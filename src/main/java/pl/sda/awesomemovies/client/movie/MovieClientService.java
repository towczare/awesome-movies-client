package pl.sda.awesomemovies.client.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieClientService {

    private MovieRestService movieRestService;

    private List<Movie> moviesList = new ArrayList<>();

    @Autowired
    public MovieClientService(MovieRestService movieRestService) {
        this.movieRestService = movieRestService;
    }

    List<Movie> getAllMovies() {
        try {
            Movie[] movies = movieRestService.provide().getForObject(
                    movieRestService.getEndpointUrl() + "/movies",
                    Movie[].class
            );
            moviesList = Arrays.asList(movies);
            return moviesList;
        } catch (RestClientException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    Movie getMovie(Long id) {
        for (Movie movie : moviesList) {
            if (movie.getId().equals(id)) {
                return movie;
            }
        }
        return null;
    }

    List<Movie> filterMovies(String searchName) {
        List<Movie> foundMovies = new ArrayList<>();
        for (Movie movie : moviesList) {
            if (movie.getTitle().toUpperCase().contains(searchName.toUpperCase())) {
                foundMovies.add(movie);
            }
        }
        return foundMovies;
    }

    List<Movie> searchForMovies(FilterCriteria filterCriteria) {
        return moviesList.stream().filter(e ->
                e.getTitle().toUpperCase().contains(filterCriteria.getName().toUpperCase()))
                .distinct()
                .collect(Collectors.toList());
    }
}
