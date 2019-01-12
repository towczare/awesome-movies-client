package pl.sda.awesomemovies.client.movie.trends;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@Slf4j
public class MovieTrendServiceTests {

    @Autowired
    private MovieTrendService movieTrendService;

//    @Test
//    public void getMovieTrends() {
//        MovieTrendPage<MovieTrend> trends = movieTrendService.getTrends();
//        for (MovieTrend trend : trends.getResults()) {
//            log.info(trend.toString());
//        }
//    }

}
