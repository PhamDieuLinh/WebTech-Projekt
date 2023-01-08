package htw.berlin.webtech.web;

import htw.berlin.webtech.demo.RestaurantRestController;
import htw.berlin.webtech.demo.api.Restaurant;
import htw.berlin.webtech.service.RestaurantService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static htw.berlin.webtech.persistence.Kategorie.VIETNAMESISCH;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(RestaurantRestController.class)
public class RestaurantRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestaurantService restaurantService;

    @Test
    @DisplayName("should return 404 if restaurant is not found")
    void should_return_404_if_restaurant_is_not_found() throws Exception {
        // given
        doReturn(null).when(restaurantService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/restaurants/99"))
                // then
                .andExpect(status().isNotFound());
    }
    @Test
    @DisplayName("should return found restaurant from restaurant service")
    void should_return_found_restauarnt_from_person_service() throws Exception {
        // given
        var restaurants = List.of(
                new Restaurant(1L, "New Day Vietnam Heritage Food", "Niederbarnimstraße 25, 10247 Berlin", "traditional vietnamese cuisine", VIETNAMESISCH, Collections.emptyList()),
                new Restaurant(2L, "Willis", "Wisbyer Str. 4, 10439 Berlin", "frische und gesunde Spezialitäten aus Vietnam", VIETNAMESISCH, Collections.emptyList())
        );
        doReturn(restaurants).when(restaurantService).findAll();

        // when
        mockMvc.perform(get("/api/v1/restaurants"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("New Day Vietnam Heritage Food"))
                .andExpect(jsonPath("$[0].address").value("Niederbarnimstraße 25, 10247 Berlin"))
                .andExpect(jsonPath("$[0].description").value("traditional vietnamese cuisine"))
                .andExpect(jsonPath("$[0].kategorie").value("VIETNAMESISCH"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Willis"))
                .andExpect(jsonPath("$[1].address").value("Wisbyer Str. 4, 10439 Berlin"))
                .andExpect(jsonPath("$[1].description").value("frische und gesunde Spezialitäten aus Vietnam"))
                .andExpect(jsonPath("$[1].kategorie").value("VIETNAMESISCH"));
    }
}
