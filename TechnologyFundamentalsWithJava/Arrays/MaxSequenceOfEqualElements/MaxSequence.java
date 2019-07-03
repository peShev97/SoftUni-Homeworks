import java.util.Scanner;

public class MaxSequence {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int startRowIndex = 0, bestRowIndex = 0;
        int startRowLength = 0, bestRowLength = 0;

        for (int i = 0; i < input.length - 1; i++) {
            if (input[i].equals(input[i + 1])) {
                startRowIndex = i;
                startRowLength++;
            } else {
                startRowLength = 0;
            }
            if (startRowLength > bestRowLength) {
                bestRowIndex = startRowIndex + 1 - startRowLength;
                bestRowLength = startRowLength;
            }
        }
        for (int i = bestRowIndex; i <= bestRowIndex + bestRowLength; i++) {
            System.out.printf("%s ", input[i]);
        }
    }
}