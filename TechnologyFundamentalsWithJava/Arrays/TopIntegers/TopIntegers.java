import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < input.length; i++) {
            if (i == input.length - 1) {
                System.out.print(input[input.length - 1]);
                break;
            } else if (input[i] > input[i + 1]) {
                System.out.printf("%d ", input[i]);
            }
        }
    }
}