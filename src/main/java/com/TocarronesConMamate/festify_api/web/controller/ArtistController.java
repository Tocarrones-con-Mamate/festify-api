package com.TocarronesConMamate.festify_api.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.TocarronesConMamate.festify_api.dto.request.ArtistRequest;
import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;
import com.TocarronesConMamate.festify_api.service.ArtistService;
import com.TocarronesConMamate.festify_api.mapper.*;
import com.TocarronesConMamate.festify_api.dto.request.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

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

    @PostMapping(path="/artists")
    public ArtistResponse newArtist(@Valid @RequestBody ArtistRequest request) {
        return artistService.newArtist(request);
    }

    @DeleteMapping(path="/artists/{id}")
    public void deleteArtist(@PathVariable ArtistRequest delete) {
        artistService.deleteArtist(delete);
    }
}
