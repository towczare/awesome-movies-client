package pl.sda.awesomemovies.client.movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sda.awesomemovies.client.category.Category;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    private Long id;
    private String title;
    private String director;
    private Set<Category> categories;
    private String posterLink;
    @JsonProperty("trailerUrl")
    private String movieTrailer;
    private Double criticsRate;
    private Integer thumbUp;
    private Integer thumbDown;
}
