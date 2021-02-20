import java.util.HashMap;
import java.util.Map;

public class Menu {

    Map<String, Double> dishes = new HashMap<String, Double>();

   public Menu(HashMap<String, Double> dishes) {
       this.dishes = dishes;
   }

   public HashMap<String, Double> getDishes() {
       return (HashMap<String, Double>) dishes;
   }


}
