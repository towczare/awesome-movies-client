package pl.sda.awesomemovies.client.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ActorClientController {

    private final ActorClientService actorClientService;
    private final String ACTORS_VIEW = "actors";
    private final String ACTOR_DETAILS_VIEW = "actor-details-view";


    @Autowired
    public ActorClientController(ActorClientService actorClientService) {
        this.actorClientService = actorClientService;
    }

    @ModelAttribute("actors")
    public List<Actor> actors() {
        return actorClientService.getAllActors();
    }

    @RequestMapping("/actors")
    public String getActorsList(Model model) {
        //   model.addAttribute("actors", actorClientService.getAllActors());
        return ACTORS_VIEW;
    }

    @RequestMapping("/actors/{id}")
    public String showMovieDetails(@PathVariable String id, Model model) {
        model.addAttribute("actor", actorClientService.getActor(Long.valueOf(id)));
        return ACTOR_DETAILS_VIEW;
    }
}
