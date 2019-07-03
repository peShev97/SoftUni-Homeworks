import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "%(?<name>[A-Z][a-z]+)%[^%.$|]*<(?<product>\\w+)>[^%.$|]*\\|(?<count>\\d+)\\|[^%.$|0-9]*(?<price>\\d+\\.?\\d+)\\$";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();

        double totalIncome = 0;

        while (!"end of shift".equals(input)) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                double price = Integer.parseInt(matcher.group("count")) * Double.parseDouble(matcher.group("price"));

                totalIncome += price;

                System.out.println(String.format("%s: %s - %.2f", name, product, price));
            }
            input = scanner.nextLine();
        }

        System.out.println(String.format("Total income: %.2f", totalIncome));
    }
}