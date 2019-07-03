package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            String[] row = scanner.nextLine().split("\\s+");

            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = row[j];
            }
        }

        String fillChar = scanner.nextLine();

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int startRow = coordinates[0];
        int startCol = coordinates[1];

        String startChar = matrix[startRow][startCol];

        matrix[startRow][startCol] = fillChar;

        for (int i = startRow; i < matrix.length; i++) {
            for (int j = startCol; j < matrix[0].length; j++) {
                if (matrix[i][j].equals(startChar)) {
                    matrix[i][j] = fillChar;
                }

                if (i - 1 >= 0) {
                    if (matrix[i - 1][j].equals(startChar)) {
                        matrix[i - 1][j] = fillChar;
                    }
                }

                if (i + 1 < matrix.length) {
                    if (matrix[i + 1][j].equals(startChar)) {
                        matrix[i + 1][j] = fillChar;
                    }
                }

                if (j - 1 >= 0) {
                    if (matrix[i][j - 1].equals(startChar)) {
                        matrix[i][j - 1] = fillChar;
                    }
                }

                if (j + 1 < matrix[0].length) {
                    if (matrix[i][j + 1].equals(startChar)) {
                        matrix[i][j + 1] = fillChar;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
