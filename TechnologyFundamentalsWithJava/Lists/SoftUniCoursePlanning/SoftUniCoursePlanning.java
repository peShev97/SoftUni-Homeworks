import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(", +")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!"course start".equals(command)) {
            String[] splitTheCommand = command.split(":");

            switch (splitTheCommand[0]) {
                case "Add":
                    if (!input.contains(splitTheCommand[1])) {
                        input.add(splitTheCommand[1]);
                    }
                    break;
                case "Insert":
                    if (!input.contains(splitTheCommand[1])) {
                        int index = Integer.parseInt(splitTheCommand[2]);
                        if (index >= 0 && index < input.size()) {
                            input.add(index, splitTheCommand[1]);
                        }
                    }
                    break;
                case "Remove":
                    if (input.contains(splitTheCommand[1])) {
                        String exercise = input.get(input.indexOf(splitTheCommand[1])) + "-" + "Exercise";
                        if (input.contains(exercise)) {
                            input.remove(splitTheCommand[1]);
                            input.remove(exercise);
                        } else {
                            input.remove(splitTheCommand[1]);
                        }
                    }
                    break;
                case "Swap":
                    if (input.contains(splitTheCommand[1]) && input.contains(splitTheCommand[2])) {
                        int firstIndex = input.indexOf(splitTheCommand[1]);
                        int secondIndex = input.indexOf(splitTheCommand[2]);
                        String firstExercise = input.get(firstIndex) + "-" + "Exercise";
                        String secondExercise = input.get(secondIndex) + "-" + "Exercise";
                        String first = input.get(firstIndex);

                        if (input.contains(firstExercise) && input.contains(secondExercise)) {
                            int firstExIndex = input.indexOf(firstExercise);
                            int secondExIndex = input.indexOf(secondExercise);
                            String firstEx = input.get(firstExIndex);
                            input.set(firstIndex, input.get(secondIndex));
                            input.set(secondIndex, first);
                            input.set(firstExIndex, input.get(secondExIndex));
                            input.set(secondExIndex, firstEx);
                        } else if (input.contains(firstExercise) || input.contains(secondExercise)) {
                            if (input.contains(firstExercise)) {
                                input.set(firstIndex, input.get(secondIndex));
                                input.set(secondIndex, first);
                                input.remove(firstExercise);
                                input.add(secondIndex + 1, firstExercise);
                            } else {
                                input.set(firstIndex, input.get(secondIndex));
                                input.set(secondIndex, first);
                                input.remove(secondExercise);
                                input.add(firstIndex + 1, secondExercise);
                            }
                        } else {
                            input.set(firstIndex, input.get(secondIndex));
                            input.set(secondIndex, first);
                        }
                    }
                    break;
                case "Exercise":
                    if (input.contains(splitTheCommand[1])) {
                        String exercise = input.get(input.indexOf(splitTheCommand[1])) + "-" + "Exercise";
                        if (!input.contains(exercise)) {
                            int indexOf = input.indexOf(splitTheCommand[1]);
                            input.add(indexOf + 1, exercise);
                        }
                    } else if (!input.contains(splitTheCommand[1])) {
                        input.add(splitTheCommand[1]);
                        String exercise = input.get(input.indexOf(splitTheCommand[1])) + "-" + "Exercise";
                        input.add(exercise);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        int count = 1;
        for (String item : input) {
            System.out.printf("%d.%s%n", count, item);
            count++;
        }
    }
}