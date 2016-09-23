import java.util.*;
public class hashtable {

    public static void main(String[] args) {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("cilantro");
        ingredients.add("mango");
        ingredients.add("onion");
        ingredients.add("lime");

        Map<Integer, String> recipeIngredients = new HashMap<Integer, String>();
        int counter = 1;
        for (String i : ingredients) {
            recipeIngredients.put(counter, i);
            counter++;
        }

        for (int keyint: recipeIngredients.keySet()) {
            String value = recipeIngredients.get(keyint).toString();
            System.out.println(keyint + ", " + value);
        }
    }
}




