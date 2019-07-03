package MapsAndSets;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<Integer>>> output = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String type = input[0];
            String name = input[1];
            int damage = "null".equals(input[2]) ? 45 : Integer.parseInt(input[2]);
            int health = "null".equals(input[3]) ? 250 : Integer.parseInt(input[3]);
            int armor = "null".equals(input[4]) ? 10 : Integer.parseInt(input[4]);

            output.putIfAbsent(type, new TreeMap<>());
            output.get(type).putIfAbsent(name, new ArrayList<>());

            if (output.get(type).get(name).size() == 0) {
                output.get(type).get(name).add(0, damage);
                output.get(type).get(name).add(1, health);
                output.get(type).get(name).add(2, armor);
            } else {
                output.get(type).get(name).set(0, damage);
                output.get(type).get(name).set(1, health);
                output.get(type).get(name).set(2, armor);
            }
        }

        for (Map.Entry<String, Map<String, List<Integer>>> type : output.entrySet()) {
            int totalDamage = 0, totalHealth = 0, totalArmor = 0;

            for (Map.Entry<String, List<Integer>> dragon : type.getValue().entrySet()) {
                totalDamage += dragon.getValue().get(0);
                totalHealth += dragon.getValue().get(1);
                totalArmor += dragon.getValue().get(2);
            }

            double averageDamage = (double)totalDamage / type.getValue().size(),
                    averageHealth = (double)totalHealth / type.getValue().size(),
                    averageArmor = (double)totalArmor / type.getValue().size();

            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", type.getKey(), averageDamage, averageHealth, averageArmor));

            for (Map.Entry<String, List<Integer>> dragon : type.getValue().entrySet()) {
                System.out.println(String.format("-%s -> damage: %d, health: %d, armor: %d",
                        dragon.getKey(),
                        dragon.getValue().get(0),
                        dragon.getValue().get(1),
                        dragon.getValue().get(2)));
            }
        }
    }
}