package pl.sda.awesomemovies.client.movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    private Long id;
    private String name;
//    private Category category;
//    private Byte[] image;
//    private Integer time;
//    private LocalDate productionDate;
//    private List<Actor> actors;
//    private String description;
//    private String review;

}
