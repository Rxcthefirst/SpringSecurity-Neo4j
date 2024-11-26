package com.rxcthefirst.springsecurity6.movie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;
    private final MovieRepository movieRepository;
    public MovieController(MovieService movieService, MovieRepository movieRepository) {
        this.movieService = movieService;
        this.movieRepository = movieRepository;
    }
    //method implementations with walkthroughs below

    @PutMapping
    public ResponseEntity<MovieEntity> createOrUpdateMovie(@RequestBody MovieEntity newMovie) {
        MovieEntity updatedMovie = movieService.createOrUpdateMovie(newMovie);
        return new ResponseEntity<>(updatedMovie, HttpStatus.CREATED);
    }

    @GetMapping(value = { "", "/" })
    public ResponseEntity<List<MovieEntity>> getMovies() {
        List<MovieEntity> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/by-title/{title}")
    public ResponseEntity<Optional<MovieEntity>> byTitle(@PathVariable String title) {
        Optional<MovieEntity> optionalMovie = movieService.getByTitle(title);
        return new ResponseEntity<>(optionalMovie, HttpStatus.OK);
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<Optional<MovieEntity>> byId(@PathVariable Long id) {
        Optional<MovieEntity> optionalMovie = movieService.getById(id);
        return new ResponseEntity<>(optionalMovie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}