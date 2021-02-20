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

   public Menu readMenu() {
       for (String i : dishes.keySet()) {
           System.out.println(i + " " + dishes.get(i));
       }
       return null;
   }

    public boolean includesItem(String item) {
       if (dishes.containsKey(item)) {
           return true;
       }
       return false;
    }

    public double getPrice(String item) {
        double result = 0;
        for (String i : dishes.keySet()) {
            result = dishes.get(i);
        }
        return result;
    }

}
