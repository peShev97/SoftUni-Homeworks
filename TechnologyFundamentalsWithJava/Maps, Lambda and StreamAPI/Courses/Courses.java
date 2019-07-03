import java.util.*;
import java.util.stream.Collectors;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> result = new LinkedHashMap<>();
        Map<String, Integer> count = new LinkedHashMap<>();

        while (!"end".equals(input)) {
            String[] splitIt = input.split(" : ");
            String courseName = splitIt[0];
            String studentName = splitIt[1];

            result.putIfAbsent(courseName, new ArrayList<>());
            result.get(courseName).add(studentName);

            if (count.containsKey(courseName)) {
                count.put(courseName, count.get(courseName) + 1);
            } else {
                count.put(courseName, 1);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> pair : result.entrySet()) {
            List<String> sort = pair.getValue()
                    .stream()
                    .sorted(String::compareTo)
                    .collect(Collectors.toList());

            result.put(pair.getKey(), sort);
        }

        count.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> {
                    System.out.printf("%s: %d%n", e.getKey(), e.getValue());

                    for (String item : result.get(e.getKey())) {
                        System.out.printf("-- %s%n", item);
                    }
                });
    }
}