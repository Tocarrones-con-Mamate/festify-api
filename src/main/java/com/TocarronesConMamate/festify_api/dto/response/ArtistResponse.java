package com.TocarronesConMamate.festify_api.dto.response;

import java.util.List;

public record ArtistResponse(String  id, String name, String country, List<String> genres, Integer listeners) {
}