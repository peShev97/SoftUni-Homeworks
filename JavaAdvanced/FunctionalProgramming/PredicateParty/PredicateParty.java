package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        String command = "";

        while (!"Party!".equals(command = scanner.nextLine())) {
            String[] splitIt = command.split("\\s+");
            String commandName = splitIt[0];
            String condition = splitIt[1];
            String criteria = splitIt[2];

            Predicate<String> predicate = createPredicate(condition, criteria);

            switch (commandName) {
                case "Remove":
                    names.removeIf(predicate);
                    break;
                case "Double":
                    List<String> namesToAdd = new ArrayList<>();

                    names.forEach(name -> {
                        if (predicate.test(name)) {
                            namesToAdd.add(name);
                        }
                    });

                    names.addAll(namesToAdd);
                    break;
            }
        }

        String output = names.stream().sorted().collect(Collectors.joining(", "));

        if (output.length() > 0)
            System.out.println(String.format("%s are going to the party!", output));
        else
            System.out.println("Nobody is going to the party!");
    }

    private static Predicate<String> createPredicate(String condition, String criteria) {
        Predicate<String> predicate;

        switch (condition) {
            case "StartsWith":
                predicate = s -> s.startsWith(criteria);
                break;
            case "EndsWith":
                predicate = s -> s.endsWith(criteria);
                break;
            default:
                predicate = s -> s.length() == Integer.parseInt(criteria);
                break;
        }

        return predicate;
    }
}