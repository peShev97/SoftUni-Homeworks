package OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Person> people = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] splitIt = input.split("\\s+");

            Person person = new Person(splitIt[0], splitIt[1], Integer.parseInt(splitIt[2]));

            people.add(person);
            input = scanner.nextLine();
        }

        people = people.stream().sorted(Comparator.comparingInt(Person::getAge)).collect(Collectors.toList());

        for (Person item : people) {
            System.out.println(item);
        }
    }
}