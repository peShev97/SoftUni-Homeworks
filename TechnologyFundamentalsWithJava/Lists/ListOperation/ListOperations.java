import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!"End".equals(command)) {
            String[] splitIt = command.split("\\s+");

            switch (splitIt[0]) {
                case "Add":
                    int number = Integer.parseInt(splitIt[1]);
                    numbers.add(number);
                    break;
                case "Insert":
                    int num = Integer.parseInt(splitIt[1]);
                    int index = Integer.parseInt(splitIt[2]);

                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, num);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(splitIt[1]);

                    if (removeIndex >= 0 && removeIndex < numbers.size()) {
                        numbers.remove(removeIndex);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(splitIt[2]);
                    switch (splitIt[1]) {
                        case "left":
                            for (int i = 0; i < count; i++) {
                                int countLeft = 0;
                                int first = numbers.get(0);
                                for (int j = 1; j < numbers.size(); j++) {
                                    numbers.set(countLeft, numbers.get(j));
                                    countLeft++;
                                }
                                numbers.set(numbers.size() - 1, first);
                            }
                            break;
                        case "right":
                            for (int i = 0; i < count; i++) {
                                int countRight = numbers.size() - 1;
                                int last = numbers.get(numbers.size() - 1);
                                for (int j = numbers.size() - 2; j >= 0; j--) {
                                    numbers.set(countRight, numbers.get(j));
                                    countRight--;
                                }
                                numbers.set(0, last);
                            }
                            break;
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        for (int item : numbers) {
            System.out.print(item + " ");
        }
    }
}