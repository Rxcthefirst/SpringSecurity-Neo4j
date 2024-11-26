package com.rxcthefirst.springsecurity6.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<MovieEntity> getByTitle(String title) { return movieRepository.findOneByTitle(title);}
    public Optional<MovieEntity> getById(Long id) { return movieRepository.findById(id);}

    public MovieEntity createOrUpdateMovie(MovieEntity movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) { movieRepository.deleteById(id);}
}
