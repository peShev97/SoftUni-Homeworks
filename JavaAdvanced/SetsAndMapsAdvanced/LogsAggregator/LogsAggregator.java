package MapsAndSets;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> output = new TreeMap<>();

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String ip = input[0];
            String username = input[1];
            int duration = Integer.parseInt(input[2]);

            output.putIfAbsent(username, new TreeMap<>());
            output.get(username).putIfAbsent(ip, 0);
            output.get(username).put(ip, output.get(username).get(ip) + duration);
        }

        output.forEach((k, v) -> {
            System.out.print(k + ": ");
            System.out.print(v.values().stream().reduce(0, Integer::sum) + " ");
            System.out.print("[");

            List<String> keys = new ArrayList<>();

            v.forEach((key, value) -> keys.add(key));

            System.out.print(String.join(", ", keys));
            System.out.println("]");
        });
    }
}