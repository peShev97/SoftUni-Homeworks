import java.util.Scanner;

public class LadyBugs {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] field = new int[fieldSize];

        String[] input = scanner.nextLine().split(" ");
        int[] index = new int[input.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < index.length; i++) {
            if (index[i] >= 0 && index[i] < field.length) {
                field[index[i]] = 1;
            }
        }

        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            String[] commands = command.split(" ");
            int initialIndex = Integer.parseInt(commands[0]);
            String direction = commands[1];
            int flyLength = Integer.parseInt(commands[2]);

            if (initialIndex >= 0 && initialIndex < field.length && field[initialIndex] == 1 && flyLength != 0) {
                if ("right".equals(direction)) {
                    if (initialIndex + flyLength >= 0 && initialIndex + flyLength < field.length && field[initialIndex + flyLength] == 0) {
                        field[initialIndex + flyLength] = 1;
                    } else if (initialIndex + flyLength >= 0 && initialIndex + flyLength < field.length && field[initialIndex + flyLength] == 1) {
                        while (initialIndex + flyLength >= 0 && initialIndex + flyLength < field.length && field[initialIndex + flyLength] == 1) {
                            flyLength += flyLength;
                            if (initialIndex + flyLength >= 0 && initialIndex + flyLength < field.length && field[initialIndex + flyLength] == 0) {
                                field[initialIndex + flyLength] = 1;
                                break;
                            }
                        }
                    }
                } else if ("left".equals(direction)) {
                    if (initialIndex - flyLength >= 0 && initialIndex - flyLength < field.length && field[initialIndex - flyLength] == 0) {
                        field[initialIndex - flyLength] = 1;
                    } else if (initialIndex - flyLength >= 0 && initialIndex - flyLength < field.length && field[initialIndex - flyLength] == 1) {
                        while (initialIndex - flyLength >= 0 && initialIndex - flyLength < field.length && field[initialIndex - flyLength] == 1) {
                            flyLength += flyLength;
                            if (initialIndex - flyLength >= 0 && initialIndex - flyLength < field.length && field[initialIndex - flyLength] == 0) {
                                field[initialIndex - flyLength] = 1;
                                break;
                            }
                        }
                    }
                }
                field[initialIndex] = 0;
            }
            command = scanner.nextLine();
        }
        for (int item : field) {
            System.out.print(item + " ");
        }
    }
}