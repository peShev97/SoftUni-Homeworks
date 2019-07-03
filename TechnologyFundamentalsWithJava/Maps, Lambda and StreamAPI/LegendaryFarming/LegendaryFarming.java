import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> junks = new TreeMap<>();
        Map<String, Integer> keyMaterials = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        String winner = "";
        boolean flag = false;

        do {
            String[] input = scanner.nextLine()
                    .toLowerCase()
                    .split("\\s+");

            for (int i = 0; i < input.length; i += 2) {
                String material = input[i + 1];
                int quantity = Integer.parseInt(input[i]);

                if (keyMaterials.containsKey(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);

                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        winner = material;
                        flag = true;
                        break;
                    }
                } else {
                    if (junks.containsKey(material)) {
                        junks.put(material, junks.get(material) + quantity);
                    } else {
                        junks.put(material, quantity);
                    }
                }
            }

        } while (!flag);

        switch (winner) {
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }

        String pattern = "%s: %d%n";

        keyMaterials.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(pair -> System.out.printf(pattern, pair.getKey(), pair.getValue()));

        for (Map.Entry<String, Integer> pair : junks.entrySet()) {
            System.out.printf(pattern, pair.getKey(), pair.getValue());
        }
    }
}