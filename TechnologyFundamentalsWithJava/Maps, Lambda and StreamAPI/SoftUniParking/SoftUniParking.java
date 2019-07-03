import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, String> users = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String name = input[1];

            switch (command) {
                case "register":
                    String number = input[2];
                    register(users, name, number);
                    break;
                case "unregister":
                    unregister(users, name);
                    break;
            }
        }

        for (Map.Entry<String, String> pair : users.entrySet()) {
            System.out.printf("%s => %s%n", pair.getKey(), pair.getValue());
        }
    }

    public static void register(Map<String, String> user, String name, String number) {
        if (user.containsKey(name)) {
            System.out.printf("ERROR: already registered with plate number %s%n", number);
        } else {
            user.put(name, number);
            System.out.printf("%s registered %s successfully%n", name, number);
        }
    }

    public static void unregister(Map<String, String> user, String name) {
        if (!user.containsKey(name)) {
            System.out.printf("ERROR: user %s not found%n", name);
        } else {
            user.remove(name);
            System.out.printf("%s unregistered successfully%n", name);
        }
    }
}