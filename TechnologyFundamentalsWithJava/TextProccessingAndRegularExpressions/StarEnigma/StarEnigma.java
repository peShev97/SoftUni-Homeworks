import javafx.css.Match;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        String countRegex = "[sSaAtTrR]";
        String infoRegex = "^[^@!>:-]*@(?<planet>[A-Za-z]+)[^@!>:-]*:[^@!>:0-9-]*(?<population>\\d+)[^@!>:-]*![^@!>:-]*(?<attack>A|D)![^@!>:-]*->[^@!>:0-9-]*(?<count>\\d+)[^@!>:-]*$";

        Pattern findCount = Pattern.compile(countRegex);
        Pattern findInfo = Pattern.compile(infoRegex);

        Map<String, List<String>> result = new LinkedHashMap<>();
        result.put("A", new ArrayList<>());
        result.put("D", new ArrayList<>());

        for (int i = 0; i < lines; i++) {
            StringBuilder message = new StringBuilder(scanner.nextLine());
            Matcher matchCount = findCount.matcher(message);

            int count = 0;

            while (matchCount.find()) {
                count++;
            }

            for (int j = 0; j < message.length(); j++) {
                char findNewChar = (char)(message.charAt(j) - count);
                String newChar = Character.toString(findNewChar);

                message.replace(j, j + 1, newChar);
            }

            Matcher matchInfo = findInfo.matcher(message);

            if (matchInfo.find()) {
                if (matchInfo.group("attack").equals("A")) {
                    result.get("A").add(matchInfo.group("planet"));
                } else {
                    result.get("D").add(matchInfo.group("planet"));
                }
            }
        }

        System.out.println(String.format("Attacked planets: %d", result.get("A").size()));
        if (result.get("A").size() != 0) {
            result.get("A").stream()
                    .sorted(String::compareTo)
                    .forEach(e -> System.out.println(String.format("-> %s", e)));
        }

        System.out.println(String.format("Destroyed planets: %d", result.get("D").size()));
        if (result.get("D").size() != 0) {
            result.get("D").stream()
                    .sorted(String::compareTo)
                    .forEach(e -> System.out.println(String.format("-> %s", e)));
        }
    }
}