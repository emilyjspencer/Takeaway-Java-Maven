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

   public void readMenu() {
       for (String i : dishes.keySet()) {
           System.out.println(i + " " + dishes.get(i));
       }
   }

    public boolean includes_item(String item) {
       if (dishes.containsKey(item)) {
           return true;
       }
       return false;
    }

}
