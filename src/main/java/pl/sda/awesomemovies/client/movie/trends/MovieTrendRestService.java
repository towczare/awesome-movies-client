package pl.sda.awesomemovies.client.movie.trends;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class MovieTrendRestService {
    private final RestTemplate restTemplate;
    @Value("${themoviedb.endpoint.url}")
    private String endpointUrl;
    @Value("${themoviedb.api.key}")
    private String apiKey;

    @Autowired
    public MovieTrendRestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.rootUri(endpointUrl)
            .messageConverters(new MappingJackson2HttpMessageConverter())
            .build();
    }

    public MovieTrendPage<MovieTrend> getMovieTrends() {
        ParameterizedTypeReference<MovieTrendPage<MovieTrend>> ptr =
            new ParameterizedTypeReference<MovieTrendPage<MovieTrend>>() {
            };

        URI targetUrl = UriComponentsBuilder.fromUriString(endpointUrl)
                .path("/discover/movie")
                .queryParam("sort_by", "popularity.desc")
                .queryParam("api_key", apiKey)
                .build()
                .toUri();
        return restTemplate.exchange(targetUrl, HttpMethod.GET, null, ptr).getBody();
    }


}
