package htw.berlin.webtech.demo;

import htw.berlin.webtech.demo.api.Bewertung;
import htw.berlin.webtech.service.BewertungService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class BewertungRestController {

    private final BewertungService bewertungService;

    public BewertungRestController(BewertungService bewertungService) {
        this.bewertungService = bewertungService;
    }


    @GetMapping(path = "/api/v1/bewertung")
    public ResponseEntity<List<Bewertung>> fetchBewertungen() {
        var bewertungen = bewertungService.findAll();

        return ResponseEntity.ok(bewertungen);
    }


}
