import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> result = new TreeMap<>();

        while (!"Lumpawaroo".equals(input)) {
            String[] splitIt = input.split("\\s+\\|\\s+|\\s+->\\s+");
            String first = splitIt[0];
            String second = splitIt[1];

            if (input.contains("|")) {
                result.putIfAbsent(first, new ArrayList<>());

                if (result.entrySet().stream().noneMatch(e -> e.getValue().contains(second))) {
                    result.get(first).add(second);
                }
            } else {
                result.forEach((key, value) -> {
                    value.remove(first);
                });

                result.putIfAbsent(second, new ArrayList<>());

                result.get(second).add(first);
                System.out.println(String.format("%s joins the %s side!", first, second));
            }
            input = scanner.nextLine();
        }

        result.entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 0)
                .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                .forEach(e -> {
                    System.out.println(String.format("Side: %s, Members: %d", e.getKey(), e.getValue().size()));

                    e.getValue().stream()
                            .sorted(String::compareTo)
                            .forEach(u -> System.out.println(String.format("! %s", u)));
                });
    }
}