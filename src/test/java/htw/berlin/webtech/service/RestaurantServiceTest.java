package htw.berlin.webtech.service;

import htw.berlin.webtech.persistence.RestaurantRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest  implements WithAssertions {

    @Mock
    private RestaurantRepository repository;

    @InjectMocks
    private RestaurantService underTest;

    @Test
    @DisplayName("should return false if restaurant to delete does not exist")
    void should_return_false_if_restaurant_to_delete_does_not_exist() {
        // given
        Long givenId =99L;
        doReturn(false).when(repository).existsById(givenId);

        // when
        boolean result = underTest.deleteById(givenId);

        // then
        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("should return true if delete was successful")
    void should_return_true_if_delete_was_successful() {

        Long givenId = 14L;
        doReturn(true).when(repository).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }
}
