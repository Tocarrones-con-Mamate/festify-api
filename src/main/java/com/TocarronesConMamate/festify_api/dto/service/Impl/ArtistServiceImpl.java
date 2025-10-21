package com.TocarronesConMamate.festify_api.dto.service.Impl;

import java.util.List;

import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TocarronesConMamate.festify_api.ArtistMapper;
import com.TocarronesConMamate.festify_api.dto.request.ArtistRequest;
import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;
import com.TocarronesConMamate.festify_api.dto.service.ArtistService;
import com.TocarronesConMamate.festify_api.persistence.jpa.entity.ArtistEntity;
import com.TocarronesConMamate.festify_api.persistence.jpa.repository.ArtistJpaRepository;

@Service
public class ArtistServiceImpl implements ArtistService{

    //private static final ArtistJpaRepository repo;

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
    // private Long parseArtistId(String strId) {
    // try {
    //     strId = strId.trim().replace("ART-","");
    //     Long id = Integer.valueOf(strId).longValue();
    //     return id;
    // }catch (NumberFormatException e) {
    //     throw new InvalidIdException("Invalid artist id " + strId);
    // }
// }

    @Override
    public ArtistResponse createArtist(ArtistRequest request) {

    ArtistEntity artists = ArtistMapper.mapArtistRequestToArtistEntity(request);
    
    ArtistEntity result = this.artistJpaRepository.save(artists);
    
    return ArtistMapper.mapArtistToArtistResponse(result);

    }

    
    // @Override
    // public ArtistResponse updateArtist(String id, ArtistRequest request) {
    //     
    //     throw new UnsupportedOperationException("Unimplemented method 'updateArtist'");
    // }

    // @Override
    // public ArtistResponse getArtistById(String id) {
    //     
    //     throw new UnsupportedOperationException("Unimplemented method 'getArtistById'");
    // }

    // @Override
    // public void deleteArtist(String id) {
    //     
    //     throw new UnsupportedOperationException("Unimplemented method 'deleteArtist'");
    // }

    // @Override
    // public ArtistRequest request(String name, String genre, String country) {
    //     
    //     throw new UnsupportedOperationException("Unimplemented method 'request'");
    // }
}
