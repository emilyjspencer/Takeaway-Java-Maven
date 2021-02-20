import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class MenuTest {

    static Map<String, Double> dishes = new HashMap<>();
        static {
            dishes.put("Pepperoni Pizza", 8.99);
            dishes.put("Vegan Pizza", 6.99);
            dishes.put("Pasta", 5.99);
        };

    @Test
    void canSeeListOfDishes_AndPrices() {
        Menu menu = new Menu((HashMap<String, Double>) dishes);
        assertEquals(dishes, menu.getDishes());
    }

}