package htw.berlin.webtech.service;

import htw.berlin.webtech.demo.api.Restaurant;
import htw.berlin.webtech.persistence.BewertungEntity;
import htw.berlin.webtech.persistence.RestaurantEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RestaurantTransformer {

    public Restaurant transformEntity(RestaurantEntity restaurantEntity){
        var bewertungenIds = restaurantEntity.getBewertungen().stream().map(BewertungEntity::getId).collect(Collectors.toList());
        return new Restaurant(restaurantEntity.getId(),
                restaurantEntity.getName(),
                restaurantEntity.getAddress(),
                restaurantEntity.getDescription(),
                restaurantEntity.getKategorie(),
                bewertungenIds);
    }
}
