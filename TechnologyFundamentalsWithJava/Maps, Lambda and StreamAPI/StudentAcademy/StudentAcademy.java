import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, Double> students = new LinkedHashMap<>();
        Map<String, Integer> gradeCount = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (students.containsKey(name)) {
                students.put(name, students.get(name) + grade);
            } else {
                students.put(name, grade);
            }

            if (gradeCount.containsKey(name)) {
                gradeCount.put(name, gradeCount.get(name) + 1);
            } else {
                gradeCount.put(name, 1);
            }
        }

        for (Map.Entry<String, Double> pair : students.entrySet()) {
            students.put(pair.getKey(), pair.getValue() / gradeCount.get(pair.getKey()));
        }

        students.entrySet()
                .stream()
                .filter(e -> e.getValue() >= 4.50)
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()));
    }
}