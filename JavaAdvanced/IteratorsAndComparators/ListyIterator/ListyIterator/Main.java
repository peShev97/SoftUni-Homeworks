package IteratorsAndComparators.ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] create = reader.readLine().split("\\s+");

        ListyIterator output = new ListyIterator();

        if (create.length != 1) {
            String[] items = new String[create.length - 1];

            int index = 0;
            for (int i = 1; i < create.length; i++) {
                items[index] = create[i];
                index++;
            }

            output = new ListyIterator(items);
        }

        String command = "";

        while (!"END".equals(command=reader.readLine())) {
            switch (command) {
                case "Move":
                    System.out.println(output.move());
                    break;
                case "HasNext":
                    System.out.println(output.hasNext());
                    break;
                case "Print":
                    output.print();
                    break;
                case "PrintAll":
                    output.printAll();
                    break;
            }
        }
    }
}