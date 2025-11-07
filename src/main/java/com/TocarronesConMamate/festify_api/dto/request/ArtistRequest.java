package com.TocarronesConMamate.festify_api.dto.request;
import java.util.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;



public record ArtistRequest (
    Integer id,
 
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 255)
    String name,
 
    @NotEmpty(message = "Debe tener al menos un género")
    List<String> genres,
 
    @Pattern(regexp = "^[A-Z]{2}$", message = "Debe ser un código de país de 2 letras (ES, US, GB...)")
    String country,
 
    @PositiveOrZero(message = "Los oyentes no pueden ser negativos")
    Integer listeners,
   
    @Pattern(regexp = "^Activo|Borrador$", message = "El estado del artista debe ser Activo o Borrador")
    String status
    ) {}