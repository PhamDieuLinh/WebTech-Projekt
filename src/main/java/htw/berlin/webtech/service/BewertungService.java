package htw.berlin.webtech.service;

import htw.berlin.webtech.demo.api.Bewertung;
import htw.berlin.webtech.demo.api.BewertungManipulationRequest;
import htw.berlin.webtech.persistence.BewertungEntity;
import htw.berlin.webtech.persistence.BewertungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import htw.berlin.webtech.persistence.RestaurantRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BewertungService {

    @Autowired
    BewertungRepository bewertungRepository;
    RestaurantRepository restaurantRepository;
    RestaurantTransformer restaurantTransformer;

    public  BewertungService(BewertungRepository bewertungRepository) {
        this.bewertungRepository = bewertungRepository;
    }

    public List<Bewertung> findAll(){
        List<BewertungEntity> bewertungen = bewertungRepository.findAll();
        return bewertungen.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    private Bewertung transformEntity(BewertungEntity bewertungEntity){
        return new Bewertung(bewertungEntity.getId(),
                bewertungEntity.getAuthorName(),
                bewertungEntity.getReview(),
                bewertungEntity.getRating(),
                bewertungEntity.getResid().getRid());
    }
}

