package Encapsulation.ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] peopleSplit = reader.readLine().split(";");

        Map<String, Person> people = new LinkedHashMap<>();

        for (String person : peopleSplit) {
            String[] info = person.split("=");
            people.put(info[0], new Person(info[0], Double.parseDouble(info[1])));
        }

        String[] productsSplit = reader.readLine().split(";");

        Map<String, Product> products = new HashMap<>();

        for (String product : productsSplit) {
            String[] info = product.split("=");
            products.put(info[0], new Product(info[0], Double.parseDouble(info[1])));
        }

        String command = "";

        while (!"END".equals(command=reader.readLine())) {
            String[] row = command.split("\\s+");
            String personName = row[0];
            String productName = row[1];
            try {
                people.get(personName).buyProduct(products.get(productName));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        people.forEach((n, p) -> {
            System.out.print(n + " - ");

            String collect = p.getProducts()
                    .stream()
                    .map(product -> String.valueOf(product.getName()))
                    .collect(Collectors.joining(", "));

            if (collect.length() == 0) {
                System.out.println("Nothing bought");
            } else {
                System.out.println(collect);
            }
        });
    }
}