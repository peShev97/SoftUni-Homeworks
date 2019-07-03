import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        int remainingPower = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);

            if (currentSymbol == '>') {
                int index = i + 1;
                int power = Character.getNumericValue(text.charAt(index));

                for (int j = 0; j < power + remainingPower; j++) {
                    if (index >= text.length()) {
                        break;
                    }
                    char symbolToDelete = text.charAt(index);

                    if (symbolToDelete == '>') {
                        remainingPower += power - j;
                        break;
                    }

                    text.delete(index, index + 1);

                    if (j == power + remainingPower - 1) {
                        remainingPower = 0;
                    }
                }
            }
        }

        System.out.println(text);
    }
}