package com.TocarronesConMamate.festify_api.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TocarronesConMamate.festify_api.dto.request.CreateArtist;
import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;
import com.TocarronesConMamate.festify_api.dto.service.ArtistService;

import java.util.*;

@RestController
public class ArtistController {

    private final ArtistService artistService;

    private List<ArtistResponse> artists=List.of(
        new ArtistResponse("1", "The Offspring", "Rock Punk", "Murica Land")
    );   //Crea listas que no se pueden editar (o al menos no agregar cosas)

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
        return artists;
    }

    @GetMapping(path="/artists/{id}")
    public ArtistResponse getArtistById(@PathVariable(name="id") String id){
        for(int i=0; i<artists.size(); i++){
            if(artists.get(i).id().equals(id)){
                return artists.get(i);
            }
        }
        return null;
    }

    @PostMapping(path="/artists")
    public ArtistResponse addArtist(@RequestBody CreateArtist artists2){
        int x=0;
        x=artists.size()+1;
        this.artists.add(new ArtistResponse(String.valueOf(artists.size()+1),"", "", ""));
        return artists.get(x);
    }
}
