package pl.sda.awesomemovies.client.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class MovieRestService {

    private final RestTemplate restTemplate;
    @Value("${movie.endpoint.url}")
    private String endpointUrl;

    @Autowired
    public MovieRestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.rootUri(endpointUrl)
                .messageConverters(new MappingJackson2HttpMessageConverter())
                .build();
    }

    public Page<Movie> getMovies(Pageable pageable){
        ParameterizedTypeReference<RestResponsePage<Movie>> ptr =
                new ParameterizedTypeReference<RestResponsePage<Movie>>(){};


        URI targetUrl= UriComponentsBuilder.fromUriString(endpointUrl)
                .path("/movies")
                .queryParam("page", pageable.getPageNumber())
                .queryParam("size", pageable.getPageSize())
                .queryParam("sort", pageable.getSort())
                .build()
                .toUri();

        return restTemplate.exchange(targetUrl, HttpMethod.GET, null, ptr).getBody();
    }


    public RestTemplate provide() {
        return restTemplate;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }
}
