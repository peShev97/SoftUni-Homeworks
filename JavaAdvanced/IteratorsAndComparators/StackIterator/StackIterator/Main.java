package IteratorsAndComparators.StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomStack nums = new CustomStack();

        String command = "";

        while (!"END".equals(command=reader.readLine())) {
            if (command.contains("Push")) {
                String splitNums = command.substring(5);
                String[] elements = splitNums.split(", ");
                nums.push(elements);
            } else {
                try {
                    nums.pop();
                } catch (Exception e) {
                    System.out.println("No elements");
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            nums.forEach(System.out::println);
        }
    }
}