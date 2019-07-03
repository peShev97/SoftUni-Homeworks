import java.util.Scanner;

public class PokeMon {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustF = Integer.parseInt(scanner.nextLine());

        int count = 0;
        int halfPower = power * 50 / 100;

        while (power >= distance) {
            power -= distance;
            count++;
            if (power == halfPower) {
                power /= exhaustF;
            }
        }
        System.out.println(power);
        System.out.println(count);
    }
}
