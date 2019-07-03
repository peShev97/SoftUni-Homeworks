import java.util.*;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<Integer> numbers = new ArrayList<>();

        for (String item : input) {
            numbers.add(Integer.parseInt(item));
        }

        int[] bombNumber = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bombNumber[0]) {
                int index = i;
                for (int leftSide = 0; leftSide < bombNumber[1]; leftSide++) {
                    if (index - 1 < 0) {
                        break;
                    }
                    numbers.remove(index - 1);
                    index--;
                }

                for (int rightSide = 0; rightSide < bombNumber[1]; rightSide++) {
                    if (index + 1 == numbers.size()) {
                        break;
                    }
                    numbers.remove(index + 1);
                }
                numbers.remove(index);
                i = -1;
            }
        }

        int sum = 0;
        for (Integer item : numbers) {
            sum += item;
        }
        System.out.println(sum);
    }
}