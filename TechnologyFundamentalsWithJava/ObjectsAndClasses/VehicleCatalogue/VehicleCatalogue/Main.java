package VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Vehicle> cars = new ArrayList<>();
        List<Vehicle> trucks = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] splitInput = input.split("\\s+");

            Vehicle vehicle = new Vehicle(splitInput[0], splitInput[1], splitInput[2], Integer.parseInt(splitInput[3]));

            if (splitInput[0].equals("car")) {
                cars.add(vehicle);
            } else if (splitInput[0].equals("truck")) {
                trucks.add(vehicle);
            }

            input = scanner.nextLine();
        }

        String models = scanner.nextLine();

        while(!"Close the Catalogue".equals(models)) {
            String finalModel = models;
            cars.stream().filter(c -> c.getModel().equals(finalModel)).forEach(System.out::println);
            trucks.stream().filter(t -> t.getModel().equals(finalModel)).forEach(System.out::println);
            models = scanner.nextLine();
        }

        double carsAverage = getAverageHorsePower(cars);
        double trucksAverage = getAverageHorsePower(trucks);

        System.out.printf("Cars have average horsepower of: %.2f.%n", carsAverage);
        System.out.printf("Trucks have average horsepower of: %.2f.", trucksAverage);
    }

    public static double getAverageHorsePower(List<Vehicle> vehicles) {
        if (vehicles.size() == 0) {
            return 0.0;
        }

        double sum = 0;
        for (Vehicle item : vehicles) {
            sum += item.getHorsepower();
        }
        return sum / vehicles.size();
    }
}