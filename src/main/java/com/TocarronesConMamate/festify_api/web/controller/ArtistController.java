package com.TocarronesConMamate.festify_api.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;

@RestController

public class ArtistController {
    
    //private List<ArtistResponse> artists;
    //public ArtistController() {
        //this.artists = new ArrayList<>();
        //this.artists.add(
            //new ArtistResponse("ART-001","Bad Bunny", "Pop","España")
        //);
    //}
 

    private List<ArtistResponse> artists = List.of(
        new ArtistResponse("1", "The Rolling Stones", "Rock", "UK"),
        new ArtistResponse("2", "Beyoncé", "Pop", "USA"),
        new ArtistResponse("3", "Bad Bunny", "Reggaeton", "Puerto Rico"),
        new ArtistResponse("4", "Adele", "Pop", "UK"),
        new ArtistResponse("5", "Drake", "Hip-Hop", "Canada")
    );

    @GetMapping(path="/artists")
    public List<ArtistResponse> listArtists() {
        return artists;
    }

    @GetMapping(path="/artists/{id}")
    public ArtistResponse getArtistById(@PathVariable(name = "id") String id) {
        return artists.stream()
            .filter(artist -> artist.id().equals(id))
            .findFirst()
            .orElse(null);
    }

    @DeleteMapping(path="/artists/{id}")
    public String deleteArtist(@PathVariable(name = "id") String id) {
        for (ArtistResponse artist : artists) {
            if (artist.id().equals(id)) {
                artists.remove(artist);
            }
        }
        return "El Artista " + id + " se ha borrado correctamente";
    }

}
