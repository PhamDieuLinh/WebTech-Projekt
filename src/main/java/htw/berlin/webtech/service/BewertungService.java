package htw.berlin.webtech.service;

import htw.berlin.webtech.demo.api.Bewertung;
import htw.berlin.webtech.persistence.BewertungEntity;
import htw.berlin.webtech.persistence.BewertungRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class BewertungService {

    @Autowired
    BewertungRepository bewertungRepository;

    public  BewertungService(BewertungRepository bewertungtRepository) {
        this.bewertungRepository = bewertungRepository;
    }

    public List<Bewertung> findAll(){
        List<BewertungEntity> bewertungen = bewertungRepository.findAll();
        return bewertungen.stream().map(this::transformEntity).collect(Collectors.toList());

    }
}
