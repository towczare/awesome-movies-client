package pl.sda.awesomemovies.client.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryClientService {
    private CategoryRestService restService;

    @Autowired
    public CategoryClientService(CategoryRestService restService) {
        this.restService = restService;
    }

    public List<Category> getAllCategories() {
        try {
            Category[] categories = restService.provide().getForObject(
                    restService.getEndpointUrl() + "/category",
                    Category[].class
            );
            return Arrays.asList(categories);
        } catch (RestClientException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
