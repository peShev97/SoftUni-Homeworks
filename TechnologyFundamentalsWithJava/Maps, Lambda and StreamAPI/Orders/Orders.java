import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> items = new LinkedHashMap<>();
        Map<String, Double> prices = new LinkedHashMap<>();
        Map<String, Integer> quantities = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"buy".equals(input)) {
            String[] item = input.split("\\s+");
            String name = item[0];
            double price = Double.parseDouble(item[1]);
            int quantity = Integer.parseInt(item[2]);

            if (items.containsKey(name)) {
                quantities.put(name, quantities.get(name) + quantity);
                if (prices.get(name) != price) {
                    prices.put(name, price);
                    items.put(name, price * quantities.get(name));
                } else {
                    items.put(name, items.get(name) + (price * quantity));
                }
            } else {
                items.put(name, price * quantity);
                prices.put(name, price);
                quantities.put(name, quantity);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Double> pair : items.entrySet()) {
            System.out.printf("%s -> %.2f%n", pair.getKey(), pair.getValue());
        }
    }
}