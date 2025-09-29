package web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.TocarronesConMamate.festify_api.dto.response.ArtistResponse;
import java.util.*;

@RestController
public class ArtistController {

    private List<ArtistResponse> artists=List.of(
        new ArtistResponse("1", "The Offspring", "Rock Punk", "Murica Land")
    );   //Crea listas que no se pueden editar (o al menos no agregar cosas)

    /*private List<ArtistResponse> artists;

    public ArtistController() {
        this.artists = new ArrayList<>();
        this.artists.add(
            new ArtistResponse("ART-001","Bad Bunny", "Pop","España")
     );
    }*/  //Crea listas que hay que editar con add

    @GetMapping(path="/artists")
    public List<ArtistResponse> listArtist(){
        return artists;
    }


}
