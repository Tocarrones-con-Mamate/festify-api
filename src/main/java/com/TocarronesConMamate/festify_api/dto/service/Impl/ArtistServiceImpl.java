package com.TocarronesConMamate.festify_api.dto.service.Impl;

import java.util.List;

import org.springframework.*;

import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;
import com.TocarronesConMamate.festify_api.dto.service.ArtistService;

//@Service
public class ArtistServiceImpl implements ArtistService{

    //private final ArtistJpaRepository repo;

    /*public ArtistServiceImp(ArtistJpaRepository repo){

        this.repo=repo;

    }*/

    @Override
    public List<ArtistResponse> ListArtists() {
        List<ArtistResponse> artists=List.of(
        new ArtistResponse("1", "The Offspring", "Rock Punk", "Murica Land"),
        
        new ArtistResponse("2", "Three Days Grace", "Rock Alternativo", "Cánada"),
        
        new ArtistResponse("3", "Melendi", "Pop", "Murica Land")
    );

        return artists;
        
    }
    


}
