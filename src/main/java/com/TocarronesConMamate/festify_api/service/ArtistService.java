package com.TocarronesConMamate.festify_api.service;
import java.util.List;

import com.TocarronesConMamate.festify_api.dto.request.ArtistRequest;
import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;

public interface ArtistService {
    
    List<ArtistResponse> listArtists();
    
    ArtistResponse newArtist(ArtistRequest request);
}