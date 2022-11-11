package htw.berlin.webtech.demo;


import htw.berlin.webtech.demo.api.Restaurant;
import htw.berlin.webtech.demo.api.RestaurantManipulationRequest;
import htw.berlin.webtech.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping(path = "/api/v1/restaurants")
    public ResponseEntity<Void> createRestaurant(@RequestBody RestaurantManipulationRequest request) throws URISyntaxException {
      var restaurant = restaurantService.create(request);
      URI uri = new URI("/api/v1/restaurants" + restaurant.getRid());
      return ResponseEntity.created(uri).build();
   }

   @PutMapping(path = "/api/v1/restaurants/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long  id, @RequestBody RestaurantManipulationRequest request ) {
       var restaurant = restaurantService.update(id, request) ;
       return restaurant != null? ResponseEntity.ok(restaurant) : ResponseEntity.notFound().build();
   }

   @DeleteMapping(path = "/api/v1/restaurants/{id}")
   public ResponseEntity<Void> deleteRestaurant(@PathVariable Long  id) {
       boolean successful = restaurantService.deleteById(id) ;
       return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
   }
}

