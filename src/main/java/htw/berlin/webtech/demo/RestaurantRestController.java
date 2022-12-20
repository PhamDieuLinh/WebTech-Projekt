package htw.berlin.webtech.demo;


import htw.berlin.webtech.demo.api.Restaurant;
import htw.berlin.webtech.demo.api.RestaurantManipulationRequest;
import htw.berlin.webtech.service.RestaurantService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
//https://www.bing.com/videos/search?q=backend+cors+enable+java&&view=detail&mid=910E19DD1F4ED0341E16910E19DD1F4ED0341E16&&FORM=VRDGAR&ru=%2Fvideos%2Fsearch%3Fq%3Dbackend%2520cors%2520enable%2520java%26qs%3Dn%26form%3DQBVDMH%26%3D%2525eIhren%2520Suchverlauf%2520verwalten%2525E%26sp%3D-1%26pq%3Dbackend%2520cors%2520enable%2520java%26sc%3D0-24%26sk%3D%26cvid%3D0630400FA2464669B076D9FCF44829E7%26ghsh%3D0%26ghacc%3D0%26ghpl%3D
    @Configuration
    public class MyConfiguration {

        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**")
                            .allowedMethods("GET","POST","PUT","DELETE")
                            .allowedHeaders("*")
                            .allowedOrigins("http://localhost:3000","https://webtech-aresto-frontend.herokuapp.com");
                }
            };
        }
    }
}

