import java.util.Scanner;

public class Snowballs {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int balls = Integer.parseInt(scanner.nextLine());
        int bestSnow = 0;
        int bestTime = 0;
        int bestQuality = 0;
        double bestBall = 0;

        for (int i = 0; i < balls; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            int result = snowballSnow / snowballTime;
            double value = Math.pow(result, snowballQuality);
            if (value > bestBall) {
                bestBall = value;
                bestSnow = snowballSnow;
                bestTime = snowballTime;
                bestQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", bestSnow, bestTime, bestBall, bestQuality);
    }
}