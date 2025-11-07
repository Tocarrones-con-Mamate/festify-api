package com.TocarronesConMamate.festify_api.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.TocarronesConMamate.festify_api.dto.request.ArtistRequest;
import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;
import com.TocarronesConMamate.festify_api.persistence.jpa.entity.ArtistEntity;
import com.TocarronesConMamate.festify_api.service.ArtistService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import jakarta.validation.Valid;

import java.util.*;

@Tag(name = "Artistas", description = "Gestión de artistas")
@CrossOrigin(origins = "*")
@RestController
public class ArtistController {

    final private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Operation(
            summary = "Lista de artistas",
            description = "Devuelve la lista de los artistas"
    )
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = ArtistResponse.class))
            )
    )
    @GetMapping("/artists")
    @ResponseStatus(HttpStatus.OK)
    public List<ArtistResponse> listArtists(){
        return this.artistService.ListArtists();
    }


    @Operation(
            summary = "Devuelve un artista",
            description = "Devuelve el detalle de un artista"
    )
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = ArtistResponse.class)))
    @ApiResponse(responseCode = "404", description = "Artista no encontrado con el Id proporcionado",
            content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    @GetMapping("/artists/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ArtistResponse getArtist(@PathVariable String id){
        return this.artistService.getArtistById(id);
    }
    @Operation(summary = "Elimina un artista")
    @ApiResponse(responseCode = "204", description = "Eliminado")
    @ApiResponse(responseCode = "404", description = "Artista no encontrado con el Id proporcionado",
            content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    @DeleteMapping("/artists/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable String id){
        this.artistService.deleteArtist(id);
    }
    @Operation(summary = "Crea un artista")
    @ApiResponse(responseCode = "201", description = "Creado",
            content = @Content(schema = @Schema(implementation = ArtistResponse.class)))
    @ApiResponse(responseCode = "400", description = "Error de validación de datos",
            content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    @PostMapping("/artists")
    @ResponseStatus(HttpStatus.CREATED)
    public ArtistResponse createArtist(@Valid @RequestBody ArtistRequest request){
        return this.artistService.createArtist(request);
    }
    @Operation(summary = "Actualiza un artista")
    @ApiResponse(responseCode = "200", description = "Actualizado",
            content = @Content(schema = @Schema(implementation = ArtistResponse.class)))
    @ApiResponse(responseCode = "400", description = "Error de validación de datos",
            content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    @ApiResponse(responseCode = "404", description = "Artista no encontrado con el Id proporcionado",
            content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    @PutMapping("/artists/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ArtistResponse updateArtist(@PathVariable String id, @Valid @RequestBody ArtistRequest request){
        return this.artistService.updateArtist(id,request);
    }
}
