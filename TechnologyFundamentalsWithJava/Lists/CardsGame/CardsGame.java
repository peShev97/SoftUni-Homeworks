import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        List<String> firstInput = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> secondInput = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<Integer> firstHand = new ArrayList<>();
        List<Integer> secondHand = new ArrayList<>();

        for (String item : firstInput) {
            firstHand.add(Integer.parseInt(item));
        }

        for (String item : secondInput) {
            secondHand.add(Integer.parseInt(item));
        }

        while (!(firstHand.isEmpty() || secondHand.isEmpty())) {
            if (firstHand.get(0) > secondHand.get(0)) {
                firstHand.add(firstHand.get(0));
                firstHand.add(secondHand.get(0));
                firstHand.remove(0);
                secondHand.remove(0);
            } else if (firstHand.get(0) < secondHand.get(0)) {
                secondHand.add(secondHand.get(0));
                secondHand.add(firstHand.get(0));
                secondHand.remove(0);
                firstHand.remove(0);
            } else {
                firstHand.remove(0);
                secondHand.remove(0);
            }
        }

        if (firstHand.isEmpty()) {
            int sum = 0;
            for (Integer item : secondHand) {
                sum += item;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        } else {
            int sum = 0;
            for (Integer item : firstHand) {
                sum += item;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }
    }
}