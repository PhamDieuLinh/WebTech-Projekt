package htw.berlin.webtech.service;

import htw.berlin.webtech.demo.api.Bewertung;
import htw.berlin.webtech.demo.api.BewertungManipulationRequest;
import htw.berlin.webtech.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BewertungService {

    @Autowired
    BewertungRepository bewertungRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

    public  BewertungService(BewertungRepository bewertungRepository) {
        this.bewertungRepository = bewertungRepository;
    }

    public List<Bewertung> findAll(){
        List<BewertungEntity> bewertungen = bewertungRepository.findAll();
        return bewertungen.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public Bewertung create(BewertungManipulationRequest request){
        var rating = Rating.valueOf(request.getRating());
        var restaurant = restaurantRepository.findById(request.getRid()).orElseThrow();
        var bewertungEntity= new BewertungEntity(request.getAuthorName(),request.getReview(), rating,restaurant);
        bewertungEntity = bewertungRepository.save(bewertungEntity);
        return transformEntity(bewertungEntity);
    }

    private Bewertung transformEntity(BewertungEntity bewertungEntity){
        return new Bewertung(bewertungEntity.getId(),
                bewertungEntity.getAuthorName(),
                bewertungEntity.getReview(),
                bewertungEntity.getRating(),
                bewertungEntity.getResid().getId());
    }
}

