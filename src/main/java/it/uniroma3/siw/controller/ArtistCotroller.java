package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import it.uniroma3.siw.service.ArtistService;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class ArtistCotroller {

    @Autowired
    public ArtistService artistService;

    @GetMapping("/Artist/{id}")
    public String getArtist(@PathVariable("id") Long id,Model model) {
        try {
            model.addAttribute("movie", artistService.getArtistById(id));
            return "artist"; // Assicurati che "movie.html" esista in src/main/resources/templates/
        } catch (EntityNotFoundException e) {
            model.addAttribute("errorMessage", "artista con ID " + id + " non trovato");
            return "error"; // Mostra una pagina di errore personalizzata
        }
    }

    @GetMapping("/Artists")
    public String getArtists(Model model) {
        model.addAttribute("artists", artistService.getAllArtist());
        return "artists";
    }
    
    
    
}
