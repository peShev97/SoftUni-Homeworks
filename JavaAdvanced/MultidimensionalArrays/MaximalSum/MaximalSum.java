package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[matrixDimensions[0]][matrixDimensions[1]];

        for (int i = 0; i < matrix.length; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }

        int bestSum = 0;
        int[][] bestMatrix = new int[3][3];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int sum = 0;
                int[][] currentMatrix = new int[3][3];

                int first = 0;

                for (int l = i; l < i + 3; l++) {
                    if (i + 3 <= matrix.length) {
                        int second = 0;
                        for (int k = j; k < j + 3; k++) {
                            if (j + 3 <= matrix[0].length) {
                                sum += matrix[l][k];

                                currentMatrix[first][second] = matrix[l][k];
                            }
                            second++;
                        }
                    }
                    first++;
                }

                if (sum > bestSum) {
                    bestSum = sum;
                    bestMatrix = currentMatrix;
                }
            }
        }

        System.out.println(String.format("Sum = %d", bestSum));
        for (int i = 0; i < bestMatrix.length; i++) {
            for (int j = 0; j < bestMatrix[0].length; j++) {
                System.out.print(bestMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}