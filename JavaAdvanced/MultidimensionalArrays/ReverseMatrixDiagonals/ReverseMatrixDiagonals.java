package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[dimensions[0]][dimensions[1]];

        for (int i = 0; i < matrix.length; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = row[j];
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            if (i == matrix.length - 1) {
                for (int j = matrix[0].length - 1; j >= 0; j--) {
                    int row = i;
                    for (int l = j; l < matrix[0].length; l++) {
                        if (row < 0) {
                            break;
                        }
                        System.out.print(matrix[row][l] + " ");
                        row--;
                    }
                    System.out.println();
                }
            } else {
                int count = 0;
                for (int j = i; j >= 0; j--) {
                    if (count >= matrix[0].length)
                        break;
                    System.out.print(matrix[j][count] + " ");
                    count++;
                }
                System.out.println();
            }
        }
    }
}