package de.volkswagen.filmnightbackend.movies;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/api/v1/movies")
    private ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movieList = movieService.getMovieList();
        return movieList == null || movieList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(movieList);
    }
}
