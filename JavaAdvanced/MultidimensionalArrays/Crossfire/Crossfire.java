package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayList<ArrayList<Integer>> matrix = generateMatrix(matrixDimensions[0], matrixDimensions[1]);

        String coordinates = "";

        while (!"Nuke it from orbit".equals(coordinates=scanner.nextLine())) {
            int[] split = Arrays.stream(coordinates.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int row = split[0];
            int col = split[1];
            int radius = split[2];

            for (int i = row - radius; i <= row + radius; i++) {
                if (isInBounds(matrix, i, col)) {
                    matrix.get(i).set(col, 0);
                }
            }

            for (int i = col - radius; i <= col + radius; i++) {
                if (isInBounds(matrix, row, i)) {
                    matrix.get(row).set(i, 0);
                }
            }

            for (int i = 0; i < matrix.size(); i++) {
                matrix.set(i, matrix.get(i).stream()
                .filter(e -> e != 0)
                .collect(Collectors.toCollection(ArrayList::new)));

                if (matrix.get(i).size() == 0) {
                    matrix.remove(i);
                    i--;
                }
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static boolean isInBounds(ArrayList<ArrayList<Integer>> matrix, int rows, int cols) {
        return rows >= 0 && rows < matrix.size() && cols >= 0 && cols < matrix.get(rows).size();
    }

    public static ArrayList<ArrayList<Integer>> generateMatrix(int rows, int cols) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int count = 1;
        for (int i= 0; i < rows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(count);
                count++;
            }
            matrix.add(row);
        }

        return matrix;
    }
}