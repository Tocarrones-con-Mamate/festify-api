package com.TocarronesConMamate.festify_api.mapper;

import com.TocarronesConMamate.festify_api.dto.request.ArtistRequest;
import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;
import com.TocarronesConMamate.festify_api.persistence.jpa.entity.ArtistEntity;

public class ArtistMapper {

    public static ArtistResponse mapArtistToArtistResume(ArtistEntity artistEntity) {
        return new ArtistResponse(
                "ART-"+artistEntity.getId(),
                artistEntity.getName(),
                artistEntity.getCountry(),
                artistEntity.getGenres(),
                artistEntity.getListeners(),
                artistEntity.getStatus());
    }

    public static ArtistEntity mapArtistRequestToArtistEntity(ArtistRequest request) {
        return new ArtistEntity(request.name(),request.genres(),request.country(),request.listeners());
    }

}

