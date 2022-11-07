package htw.berlin.webtech.demo;


import htw.berlin.webtech.demo.api.Restaurant;
import htw.berlin.webtech.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantRestController {

    private final RestaurantService restaurantService;

    public RestaurantRestController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping(path = "/api/v1/restaurants")
    public ResponseEntity<List<Restaurant>> fetchRestaurants() {
        var restaurants = restaurantService.findAll();

        return ResponseEntity.ok(restaurants);
    }
}

