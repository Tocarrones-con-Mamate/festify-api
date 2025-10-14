package com.TocarronesConMamate.festify_api.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;
import com.TocarronesConMamate.festify_api.mapper.ArtistMapper;
import com.TocarronesConMamate.festify_api.persistence.jpa.entity.ArtistEntity;
import com.TocarronesConMamate.festify_api.persistence.jpa.repository.ArtistJpaRepository;
import com.TocarronesConMamate.festify_api.service.ArtistService;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistJpaRepository artistJpaRepository;

    @Autowired
    public ArtistServiceImpl(ArtistJpaRepository artistJpaRepository) {
        this.artistJpaRepository = artistJpaRepository;
    }

    @Override
    public List<ArtistResponse> listArtists() {
        List<ArtistEntity> artists = this.artistJpaRepository.findAll();
        return artists.stream()
                .map(ArtistMapper::mapArtistToArtistResume)
                .toList();
    }
}