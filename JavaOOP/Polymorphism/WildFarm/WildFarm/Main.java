package Polymorphism.WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String command = "";

        while (!"End".equals(command = reader.readLine())) {
            String[] splitCommand = command.split("\\s+");
            String[] foodInfo = reader.readLine().split("\\s+");

            Food food = null;

            switch (foodInfo[0]) {
                case "Vegetable":
                    food = new Vegetable(Integer.parseInt(foodInfo[1]));
                    break;
                case "Meat":
                    food = new Meat(Integer.parseInt(foodInfo[1]));
                    break;
            }

            Animal animal = null;

            switch (splitCommand[0]) {
                case "Cat":
                    animal = new Cat(splitCommand[1], splitCommand[0], Double.parseDouble(splitCommand[2]), splitCommand[3], splitCommand[4]);
                    break;
                case "Tiger":
                    animal = new Tiger(splitCommand[1], splitCommand[0], Double.parseDouble(splitCommand[2]), splitCommand[3]);
                    break;
                case "Zebra":
                    animal = new Zebra(splitCommand[1], splitCommand[0], Double.parseDouble(splitCommand[2]), splitCommand[3]);
                    break;
                case "Mouse":
                    animal = new Mouse(splitCommand[1], splitCommand[0], Double.parseDouble(splitCommand[2]), splitCommand[3]);
                    break;
            }

            if (animal == null || food == null) {
                continue;
            }

            animal.makeSound();
            animal.eat(food);
            animals.add(animal);
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}