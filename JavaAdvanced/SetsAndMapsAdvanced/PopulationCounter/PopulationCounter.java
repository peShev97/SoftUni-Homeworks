package MapsAndSets;
import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, Map<String, Long>> output = new LinkedHashMap<>();

        while (!"report".equals(input=scanner.nextLine())) {
            String[] split = input.split("\\|");

            String city = split[0];
            String country = split[1];
            long population = Integer.parseInt(split[2]);

            output.putIfAbsent(country, new LinkedHashMap<>());
            output.get(country).put(city, population);
        }

        output.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().values().stream().reduce(0L, Long::sum).compareTo(a.getValue()
                .values().stream().reduce(0L, Long::sum)))
                .forEach(kvp -> {
                    System.out.println(String.format("%s (total population: %d)", kvp.getKey(), kvp.getValue().values().stream()
                    .reduce(0L, Long::sum)));

                    kvp.getValue().
                            entrySet()
                            .stream()
                            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                            .forEach(asd -> System.out.println(String.format("=>%s: %d", asd.getKey(), asd.getValue())));
                });
    }
}