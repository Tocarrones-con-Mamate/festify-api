package com.TocarronesConMamate.festify_api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import com.TocarronesConMamate.festify_api.dto.request.CreateArtistRequest;
import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;
import com.TocarronesConMamate.festify_api.service.ArtistService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController

public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping(path="/artists")
    public List<ArtistResponse> listArtists() {
        return artistService.listArtists();
    }

    // @ResponseStatus(HttpStatus.CREATED)
    // @PostMapping("/artists")
    // public ArtistResponse createArtist(@Valid @RequestBody CreateArtistRequest request){
    //     return this.artistService.createArtist(request);
    // }
}
