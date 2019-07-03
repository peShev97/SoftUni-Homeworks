package MapsAndSets;

import java.util.*;
import java.util.stream.Collectors;

public class HandOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> output = new LinkedHashMap<>();

        String input = "";

        while (!"JOKER".equals(input=scanner.nextLine())) {
            String[] split = input.split(": ");

            String name = split[0];
            Set<String> cards = Arrays.stream(split[1].split(", ")).collect(Collectors.toSet());

            output.putIfAbsent(name, new HashSet<>());

            for (String card : cards) {
                output.get(name).add(card);
            }
        }

        output.forEach((k, v) -> {
            int sum = 0;

            for (String card : v) {
                int power = 0;

                switch (card.charAt(0)) {
                    case 'J':
                        power = 11;
                        break;
                    case 'Q':
                        power = 12;
                        break;
                    case 'K':
                        power = 13;
                        break;
                    case 'A':
                        power = 14;
                        break;
                    default:
                        if (card.length() == 2){
                            power = Integer.parseInt(card.substring(0, 1));
                        } else {
                            power = Integer.parseInt(card.substring(0, 2));
                        }
                        break;
                }

                int multiply = 0;

                if (card.length() == 2) {
                    switch (card.charAt(1)) {
                        case 'S':
                            multiply = 4;
                            break;
                        case 'H':
                            multiply = 3;
                            break;
                        case 'D':
                            multiply = 2;
                            break;
                        case 'C':
                            multiply = 1;
                            break;
                    }
                } else {
                    switch (card.charAt(2)) {
                        case 'S':
                            multiply = 4;
                            break;
                        case 'H':
                            multiply = 3;
                            break;
                        case 'D':
                            multiply = 2;
                            break;
                        case 'C':
                            multiply = 1;
                            break;
                    }
                }
                sum += power * multiply;
            }

            System.out.println(String.format("%s: %d", k, sum));
        });
    }
}