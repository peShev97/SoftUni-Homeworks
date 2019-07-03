import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelensAbduction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int energy = Integer.parseInt(reader.readLine());

        int rows = Integer.parseInt(reader.readLine());

        String[][] field = new String[rows][];

        for (int i = 0; i < field.length; i++) {
            field[i] = reader.readLine().split("");
        }

        int parisRow = 0;
        int parisCol = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j].equals("P")) {
                    parisRow = i;
                    parisCol = j;
                    field[i][j] = "-";
                }
            }
        }

        while (true) {
            String[] info = reader.readLine().split("\\s+");
            String direction = info[0];
            int spawnRow = Integer.parseInt(info[1]);
            int spawnCol = Integer.parseInt(info[2]);

            field[spawnRow][spawnCol] = "S";

            if (willParisMove(field, parisRow, parisCol, direction)) {
                switch (direction) {
                    case "up":
                        parisRow--;
                        break;
                    case "down":
                        parisRow++;
                        break;
                    case "left":
                        parisCol--;
                        break;
                    case "right":
                        parisCol++;
                        break;
                }
            }

            energy--;

            if (field[parisRow][parisCol].equals("S")) {
                energy -= 2;

                if (energy <= 0) {
                    field[parisRow][parisCol] = "X";
                    System.out.println(String.format("Paris died at %d;%d.", parisRow, parisCol));
                    break;
                } else {
                    field[parisRow][parisCol] = "-";
                }
            } else if (field[parisRow][parisCol].equals("H")) {
                field[parisRow][parisCol] = "-";
                System.out.println(String.format("Paris has successfully abducted Helen! Energy left: %d", energy));
                break;
            }

            if (energy <= 0) {
                field[parisRow][parisCol] = "X";
                System.out.println(String.format("Paris died at %d;%d.", parisRow, parisCol));
                break;
            }
        }

        printField(field);
    }

    private static boolean willParisMove(String[][] field, int row, int col, String direction) {
        boolean willHeMove = false;

        switch (direction) {
            case "up":
                if (row - 1 >= 0) {
                    willHeMove = true;
                }
                break;
            case "down":
                if (row + 1 < field.length) {
                    willHeMove = true;
                }
                break;
            case "left":
                if (col - 1 >= 0) {
                    willHeMove = true;
                }
                break;
            case "right":
                if (col + 1 < field[0].length) {
                    willHeMove = true;
                }
                break;
        }

        return willHeMove;
    }

    private static void printField(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}