package IteratorsAndComparators.StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        NameComparator name = new NameComparator();
        AgeComparator age = new AgeComparator();

        TreeSet<Person> output = new TreeSet<>(name);
        TreeSet<Person> output1 = new TreeSet<>(age);

        int lines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lines; i++) {
            String[] info = reader.readLine().split("\\s+");
            output.add(new Person(info[0], Integer.parseInt(info[1])));
            output1.add(new Person(info[0], Integer.parseInt(info[1])));
        }

        output.forEach(e -> System.out.println(String.format("%s %d", e.getName(), e.getAge())));
        output1.forEach(e -> System.out.println(String.format("%s %d", e.getName(), e.getAge())));
    }
}
