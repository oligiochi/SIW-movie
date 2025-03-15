package it.uniroma3.siw.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Movie;
import it.uniroma3.siw.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
                //.orElseThrow(() -> new EntityNotFoundException("Film con ID " + id + " non trovato"));
    }


    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
