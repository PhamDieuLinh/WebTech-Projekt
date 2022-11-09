package htw.berlin.webtech.service;

import htw.berlin.webtech.demo.api.Restaurant;
import htw.berlin.webtech.demo.api.RestaurantCreateRequest;
import htw.berlin.webtech.persistence.RestaurantEntity;
import htw.berlin.webtech.persistence.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> findAll(){
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();
        return restaurants.stream().map(this::transformEntity).collect(Collectors.toList());

    }

    public Restaurant create(RestaurantCreateRequest request){
        var restaurantEntity = new RestaurantEntity(request.getName(), request.getAddress(), request.getDescription());
        restaurantEntity = restaurantRepository.save(restaurantEntity);
        return transformEntity(restaurantEntity);
    }

    private Restaurant transformEntity(RestaurantEntity restaurantEntity){
        return new Restaurant(restaurantEntity.getRid(), restaurantEntity.getName(), restaurantEntity.getAddress(), restaurantEntity.getDescription());
    }

}
