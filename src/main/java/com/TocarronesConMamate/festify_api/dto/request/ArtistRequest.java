package com.TocarronesConMamate.festify_api.dto.request;

import java.util.List;

import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;
import com.TocarronesConMamate.festify_api.persistence.jpa.entity.ArtistEntity;

    public record ArtistRequest (String name, String country, List<String> genres, Integer listeners) {
    
        public static ArtistResponse mapArtistToArtistResume(ArtistEntity artistEntity) {
            return new ArtistResponse(
                "ART-"+artistEntity.getId(),
                artistEntity.getName(),
                artistEntity.getCountry(),
                artistEntity.getGenres(),
                artistEntity.getListeners(),
                artistEntity.getStatus());
        }
    
    }
