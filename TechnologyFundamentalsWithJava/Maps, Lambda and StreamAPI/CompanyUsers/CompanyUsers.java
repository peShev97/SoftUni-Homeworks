import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, List<String>> result = new HashMap<>();

        while (!"End".equals(input)) {
            String[] splitIt = input.split("->");
            String companyName = splitIt[0];
            String employeeId = splitIt[1];

            result.putIfAbsent(companyName, new ArrayList<>());

            if (!result.get(companyName).contains(employeeId)) {
                result.get(companyName).add(employeeId);
            }
            input = scanner.nextLine();
        }

        result.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> {
                    System.out.println(e.getKey().trim());

                    for (String item : e.getValue()) {
                        System.out.printf("-- %s%n", item.trim());
                    }
                });
    }
}