package DefiningClasses.Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new HashMap<>();

        String line = "";

        while (!"End".equals(line=reader.readLine())) {
            String[] info = line.split("\\s+");
            String name = info[0];

            people.putIfAbsent(name, new Person(name));

            switch (info[1]) {
                case "company":
                    String companyName = info[2];
                    String department = info[3];
                    double salary = Double.parseDouble(info[4]);

                    Company company = new Company(companyName, department, salary);

                    people.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = info[2];
                    String pokemonType = info[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);

                    people.get(name).addPokemon(pokemon);
                    break;
                case "parents":
                    String parentName = info[2];
                    String parentBirthday = info[3];

                    Parents parent = new Parents(parentName, parentBirthday);

                    people.get(name).addParent(parent);
                    break;
                case "children":
                    String childName = info[2];
                    String childBirthday = info[3];

                    Children child = new Children(childName, childBirthday);

                    people.get(name).addChild(child);
                    break;
                case "car":
                    String carModel = info[2];
                    String carSpeed = info[3];

                    Car car = new Car(carModel, carSpeed);

                    people.get(name).setCar(car);
                    break;
            }
        }

        String name = reader.readLine();

        System.out.println(people.get(name).toString());
    }
}