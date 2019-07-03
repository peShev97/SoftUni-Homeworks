import java.util.Scanner;

public class EqualSums {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        String[] in = scanner.nextLine().split(" ");
        int[] input = new int[in.length];

        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(in[i]);
        }

        for (int i = 0; i < input.length; i++) {
            int leftSum = 0, rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += input[j];
            }

            for (int k = i + 1; k < input.length; k++) {
                rightSum += input[k];
            }

            if (leftSum == rightSum) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("no");
    }
}