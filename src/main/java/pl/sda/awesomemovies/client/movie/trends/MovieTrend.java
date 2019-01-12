package pl.sda.awesomemovies.client.movie.trends;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MovieTrend {
    @JsonProperty("vote_count")
    private long voteCount;
    private long id;
    private boolean video;
    @JsonProperty("vote_average")
    private Double voteAverage;
    private String title;
    private String popularity;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("genre_ids")
    private Integer[] genreIds;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    private boolean adult;
    private String overview;
    @JsonProperty("release_date")
    private Date releaseDate;
}
