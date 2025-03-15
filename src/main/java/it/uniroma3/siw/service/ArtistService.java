package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Artist;
import it.uniroma3.siw.repository.ArtistRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public Artist getArtistById(Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Artista con ID " + id + " non trovato"));
    }

    public Iterable<Artist> getAllArtist() {
        return artistRepository.findAll();
    }

}
