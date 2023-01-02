package htw.berlin.webtech.service;

import htw.berlin.webtech.demo.api.Restaurant;
import htw.berlin.webtech.demo.api.RestaurantManipulationRequest;
import htw.berlin.webtech.persistence.Kategorie;
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
    RestaurantTransformer restaurantTransformer;



    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantTransformer = restaurantTransformer;
    }

    public List<Restaurant> findAll(){
        List<RestaurantEntity> restaurants = restaurantRepository.findAll();
        return restaurants.stream().map(restaurantTransformer::transformEntity).collect(Collectors.toList());

    }

    public Restaurant findById(Long id){
        var restaurantEntity = restaurantRepository.findById(id);
        return restaurantEntity.map(restaurantTransformer::transformEntity).orElse(null);
    }

    public Restaurant create(RestaurantManipulationRequest request){
        var restaurantEntity = new RestaurantEntity(request.getName(), request.getAddress(), request.getDescription(), request.getKategorie());
        restaurantEntity = restaurantRepository.save(restaurantEntity);
        return restaurantTransformer.transformEntity(restaurantEntity);
    }

    public Restaurant update(Long id, RestaurantManipulationRequest request){
        var restaurantEntityOptional = restaurantRepository.findById(id);
        if(restaurantEntityOptional.isEmpty()){
            return null;
        }
        var restaurantEntity = restaurantEntityOptional.get();
        restaurantEntity.setName(request.getName());
        restaurantEntity.setAddress(request.getAddress());
        restaurantEntity.setDescription(request.getDescription());
        restaurantEntity.setKategorie(request.getKategorie());
        restaurantRepository.save(restaurantEntity);
        return restaurantTransformer.transformEntity(restaurantEntity);
    }
    public boolean deleteById(Long id){
        if(!restaurantRepository.existsById(id)){
            return false;
        }
        restaurantRepository.deleteById(id);
        return true;
    }

}
