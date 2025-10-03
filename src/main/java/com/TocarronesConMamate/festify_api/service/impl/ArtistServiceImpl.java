package com.TocarronesConMamate.festify_api.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;
import com.TocarronesConMamate.festify_api.service.ArtistService;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Override
    public List<ArtistResponse> listArtists() {
        List<ArtistResponse> artists = List.of(
        new ArtistResponse("1", "The Rolling Stones", "Rock", "UK"),
        new ArtistResponse("2", "Beyoncé", "Pop, R&B", "USA"),
        new ArtistResponse("3", "Bad Bunny", "Reggaeton", "Puerto Rico"),
        new ArtistResponse("4", "Adele", "Pop", "UK"),
        new ArtistResponse("5", "Chayanne", "Hip-Hop", "Canada")
    );
        return artists;
    }

}
