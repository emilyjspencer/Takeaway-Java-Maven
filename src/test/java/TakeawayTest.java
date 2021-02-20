import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TakeawayTest {

    static Map<String, Double> itemsPrices = new HashMap<>();
    static {
        itemsPrices.put("Pepperoni Pizza", 8.99);
        itemsPrices.put("Vegan Pizza", 6.99);
        itemsPrices.put("Pasta", 5.99);
    };

    @Mock
    Menu menu;

    @Test
    void hasAListOfMenuItems_AndTheirRespectivePrices() {
        Takeaway takeaway = new Takeaway(menu);
        assertEquals(itemsPrices, takeaway.readMenu(menu));
    }

}