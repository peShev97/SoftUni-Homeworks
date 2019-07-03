import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> userAndPoints = new TreeMap<>();
        Map<String, Integer> languageAndCount = new TreeMap<>();

        while (!"exam finished".equals(input)) {
            String[] splitIt = input.split("-+");
            String name = splitIt[0];
            String command = splitIt[1];

            if ("banned".equals(command)) {
                userAndPoints.remove(name);
            } else {
                int points = Integer.parseInt(splitIt[2]);

                if (userAndPoints.containsKey(name)) {
                    if (userAndPoints.get(name) <= points) {
                        userAndPoints.put(name, points);
                    }
                } else {
                    userAndPoints.put(name, points);
                }

                if (languageAndCount.containsKey(command)) {
                    languageAndCount.put(command, languageAndCount.get(command) + 1);
                } else {
                    languageAndCount.put(command, 1);
                }
            }
            input = scanner.nextLine();
        }

        System.out.println("Results:");

        userAndPoints.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> System.out.printf("%s | %d%n", e.getKey(), e.getValue()));

        System.out.println("Submissions:");

        languageAndCount.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));
    }
}