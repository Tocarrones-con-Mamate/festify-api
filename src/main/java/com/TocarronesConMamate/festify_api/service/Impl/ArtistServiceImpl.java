package com.TocarronesConMamate.festify_api.service.Impl;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TocarronesConMamate.festify_api.dto.request.ArtistRequest;
import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;
import com.TocarronesConMamate.festify_api.mapper.ArtistMapper;
import com.TocarronesConMamate.festify_api.persistence.jpa.entity.ArtistEntity;
import com.TocarronesConMamate.festify_api.persistence.jpa.repository.ArtistJpaRepository;
import com.TocarronesConMamate.festify_api.service.ArtistService;
import com.util.exception.InvalidIdException;

@Service
public class ArtistServiceImpl implements ArtistService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    final private ArtistJpaRepository artistJpaRepository;

    @Autowired
    public ArtistServiceImpl(ArtistJpaRepository artistJpaRepository){

        this.artistJpaRepository=artistJpaRepository;

    }

    @Override
    public List<ArtistResponse> ListArtists() {

            List<ArtistEntity> artists = this.artistJpaRepository.findAll();

            return artists.stream().map(ArtistMapper::mapArtistToArtistResponse).toList();
        
    }

    @Override
    public ArtistResponse createArtist(ArtistRequest request) {

    ArtistEntity artists = ArtistMapper.mapArtistRequestToArtistEntity(request);
    
    ArtistEntity result = this.artistJpaRepository.save(artists);
    
    return ArtistMapper.mapArtistToArtistResponse(result);

    }

    
    @Override
    public ArtistResponse updateArtist(String strid, ArtistRequest request) {

        Long id = parseArtistId(strid);
        
        ArtistEntity artists = ArtistMapper.mapArtistRequestToArtistEntity(request);
    
        artists.setId(id);

        logger.info("Update artist with id {}", artists.getId());
        ArtistEntity result = this.artistJpaRepository.save(artists);
        return ArtistMapper.mapArtistToArtistResponse(result);

    }

    @Override
    public ArtistResponse getArtistById(String strid) {
        Long id = parseArtistId(strid);
        Optional<ArtistEntity> artist = this.artistJpaRepository.findById(id);
        return ArtistMapper.mapArtistToArtistResponse(artist.get());
    }

    @Override
    public void deleteArtist(String strid) {
        Long id = parseArtistId(strid);
        this.artistJpaRepository.deleteById(id);
    }

    private Long parseArtistId(String strid) {
        try {
            strid = strid.trim().replace("ART-","");
            Long id = Integer.valueOf(strid).longValue();
            return id;
        }catch (NumberFormatException e) {
            throw new InvalidIdException("Invalid artist id " + strid);
        }
    }

}
