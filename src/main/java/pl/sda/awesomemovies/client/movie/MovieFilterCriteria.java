package pl.sda.awesomemovies.client.movie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MovieFilterCriteria {
    private String name;
    private String category;
    private String actor;
}
