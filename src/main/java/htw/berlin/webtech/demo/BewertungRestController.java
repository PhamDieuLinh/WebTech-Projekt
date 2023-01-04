package htw.berlin.webtech.demo;

import htw.berlin.webtech.demo.api.Bewertung;
import htw.berlin.webtech.demo.api.BewertungManipulationRequest;
import htw.berlin.webtech.demo.api.RestaurantManipulationRequest;
import htw.berlin.webtech.service.BewertungService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class BewertungRestController {

    private final BewertungService bewertungService;

    public BewertungRestController(BewertungService bewertungService) {
        this.bewertungService = bewertungService;
    }


    @GetMapping(path = "/api/v1/bewertungen")
    public ResponseEntity<List<Bewertung>> fetchBewertungen() {
        var bewertungen = bewertungService.findAll();

        return ResponseEntity.ok(bewertungen);
    }

    @PostMapping(path = "/api/v1/bewertungen")
    public ResponseEntity<Void> createBewertungen(@RequestBody BewertungManipulationRequest request) throws URISyntaxException {
        var bewertung = bewertungService.create(request);
        URI uri = new URI("/api/v1/bewertungen" + bewertung.getId());
        return ResponseEntity.created(uri).build();
    }


}
