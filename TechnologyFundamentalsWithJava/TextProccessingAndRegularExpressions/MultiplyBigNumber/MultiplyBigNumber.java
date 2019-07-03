import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num = scanner.nextLine();
        int multiplier = Integer.parseInt(scanner.nextLine());

        if (multiplier == 0) {
            System.out.println(0);
            return;
        }

        int remainder = 0;

        StringBuilder result = new StringBuilder();

        for (int i = num.length() - 1; i >= 0; i--) {
            int toInt = Character.getNumericValue(num.charAt(i));

            int multiply = toInt * multiplier + remainder;

            int toAdd = multiply % 10;
            remainder = multiply / 10;

            result.insert(0, toAdd);
        }

        if (remainder != 0)
            result.insert(0, remainder);

        System.out.println(result);
    }
}