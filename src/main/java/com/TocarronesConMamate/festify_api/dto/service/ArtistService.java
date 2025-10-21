package com.TocarronesConMamate.festify_api.dto.service;

import java.util.*;
import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;
import com.TocarronesConMamate.festify_api.dto.request.ArtistRequest;

public interface ArtistService {
    
    List<ArtistResponse> ListArtists();

    ArtistResponse createArtist(ArtistRequest request); // ¡Duda! Porque es ArtistResponse y no public ArtistResponse
    


    // ArtistResponse updateArtist(String id, ArtistRequest request);

    // ArtistResponse getArtistById(String id);

    // void deleteArtist(String id);

}

