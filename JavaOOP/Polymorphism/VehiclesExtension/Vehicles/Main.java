package Polymorphism.Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = reader.readLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));

        String[] truckInfo = reader.readLine().split("\\s+");

        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));

        String[] busInfo = reader.readLine().split("\\s+");

        Bus bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));

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
                        case "Bus":
                            bus.drive(Double.parseDouble(commandInfo[2]));
                            break;
                    }
                    break;
                case "Refuel":
                    if (Double.parseDouble(commandInfo[2]) <= 0) {
                        System.out.println("Fuel must be a positive number");
                    } else {
                        switch (commandInfo[1]) {
                            case "Car":
                                car.refuel(Double.parseDouble(commandInfo[2]));
                                break;
                            case "Truck":
                                truck.refuel(Double.parseDouble(commandInfo[2]));
                                break;
                            case "Bus":
                                bus.refuel(Double.parseDouble(commandInfo[2]));
                        }
                    }
                    break;
                case "DriveEmpty":
                    bus.driveEmpty(Double.parseDouble(commandInfo[2]));
                    break;
            }
        }

        System.out.println(String.format("Car: %.2f", car.getFuelQuantity()));
        System.out.println(String.format("Truck: %.2f", truck.getFuelQuantity()));
        System.out.println(String.format("Bus: %.2f", bus.getFuelQuantity()));
    }
}