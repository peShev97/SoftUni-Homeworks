import java.util.Scanner;

public class CommonElements {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");

        for (String secondItem : secondArr) {
            for (String firstItem : firstArr) {
                if (firstItem.equals(secondItem)) {
                    System.out.printf("%s ", firstItem);
                }
            }
        }
    }
}