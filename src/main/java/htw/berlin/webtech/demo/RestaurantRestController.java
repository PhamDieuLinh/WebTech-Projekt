package htw.berlin.webtech.demo;


import htw.berlin.webtech.demo.api.Restaurant;
import htw.berlin.webtech.demo.api.RestaurantCreateRequest;
import htw.berlin.webtech.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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

    @GetMapping(path = "/api/v1/restaurants/{id}")
    public ResponseEntity<Restaurant> fetchRestaurantById(@PathVariable Long id) {
        var restaurant = restaurantService.findById(id);
        return restaurant != null? ResponseEntity.ok(restaurant) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> createRestaurant(@RequestBody RestaurantCreateRequest request) throws URISyntaxException {
      var restaurant = restaurantService.create(request);
      URI uri = new URI("/api/v1/restaurants" + restaurant.getRid());
      return ResponseEntity.created(uri).build();
   }

}

