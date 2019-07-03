import java.util.Scanner;

public class Vacation {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0;
        double totalPrice = 0;

        switch (type) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                totalPrice = price * people;
                if (people >= 30) {
                    totalPrice -= totalPrice * 0.15;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16;
                        break;
                }
                totalPrice = price * people;
                if (people >= 100) {
                    totalPrice -= price * 10;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.50;
                        break;
                }
                totalPrice = price * people;
                if (people >= 10 && people <= 20) {
                    totalPrice -= totalPrice * 0.05;
                }
                break;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}