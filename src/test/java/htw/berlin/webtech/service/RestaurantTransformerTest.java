package htw.berlin.webtech.service;

import htw.berlin.webtech.persistence.BewertungEntity;
import htw.berlin.webtech.persistence.Kategorie;
import htw.berlin.webtech.persistence.RestaurantEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static htw.berlin.webtech.persistence.Kategorie.VIETNAMESISCH;
import static org.mockito.Mockito.doReturn;

public class RestaurantTransformerTest implements WithAssertions {
    private final RestaurantTransformer underTest = new RestaurantTransformer();

    @Test
    @DisplayName("should transform RestaurantEntity to Restaurant")
    void should_transform_restaurant_entity_to_restaurant() {
        // given
        var restaurantEntity = Mockito.mock(RestaurantEntity.class);
        doReturn(3L).when(restaurantEntity).getId();
        doReturn("Asia Song Hong").when(restaurantEntity).getName();
        doReturn("Warschauerstraße 25, 10243 Berlin").when(restaurantEntity).getAddress();
        doReturn("billiges vietnamesisches Essen").when(restaurantEntity).getDescription();
        doReturn(VIETNAMESISCH).when(restaurantEntity).getKategorie();
        doReturn(List.of(new BewertungEntity())).when(restaurantEntity).getBewertungen();
        var result = underTest.transformEntity(restaurantEntity);

        assertThat(result.getId()).isEqualTo(3);
        assertThat(result.getName()).isEqualTo("Asia Song Hong");
        assertThat(result.getAddress()).isEqualTo("Warschauerstraße 25, 10243 Berlin");
        assertThat(result.getDescription()).isEqualTo("billiges vietnamesisches Essen");
        assertThat(result.getKategorie()).isEqualTo(VIETNAMESISCH);
        assertThat(result.getBewertungIds()).hasSize(1);
    }
}
