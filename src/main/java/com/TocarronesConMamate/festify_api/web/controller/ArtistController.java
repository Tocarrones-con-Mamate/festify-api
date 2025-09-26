package com.TocarronesConMamate.festify_api.web.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class ArtistController {
    
    public String getArtists() {
        return "List of artists";
    }

}
