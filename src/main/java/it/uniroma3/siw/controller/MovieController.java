package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import it.uniroma3.siw.service.MovieService;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movie/{id}")
    public String getMovie(@PathVariable("id") Long id,Model model) {
        try {
            model.addAttribute("movie", movieService.getMovieById(id));
            return "movie"; // Assicurati che "movie.html" esista in src/main/resources/templates/
        } catch (EntityNotFoundException e) {
            model.addAttribute("errorMessage", "Film con ID " + id + " non trovato");
            return "error"; // Mostra una pagina di errore personalizzata
        }
    }

    @GetMapping("/movies")
    public String getMethodName(Model model) {
        model.addAttribute("movies",this.movieService.getAllMovies());
        return "movies";
    }
    
    
    
}
