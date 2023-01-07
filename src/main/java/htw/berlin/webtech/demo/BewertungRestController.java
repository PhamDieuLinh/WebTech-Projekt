package htw.berlin.webtech.demo;

import htw.berlin.webtech.demo.api.Bewertung;
import htw.berlin.webtech.demo.api.BewertungManipulationRequest;
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
    @GetMapping(path = "/api/v1/bewertungen/restaurant/{resid}")
    public ResponseEntity<List<Bewertung>> fetchBewertungen(@PathVariable Long resid) {
        var bewertungen = bewertungService.findAllByResId(resid);
        return ResponseEntity.ok(bewertungen);
    }
    @GetMapping(path = "/api/v1/bewertungen/{id}")
    public ResponseEntity<Bewertung> fetchBewertungById(@PathVariable Long id){
        var bewertung = bewertungService.findById(id);
        return bewertung != null? ResponseEntity.ok(bewertung) : ResponseEntity.notFound().build();
    }
    @PostMapping(path = "/api/v1/bewertungen")
    public ResponseEntity<Void> createBewertungen(@RequestBody BewertungManipulationRequest request) throws URISyntaxException {
        var bewertung = bewertungService.create(request);
        URI uri = new URI("/api/v1/bewertungen" + bewertung.getId());
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/api/v1/bewertungen/{id}")
    public ResponseEntity<Void> deleteBewertung(@PathVariable Long id) {
        boolean successful = bewertungService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
