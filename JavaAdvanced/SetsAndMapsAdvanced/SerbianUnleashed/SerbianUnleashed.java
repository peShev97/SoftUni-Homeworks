package MapsAndSets;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        String regex = "(?<singer>[A-Za-z]+\\s([A-Za-z]+\\s)*)@(?<place>[A-Za-z]+\\s([A-Za-z]+\\s)*)(?<ticketPrice>\\d+)\\s(?<ticketCount>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        Map<String, Map<String, Integer>> output = new LinkedHashMap<>();

        while (!"End".equals(input=scanner.nextLine())) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String singer = matcher.group("singer");
                String place = matcher.group("place");
                int ticketPrice = Integer.parseInt(matcher.group("ticketPrice"));
                int ticketCount = Integer.parseInt(matcher.group("ticketCount"));

                output.putIfAbsent(place, new LinkedHashMap<>());
                output.get(place).putIfAbsent(singer, 0);
                output.get(place).put(singer, output.get(place).get(singer) + ticketPrice * ticketCount);
            }
        }

        output.forEach((k, v) -> {
            System.out.println(k);

            v.entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(kvp -> System.out.println(String.format("#  %s-> %d", kvp.getKey(), kvp.getValue())));
        });
    }
}