package MultidimensionalArrays;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];

        for (int i = 0; i < matrix.length; i++) {
            String[] row = scanner.nextLine().split("\\s+");

            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = row[j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                String symbol = matrix[i][j];

                boolean isValid = true;

                if ("q".equals(symbol)) {
                    for (int k = j + 1; k < matrix[0].length; k++) {
                        if (matrix[i][k].equals("q")) {
                            isValid = false;
                        }
                    }

                    for (int k = 0; k < j; k++) {
                        if (matrix[i][k].equals("q")) {
                            isValid = false;
                        }
                    }

                    for (int k = i + 1; k < matrix.length; k++) {
                        if ("q".equals(matrix[k][j])) {
                            isValid = false;
                        }
                    }

                    for (int k = 0; k < i; k++) {
                        if ("q".equals(matrix[k][j])) {
                            isValid = false;
                        }
                    }

                    int right = j + 1;
                    int left = j - 1;
                    for (int k = i + 1; k < matrix.length; k++) {
                        if (right < matrix[0].length) {
                            if ("q".equals(matrix[k][right])) {
                                isValid = false;
                            }
                        }

                        if (left >= 0) {
                            if ("q".equals(matrix[k][left])) {
                                isValid = false;
                            }
                        }
                        right++;
                        left--;
                    }

                    right = j + 1;
                    left = j - 1;
                    for (int k = i - 1; k >= 0; k--) {
                        if (right < matrix[0].length) {
                            if ("q".equals(matrix[k][right])) {
                                isValid = false;
                            }
                        }

                        if (left >= 0) {
                            if ("q".equals(matrix[k][left])) {
                                isValid = false;
                            }
                        }
                        right++;
                        left--;
                    }

                    if (isValid) {
                        System.out.print(i + " " + j);
                        return;
                    }
                }
            }
        }
    }
}