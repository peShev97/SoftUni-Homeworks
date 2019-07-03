package OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String personData = scanner.nextLine();
            String[] data = personData.split("\\s+");

            Person person = new Person(data[0], Integer.parseInt(data[1]));
            people.add(person);
        }

        people = people.stream().filter(e -> e.getAge() > 30).collect(Collectors.toList());

        people = people.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).collect(Collectors.toList());

        for (Person person : people) {
            System.out.printf("%s - %d%n", person.getName(), person.getAge());
        }
    }
}