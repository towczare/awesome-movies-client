package pl.sda.awesomemovies.client.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ActorClientService {

    private final ActorRestService actorRestService;

    @Autowired
    public ActorClientService(ActorRestService actorRestService) {
        this.actorRestService = actorRestService;
    }

    List<Actor> getAllActors() {
        try {
            Actor[] actors = actorRestService.provide().getForObject(
                    actorRestService.getEndpointUrl() + "/actors",
                    Actor[].class
            );
            return Arrays.asList(actors);
        } catch (RestClientException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    Actor getActor(Long id) {
        try {
            return actorRestService.provide().getForObject(
                    actorRestService.getEndpointUrl() + "/actor/" + id,
                    Actor.class
            );
        } catch (RestClientException e) {
            e.printStackTrace();
            return new Actor();
        }
    }
}
