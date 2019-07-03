import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameRegex = "[A-Za-z]+";
        String numRegex = "\\d";

        Pattern nameCompile = Pattern.compile(nameRegex);
        Pattern numsCompile = Pattern.compile(numRegex);

        List<String> names = Arrays.stream(scanner.nextLine().split(", +"))
                .collect(Collectors.toList());

        Map<String, Integer> result = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"end of race".equals(input)) {
            Matcher findName = nameCompile.matcher(input);
            String name = "";

            while (findName.find()) {
                name += findName.group();
            }

            if (names.contains(name)) {
                Matcher findSum = numsCompile.matcher(input);
                int sum = 0;
                while (findSum.find()) {
                    sum += Integer.parseInt(findSum.group());
                }

                if (result.containsKey(name)) {
                    result.put(name, result.get(name) + sum);
                } else {
                    result.put(name, sum);
                }
            }

            input = scanner.nextLine();
        }

        List<String> finalNames = new ArrayList<>();

        result.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(3)
                .forEach(e -> finalNames.add(e.getKey()));

        System.out.printf("1st place: %s%n", finalNames.get(0));
        System.out.printf("2nd place: %s%n", finalNames.get(1));
        System.out.printf("3rd place: %s%n", finalNames.get(2));
    }
}