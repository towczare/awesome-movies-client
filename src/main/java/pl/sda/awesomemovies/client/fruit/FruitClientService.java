package pl.sda.awesomemovies.client.fruit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class FruitClientService {

    private final FruitRestService fruitRestService;

    @Autowired
    public FruitClientService(FruitRestService fruitRestService) {
        this.fruitRestService = fruitRestService;
    }

    public List<Fruit> getFruitsFromTestService() {
        try {
            Fruit[] fruits = fruitRestService.provide().getForObject(
                    fruitRestService.getEndpointUrl() + "/fruits",
                    Fruit[].class);
            return Arrays.asList(fruits);
        } catch (ResourceAccessException e) {
            log.warn("Couldn't connect to fruit server....", e);
            return Collections.emptyList();
        }
    }

}
