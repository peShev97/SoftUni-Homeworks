import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String argsp[]) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        int[] firstArr = new int[lines];
        int[] secondArr = new int[lines];
        for (int i = 0; i < lines; i++) {
            int one = Integer.parseInt(scanner.next());
            int two = Integer.parseInt(scanner.next());

            if (i % 2 == 0) {
                firstArr[i] = one;
                secondArr[i] = two;
            } else {
                firstArr[i] = two;
                secondArr[i] = one;
            }
        }
        for (int i = 0; i < firstArr.length; i++) {
            System.out.printf("%d ", firstArr[i]);
        }
        System.out.println();
        for (int i = 0; i < secondArr.length; i++) {
            System.out.printf("%d ", secondArr[i]);
        }
    }
}