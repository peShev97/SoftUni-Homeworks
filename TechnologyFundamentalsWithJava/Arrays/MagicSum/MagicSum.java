import java.util.Scanner;

public class MagicSum {
    public static void main(String argsp[]) {
        Scanner scanner = new Scanner(System.in);

        String[] in = scanner.nextLine().split(" ");
        int[] numbers = new int[in.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(in[i]);
        }
        int number = Integer.parseInt(scanner.nextLine());

        for (int j = 0; j < numbers.length; j++) {
            for (int i = j + 1; i < numbers.length; i++) {
                if (numbers[j] + numbers[i] == number) {
                    System.out.printf("%d %d", numbers[j], numbers[i]);
                    System.out.println();
                }
            }
        }
    }
}