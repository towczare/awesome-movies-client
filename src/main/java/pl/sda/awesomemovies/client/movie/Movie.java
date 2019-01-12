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

    public Double thumbUpPercentage() {
        return getPercentage(thumbUp, thumbDown);
    }

    private Double getPercentage(Integer first, Integer second) {
        first = (first != null ? first : 0);
        second = (second != null ? second : 0);
        int sum = first + second;
        if (sum > 0) {
            return Double.valueOf(first * 100 / sum);
        } else {
            return 0.0;
        }
    }

    public Double thumbDownPercentage() {
        return getPercentage(thumbDown, thumbUp);
    }
}
