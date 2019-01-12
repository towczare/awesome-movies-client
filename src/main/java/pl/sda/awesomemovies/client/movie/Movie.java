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

    public Double thumbUpPercentage(int thumbUp, int thumbDown) {
        return getPercentage(thumbUp, thumbDown);
    }

    private Double getPercentage(int firs, int second) {
        int sum = firs + second;
        if (sum == 0) {
            return Double.valueOf(0);
        } else {
            return Double.valueOf(firs * 100 / sum);
        }
    }

    public Double thumbDownPercentage(int thumbDown, int thumbUp) {
        return getPercentage(thumbDown, thumbUp);
    }
}
