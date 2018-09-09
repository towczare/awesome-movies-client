package pl.sda.awesomemoviesclient.awesomemoviesclient;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class AwesomeMoviesController {

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("name", "stranger");
        return "welcome";
    }
}
