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

    @Autowired
    RestaurantTransformer restaurantTransformer;

    public  BewertungService(BewertungRepository bewertungRepository) {
        this.bewertungRepository = bewertungRepository;
    }

    public List<Bewertung> findAll(){
        List<BewertungEntity> bewertungen = bewertungRepository.findAll();
        return bewertungen.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public Bewertung findById(Long id){
        var bewertungEntity = bewertungRepository.findById(id);
        return bewertungEntity.map(this::transformEntity).orElse(null);
    }
    public List<Bewertung> findAllByResId(Long restaurantid){
        var optionalRestaurantEntity = restaurantRepository.findById(restaurantid);
        var restaurantEntity = optionalRestaurantEntity.get();
        List<BewertungEntity> bewertungen = bewertungRepository.findAllByResid(restaurantEntity);
        return bewertungen.stream().map(this::transformEntity).collect(Collectors.toList());
    }


    public Bewertung create(BewertungManipulationRequest request){
        var restaurant = restaurantRepository.findById(request.getRid()).orElseThrow();
        var rating = Rating.valueOf(request.getRating()).getValue();
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

    public boolean deleteById(Long id){
        if(!bewertungRepository.existsById(id)){
            return false;
        }
        bewertungRepository.deleteById(id);
        return true;
    }
}

