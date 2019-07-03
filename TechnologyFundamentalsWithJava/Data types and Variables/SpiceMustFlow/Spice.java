import java.util.Scanner;

public class Spice {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int yield = Integer.parseInt(scanner.nextLine());

        int dayCount = 0;
        int spices = 0;

        while (yield >= 100) {
            dayCount++;
            spices += yield;
            if (spices >= 26) {
                spices -= 26;
            }
            yield -= 10;
        }
        if (spices >= 26) {
            spices -= 26;
        }
        System.out.println(dayCount);
        System.out.println(spices);
    }
}
