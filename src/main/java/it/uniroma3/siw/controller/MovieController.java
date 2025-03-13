package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import it.uniroma3.siw.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movie/{id}")
    public String getMovie(@PathVariable("id") Long id,Model model) {
        model.addAttribute("movie",this.movieService.getMovieById(id));
        return "movie.html";
    }

    @GetMapping("/movies")
    public String getMethodName(Model model) {
        model.addAttribute("movies",this.movieService.getAllMovies());
        return "movies.html";
    }
    
    
    
}
