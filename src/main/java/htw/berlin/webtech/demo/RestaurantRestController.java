package htw.berlin.webtech.demo;


import htw.berlin.webtech.demo.api.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantRestController {

    private List<Restaurant> restaurants;

    public RestaurantRestController() {
        restaurants = new ArrayList<>();

    }

    @GetMapping(path = "/api")
    public ResponseEntity<List<Restaurant>> fetchRestaurants() {

        return ResponseEntity.ok(restaurants);
    }
}
