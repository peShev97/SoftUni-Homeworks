import java.util.Scanner;

public class VendingMachine {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        String coin = scanner.nextLine();

        double sum = 0;

        while (!"Start".equals(coin)) {
            double coins = Double.parseDouble(coin);

            if (!(coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2)) {
                System.out.printf("Cannot accept %.2f%n", coins);
            } else {
                sum += coins;
            }
            coin = scanner.nextLine();
        }

        String product = scanner.nextLine();
        double price = 0;
        while (!"End".equals(product)) {
            switch (product) {
                case "Nuts":
                    price = 2.0;
                    if (sum < price) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", product);
                        sum -= price;
                    }
                    break;
                case "Water":
                    price = 0.7;
                    if (sum < price) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", product);
                        sum -= price;
                    }
                    break;
                case "Crisps":
                    price = 1.5;
                    if (sum < price) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", product);
                        sum -= price;
                    }
                    break;
                case "Soda":
                    price = 0.8;
                    if (sum < price) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", product);
                        sum -= price;
                    }
                    break;
                case "Coke":
                    price = 1.0;
                    if (sum < price) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", product);
                        sum -= price;
                    }
                    break;
                default:
                    System.out.println("Invalid product");
            }
            product = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sum);
    }
}
