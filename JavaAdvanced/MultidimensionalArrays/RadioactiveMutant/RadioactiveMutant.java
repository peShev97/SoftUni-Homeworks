package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveMutant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            String row = scanner.nextLine();

            for (int j = 0; j < row.length(); j++) {
                matrix[i][j] = row.charAt(j);
            }
        }

        int playerRow = 0;
        int playerCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'P') {
                    playerRow = i;
                    playerCol = j;
                    matrix[i][j] = '.';
                }
            }
        }

        String directions = scanner.nextLine();

        for (int i = 0; i < directions.length(); i++) {
            char symbol = directions.charAt(i);

            switch (symbol) {
                case 'R':
                    playerCol++;
                    break;
                case 'U':
                    playerRow--;
                    break;
                case 'L':
                    playerCol--;
                    break;
                case 'D':
                    playerRow++;
                    break;
            }

            matrix = spreadBunnies(matrix, rows - 1, cols - 1);

            if (isInRange(matrix, playerRow, playerCol)) {
                if (matrix[playerRow][playerCol] == 'B') {
                    printMatrix(matrix);
                    System.out.println(String.format("dead: %d %d", playerRow, playerCol));
                    break;
                }
            } else {
                if (playerRow < 0) {
                    playerRow++;
                } else if (playerRow >= matrix.length) {
                    playerRow--;
                } else if (playerCol < 0) {
                    playerCol++;
                } else if (playerCol >= matrix[0].length) {
                    playerCol--;
                }

                printMatrix(matrix);
                System.out.println(String.format("won: %d %d", playerRow, playerCol));
                break;
            }
        }
    }

    private static char[][] spreadBunnies(char[][] matrix, int rows, int cols) {
        char[][] newMatrix = new char[matrix.length][matrix[0].length];

        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }

        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                if (matrix[row][col] == 'B') {
                    if (row > 0)
                        newMatrix[row - 1][col] = 'B';
                    if (row < rows)
                        newMatrix[row + 1][col] = 'B';
                    if (col > 0)
                        newMatrix[row][col - 1] = 'B';
                    if (col < cols)
                        newMatrix[row][col + 1] = 'B';
                }
            }
        }
        return newMatrix;
    }

    private static boolean isInRange(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}