package WorkingWithAbstraction.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Galaxy galaxy = new Galaxy(dimensions[0], dimensions[1]);
        Ivo ivo = new Ivo();
        Evil evil = new Evil();

        String command = "";

        while (!"Let the Force be with you".equals(command = scanner.nextLine())) {
            int[] ivoS = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilC = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            evil.setStarterPosition(evilC[0], evilC[1]);
            evil.destroyStars(galaxy);
            ivo.setStarterPosition(ivoS[0], ivoS[1]);
            ivo.collectStars(galaxy);
        }
        System.out.println(ivo.getStars());
    }
}