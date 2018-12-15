package pl.sda.awesomemovies.client.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorRestService {

    private final RestTemplate restTemplate;
    @Value("${movie.endpoint.url}")
    private String endpointUrl;

    @Autowired
    public ActorRestService(RestTemplateBuilder restTemplateBuilder) {
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
