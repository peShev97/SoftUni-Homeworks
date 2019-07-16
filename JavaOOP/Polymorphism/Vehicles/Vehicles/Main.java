package Polymorphism.Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = reader.readLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));

        String[] truckInfo = reader.readLine().split("\\s+");

        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int lines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lines; i++) {
            String[] commandInfo = reader.readLine().split("\\s+");

            switch (commandInfo[0]) {
                case "Drive":
                    switch (commandInfo[1]) {
                        case "Car":
                            car.drive(Double.parseDouble(commandInfo[2]));
                            break;
                        case "Truck":
                            truck.drive(Double.parseDouble(commandInfo[2]));
                            break;
                    }
                    break;
                case "Refuel":
                    switch (commandInfo[1]) {
                        case "Car":
                            car.refuel(Double.parseDouble(commandInfo[2]));
                            break;
                        case "Truck":
                            truck.refuel(Double.parseDouble(commandInfo[2]));
                            break;
                    }
                    break;
            }
        }

        System.out.println(String.format("Car: %.2f", car.getFuelQuantity()));
        System.out.println(String.format("Truck: %.2f", truck.getFuelQuantity()));
    }
}