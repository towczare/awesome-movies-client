package pl.sda.awesomemovies.client.movie.trends;

import lombok.Data;
import java.util.List;

@Data
public class MovieTrendPage<T> {
    private int page;
    private int total_results;
    private int total_pages;
    private List<T> results;
    private long total_elements;
}
