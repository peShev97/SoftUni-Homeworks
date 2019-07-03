import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double totalSum = 0;

        for (int i = 0; i < input.length; i++) {
            String currentString = input[i];
            char firstLetter = currentString.charAt(0);
            char lastLetter = currentString.charAt(currentString.length() - 1);
            double number = Double.parseDouble(currentString.substring(1, currentString.length() - 1));

            if (Character.isUpperCase(firstLetter)) {
                int position = firstLetter - 64;
                number /= position;
            } else {
                int position = firstLetter - 96;
                number *= position;
            }

            if (Character.isUpperCase(lastLetter)) {
                int position = lastLetter - 64;
                number -= position;
            } else {
                int position = lastLetter - 96;
                number += position;
            }

            totalSum += number;
        }

        System.out.printf("%.2f", totalSum);
    }
}