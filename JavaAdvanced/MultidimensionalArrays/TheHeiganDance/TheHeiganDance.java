package MultidimensionalArrays;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playerHitPoints = 18500;
        double heiganHitPoints = 3000000;

        double playerAttack = Double.parseDouble(scanner.nextLine());

        int rowStart = 7;
        int colStart = 7;

        String lastUsedCommand = "";
        while (true) {
            if (playerHitPoints > 0) {
                heiganHitPoints -= playerAttack;
            }

            if (lastUsedCommand.equals("Plague Cloud")) {
                playerHitPoints -= 3500;
            }

            if (heiganHitPoints <= 0 || playerHitPoints <= 0) {
                break;
            }
            String[] spell = scanner.nextLine().split("\\s+");

            String spellName = spell[0];
            int row = Integer.parseInt(spell[1]);
            int col = Integer.parseInt(spell[2]);

            if (isInRange(row, col, rowStart, colStart)) {
                if (!isInRange(row, col, rowStart - 1, colStart) && !isWall(rowStart - 1)) {
                    rowStart--;
                    lastUsedCommand = "";
                } else if (!isInRange(row, col, rowStart, colStart + 1) && !isWall(colStart + 1)) {
                    colStart++;
                    lastUsedCommand = "";
                } else if (!isInRange(row, col, rowStart + 1, colStart) && !isWall(rowStart + 1)) {
                    rowStart++;
                    lastUsedCommand = "";
                } else if (!isInRange(row, col, rowStart, colStart - 1) && !isWall(colStart - 1)) {
                    colStart--;
                    lastUsedCommand = "";
                } else {
                    if ("Cloud".equals(spellName)) {
                        playerHitPoints -= 3500;
                        lastUsedCommand = "Plague Cloud";
                    } else if ("Eruption".equals(spellName)) {
                        playerHitPoints -= 6000;
                        lastUsedCommand = "Eruption";
                    }
                }
            }
        }

        if (heiganHitPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.println(String.format("Heigan: %.2f", heiganHitPoints));
        }

        if (playerHitPoints <= 0) {
            System.out.println(String.format("Player: Killed by %s", lastUsedCommand));
        } else {
            System.out.println(String.format("Player: %d", playerHitPoints));
        }
        System.out.println(String.format("Final position: %d, %d", rowStart, colStart));
    }

    private static boolean isInRange(int row, int col, int moveRow, int moveCol) {
        return ((row - 1 <= moveRow && moveRow <= row + 1)
                    && (col - 1 <= moveCol && moveCol <= col + 1));
    }

    private static boolean isWall(int cell) {
        return cell < 0 || cell >= 15;
    }
}