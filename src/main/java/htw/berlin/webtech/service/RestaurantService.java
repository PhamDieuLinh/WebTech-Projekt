package htw.berlin.webtech.service;

import htw.berlin.webtech.demo.api.Restaurant;
import htw.berlin.webtech.persistence.RestaurantEntity;
import htw.berlin.webtech.persistence.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> findAll(){
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();
        return restaurants.stream().map(restaurantEntity -> new Restaurant(restaurantEntity.getRid(), restaurantEntity.getName(), restaurantEntity.getAddress(), restaurantEntity.getDescription())).collect(Collectors.toList());

    }

}
