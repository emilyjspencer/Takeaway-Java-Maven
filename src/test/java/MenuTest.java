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

    static Map<String, Double> menuItems = new HashMap<>();
        static {
            menuItems.put("Pepperoni Pizza", 8.99);
            menuItems.put("Vegan Pizza", 6.99);
            menuItems.put("Pasta", 5.99);
        };

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void canSeeListOfDishes_AndPrices() {
        Menu menu = new Menu((HashMap<String, Double>) menuItems);
        assertEquals(menuItems, menu.getDishes());
    }

    @Test
    void printsAListOf_DishesWith_TheirRespectivePrices() {
        String dishList = "Pepperoni Pizza 8.99 Vegan Pizza 6.99 Pasta 5.99";
        Menu menu = new Menu((HashMap<String, Double>) menuItems);
        menu.readMenu();
        assertEquals("Pepperoni Pizza 8.99 Vegan Pizza 6.99 Pasta 5.99", dishList, outputStreamCaptor.toString());
    }

    @Test
    void verifiesThatDish_IsOnTheMenu() {
        Menu menu = new Menu((HashMap<String, Double>) menuItems);
        assertEquals(true, menu.includesItem("Vegan Pizza"));
    }

    @Test
    void throwsErrorIfDish_IsNotOnTheMenu() {
        Menu menu = new Menu((HashMap<String, Double>) menuItems);
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    boolean result = menu.includesItem("Chicken Burger");
                }
        );
        assertEquals("Item is not on the menu", exception.getMessage());
    }

    @Test
    void returnsPriceOfItem() {
        Menu menu = new Menu((HashMap<String, Double>) menuItems);
        assertEquals(6.99, menu.getPrice("Vegan Pizza"));

    }

    @Test
    void systemOutRedirection_whenPrintlnCalled_CaptorSuccessOutput() {
        System.out.println("Testing output");
        assertEquals("Testing output", outputStreamCaptor.toString()
                .trim());
    }
}