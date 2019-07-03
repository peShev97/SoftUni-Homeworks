package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robots = scanner.nextLine().split(";");

        String[] robotsNames = new String[robots.length];
        int[] processTime = new int[robots.length];

        for (int i = 0; i < robots.length; i++) {
            String[] robotData = robots[i].split("-");

            robotsNames[i] = robotData[0];
            processTime[i] = Integer.parseInt(robotData[1]);
        }

        int[] time = Arrays.stream(scanner.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();

        String product = "";

        ArrayDeque<String> products = new ArrayDeque<>();

        while (!"End".equals(product=scanner.nextLine())) {
            products.offer(product);
        }

        int seconds = time[0] * 3600 + time[1] * 60 + time[2];
        int[] workingTime = new int[robots.length];

        while (!products.isEmpty()) {
            seconds++;

            String currentProduct = products.poll();

            boolean isAccepted = false;

            for (int i = 0; i < robotsNames.length; i++) {
                if (workingTime[i] == 0 && !isAccepted) {
                    workingTime[i] = processTime[i];

                    isAccepted = true;

                    printCurrentTime(robotsNames[i], currentProduct, seconds);
                }

                if (workingTime[i] > 0) {
                    workingTime[i]--;
                }
            }

            if (!isAccepted) {
                products.offer(currentProduct);
            }
        }
    }

    private static void printCurrentTime(String robot, String product, int seconds) {
        long s = seconds % 60;
        long m = (seconds / 60) % 60;
        long h = (seconds / (60 * 60)) % 24;

        System.out.println(robot + " - " + product + String.format(" [%02d:%02d:%02d]", h, m, s));
    }
}