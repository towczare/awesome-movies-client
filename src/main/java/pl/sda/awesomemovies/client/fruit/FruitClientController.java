package pl.sda.awesomemovies.client.fruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class FruitClientController {

    private final FruitClientService fruitClientService;

    @Autowired
    public FruitClientController(FruitClientService fruitClientService) {
        this.fruitClientService = fruitClientService;
    }

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("fruits", fruitClientService.getFruitsFromTestService());
        model.put("name", "stranger");
        return "fruits";
    }
}
