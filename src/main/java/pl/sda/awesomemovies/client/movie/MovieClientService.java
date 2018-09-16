package pl.sda.awesomemovies.client.movie;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieClientService {

    private static List<Movie> moviesList = new ArrayList<>();

    static {
        moviesList.add(new Movie(1L, "Star Wars"));
        moviesList.add(new Movie(2L, "Star Trek"));
        moviesList.add(new Movie(3L, "Oblivion"));
        moviesList.add(new Movie(4L, "Avengers"));
    }

    List<Movie> getAllMovies() {
        return moviesList;
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
            if(movie.getName().toUpperCase().contains(searchName.toUpperCase())){
                foundMovies.add(movie);
            }
        }
        return foundMovies;
    }

    List<Movie> searchForMovies(FilterCriteria filterCriteria) {
        return moviesList.stream().filter(e ->
                e.getName().toUpperCase().contains(filterCriteria.getName().toUpperCase()))
                .distinct()
                .collect(Collectors.toList());
    }
}
