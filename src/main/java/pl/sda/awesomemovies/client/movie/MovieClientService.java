package pl.sda.awesomemovies.client.movie;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieClientService {

    private List<Movie> moviesList = new ArrayList<>();

    public List<Movie> getAllMovies() {
        moviesList.add(new Movie(1L, "Star Wars"));
        moviesList.add(new Movie(2L, "Star Trek"));
        moviesList.add(new Movie(3L, "Oblivion"));
        moviesList.add(new Movie(4L, "Avengers"));
        return moviesList;
    }

    public Movie getMovie(Long id) {
        for (Movie movie : moviesList) {
            if (movie.getId().equals(id)) {
                return movie;
            }
        }
        return null;
    }
}
