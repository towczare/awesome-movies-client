package pl.sda.awesomemovies.client.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import pl.sda.awesomemovies.client.movie.Movie;
import pl.sda.awesomemovies.client.movie.MovieClientController;
import pl.sda.awesomemovies.client.movie.MovieClientService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MovieClientControllerTest {

    @Mock
    MovieClientService movieClientService;

    @Mock
    Model model;

    MovieClientController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new MovieClientController(movieClientService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void showMovieDetails() throws Exception {
        // Given
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setName("Star Wars");
        when(movieClientService.getMovie(anyLong())).thenReturn(movie);

        // When
        mockMvc.perform(get("/movie/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("movie"))
                .andExpect(model().attributeExists("movie"));

        // Then
        verify(movieClientService, times(1)).getMovie(anyLong());
    }

    @Test
    public void getMovieListTest() {

        // Given
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(2L, "Incepcja"));
        movies.add(new Movie(3L, "Game of Thrones"));

        when(movieClientService.getAllMovies()).thenReturn(movies);

        ArgumentCaptor<List<Movie>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        // When
        String viewName = controller.getMovieList(model);

        // Then
        assertEquals("movies", viewName);

        verify(movieClientService, times(1)).getAllMovies();
        verify(model, times(1)).addAttribute(eq("movies"), argumentCaptor.capture());
        List<Movie> listInController = argumentCaptor.getValue();
        assertEquals(2, listInController.size());
    }


}
