package com.TocarronesConMamate.festify_api.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TocarronesConMamate.festify_api.dto.request.ArtistRequest;
import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;
import com.TocarronesConMamate.festify_api.dto.service.ArtistService;
import com.TocarronesConMamate.festify_api.persistence.jpa.entity.ArtistEntity;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
public class ArtistController {

    private final ArtistService artistService;

    // private List<ArtistResponse> artists=List.of(
    //     new ArtistResponse("1", "The Offspring", "Rock Punk", "Murica Land")
    // );   //Crea listas que no se pueden editar (o al menos no agregar cosas)

    /*private List<ArtistResponse> artists;

    public ArtistController() {
        this.artists = new ArrayList<>();
        this.artists.add(
            new ArtistResponse("ART-001","Bad Bunny", "Pop","España")
     );
    }*/  //Crea listas que hay que editar con add
    
    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService=artistService;
    }

    @GetMapping(path="/artists")
    public List<ArtistResponse> listArtist(){
        return artistService.ListArtists();
    }

    // @GetMapping(path="/artists/{id}")
    // public List<ArtistResponse> (@PathVariable(name="id") String id){
        
    //     return artistService.getArtistById(id);
    // }

    @PostMapping(path="/artists")
    public ArtistResponse createArtist(@RequestBody ArtistRequest request){
        
        return artistService.createArtist(request);
    }
}
