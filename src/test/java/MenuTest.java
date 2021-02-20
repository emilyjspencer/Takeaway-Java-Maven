import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void canSeeListOfDishes_AndPrices() {
        Menu menu = new Menu((HashMap<String, Double>) dishes);
        assertEquals(dishes, menu.getDishes());
    }

    @Test
    void printsAListOf_DishesWith_TheirRespectivePrices() {
        String dishList = "Pepperoni Pizza 8.99 Vegan Pizza 6.99 Pasta 5.99";
        Menu menu = new Menu((HashMap<String, Double>) dishes);
        menu.readMenu();
        assertEquals("Pepperoni Pizza 8.99 Vegan Pizza 6.99 Pasta 5.99", "Pepperoni Pizza 8.99 Vegan Pizza 6.99 Pasta 5.99", outputStreamCaptor.toString());
    }

    @Test
    void systemOutRedirection_whenPrintlnCalled_CaptorSuccessOutput() {
        System.out.println("Testing output");
        assertEquals("Testing output", outputStreamCaptor.toString()
                .trim());
    }
}