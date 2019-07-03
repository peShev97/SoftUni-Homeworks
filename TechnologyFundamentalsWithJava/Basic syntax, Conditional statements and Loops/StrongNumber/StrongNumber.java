import java.util.Scanner;

public class StrongNumber {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        String toString = Integer.toString(num);
        int lenght = toString.length();
        int number = num;
        int totalSum = 0;

        for (int i = 0; i < lenght; i++) {
            int lastDigit = number % 10;
            if (lastDigit == 1 || lastDigit == 0) {
                totalSum++;
            }
            int sum = 0;
            for (int j = lastDigit; j >= 1; j--) {
                if (j == lastDigit) {
                    continue;
                } else if (j == lastDigit - 1) {
                    sum = j * lastDigit;
                    continue;
                }
                sum *= j;
            }
            totalSum += sum;
            number /= 10;
        }
        if (totalSum == num) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
