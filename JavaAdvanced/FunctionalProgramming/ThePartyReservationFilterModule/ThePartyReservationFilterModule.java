package FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Map<String, Predicate<String>> predicates = new HashMap<>();

        String command = "";

        while (!"Print".equals(command = scanner.nextLine())) {
            String[] splitIt = command.split(";");
            String commandName = splitIt[0];
            String condition = splitIt[1];
            String criteria = splitIt[2];

            Predicate<String> predicate = createPredicate(condition, criteria);

            switch (commandName) {
                case "Add filter":
                    predicates.putIfAbsent(condition + criteria, predicate);
                    break;
                case "Remove filter":
                    predicates.remove(condition + criteria);
                    break;
            }
        }

        names
                .forEach(name -> {
                    boolean[] isValid = new boolean[1];
                    predicates.forEach((k, v) -> {
                        if (v.test(name)) {
                            isValid[0] = true;
                        }
                    });

                    if (!isValid[0]) {
                        System.out.print(name + " ");
                    }
                });
    }

    public static Predicate<String> createPredicate(String condition, String criteria) {
        Predicate<String> predicate;

        switch (condition) {
            case "Starts with":
                predicate = s -> s.startsWith(criteria);
                break;
            case "Ends with":
                predicate = s -> s.endsWith(criteria);
                break;
            case "Length":
                predicate = s -> s.length() == Integer.parseInt(criteria);
                break;
            default:
                predicate = s -> s.contains(criteria);
                break;
        }

        return predicate;
    }
}