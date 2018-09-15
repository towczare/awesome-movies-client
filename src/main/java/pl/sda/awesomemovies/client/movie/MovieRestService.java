package pl.sda.awesomemovies.client.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieRestService {

    private final RestTemplate restTemplate;
    @Value("http://localhost:8080")
    private String endpointUrl;

    @Autowired
    public MovieRestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.rootUri(endpointUrl)
                .messageConverters(new MappingJackson2HttpMessageConverter())
                .build();
    }

    public RestTemplate provide() {
        return restTemplate;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }
}
