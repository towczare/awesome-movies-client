package pl.sda.awesomemovies.client.fruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FruitRestService {

    @Value("${fruit.endpoint.url}")
    private String endpointUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public FruitRestService(RestTemplateBuilder restTemplateBuilder) {
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
