package pl.sda.awesomemovies.client.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestClientException;
import pl.sda.awesomemovies.client.category.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class MovieClientService {
    private MovieRestService movieRestService;

    @Autowired
    public MovieClientService(MovieRestService movieRestService) {
        this.movieRestService = movieRestService;
    }

    Page<Movie> getAllMovies(Pageable pageable, Model model) {
        return movieRestService.getMovies(pageable, model);
    }

    List<Movie> getAllMovies() {
        try {
            Movie[] getMovies = movieRestService.provide().getForObject(
                    movieRestService.getEndpointUrl() + "/movies",
                    Movie[].class
            );
            return Arrays.asList(getMovies);
        } catch (RestClientException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    Movie getMovie(Long id) {
        try {
            return movieRestService.provide().getForObject(
                    movieRestService.getEndpointUrl() + "/movie/" + id,
                    Movie.class
            );
        } catch (RestClientException e) {
            e.printStackTrace();
            return new Movie();
        }
    }

    List<Movie> filterMovies(String searchName) {
        List<Movie> foundMovies = new ArrayList<>();
        for (Movie movie : getAllMovies()) {
            if (movie.getTitle().toUpperCase().contains(searchName.toUpperCase())) {
                foundMovies.add(movie);
            }
        }
        return foundMovies;
    }

    public List<Movie> searchForMovies(MovieFilterCriteria movieFilterCriteria) {
        List<Movie> foundMovies = new ArrayList<>();
        getAllMovies().stream().filter(e ->
                e.getTitle().toUpperCase().contains(movieFilterCriteria.getName().toUpperCase())
                        && e.getCategories().contains(new Category(movieFilterCriteria.getCategory())))
                .distinct()
                .forEach(foundMovies::add);
        return foundMovies;
    }
}
