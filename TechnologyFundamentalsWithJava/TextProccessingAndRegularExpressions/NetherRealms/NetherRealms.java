import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String healthExpression = "[^0-9+*\\/.-]";
        String damageExpression = "[+|-]?\\d+(\\.?\\d+)?";

        String[] input = scanner.nextLine().split(", *");

        Pattern healthRegex = Pattern.compile(healthExpression);
        Pattern damageRegex = Pattern.compile(damageExpression);
        Pattern multiplyRegex = Pattern.compile("\\*");
        Pattern divideRegex = Pattern.compile("\\/");

        Map<String, List<Double>> result = new TreeMap<>();

        for (int i = 0; i < input.length; i++) {
            String currentDemon = input[i].replaceAll(" ", "");
            double health = 0;
            double damage = 0;

            Matcher healthMatch = healthRegex.matcher(currentDemon);
            Matcher damageMatch = damageRegex.matcher(currentDemon);

            while (healthMatch.find()) {
                health += healthMatch.group().charAt(0);
            }

            while (damageMatch.find()) {
                damage += Double.parseDouble(damageMatch.group());
            }

            int multiplyCount = 0;
            int divideCount = 0;

            Matcher multiplyMatch = multiplyRegex.matcher(currentDemon);
            Matcher divideMatch = divideRegex.matcher(currentDemon);

            while (multiplyMatch.find()) {
                multiplyCount++;
            }

            while (divideMatch.find()) {
                divideCount++;
            }

            for (int j = 0; j < multiplyCount; j++) {
                damage *= 2;
            }

            for (int j = 0; j < divideCount; j++) {
                damage /= 2;
            }

            result.put(currentDemon, new ArrayList<>());
            result.get(currentDemon).add(health);
            result.get(currentDemon).add(damage);
        }

        for (Map.Entry<String, List<Double>> item : result.entrySet()) {
            System.out.println(String.format("%s - %.0f health, %.2f damage", item.getKey(), item.getValue().get(0), item.getValue().get(1)));
        }
    }
}