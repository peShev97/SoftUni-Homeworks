package IteratorsAndComparators.ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        String command = "";

        while (!"END".equals(command=reader.readLine())) {
            String[] info = command.split("\\s+");
            people.add(new Person(info[0], Integer.parseInt(info[1]), info[2]));
        }

        int num = Integer.parseInt(reader.readLine());

        if (num < people.size()) {
            Person person = people.get(num);
            int equal = 0;
            int notequal = 0;

            for (Person person1 : people) {
                if (person.compareTo(person1) == 0) {
                    equal++;
                } else {
                    notequal++;
                }
            }

            System.out.println(equal + " " + notequal + " " + people.size());
        } else {
            System.out.println("No matches");
        }
    }
}
