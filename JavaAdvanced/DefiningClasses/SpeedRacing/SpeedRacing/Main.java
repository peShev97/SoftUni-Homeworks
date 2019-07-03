package DefiningClasses.SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Car> cars = new LinkedHashMap<>();

        int lines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lines; i++) {
            String[] info = reader.readLine().split("\\s+");
            String model = info[0];
            double fuelAmount = Double.parseDouble(info[1]);
            double fuelPerKM = Double.parseDouble(info[2]);

            Car car = new Car(model, fuelAmount, fuelPerKM);

            cars.put(model, car);
        }

        String command = "";

        while (!"End".equals(command=reader.readLine())) {
            String[] split = command.split("\\s+");

            String model = split[1];
            double distance = Double.parseDouble(split[2]);

            if (cars.containsKey(model)) {
                if (cars.get(model).getFuelCostPerKm() * distance <= cars.get(model).getFuelAmount()) {
                    cars.get(model).drive(distance);
                } else {
                    System.out.println("Insufficient fuel for the drive");
                }
            }
        }

        cars.forEach((k, v) -> System.out.println(String.format("%s %.2f %.0f", v.getModel(),
                v.getFuelAmount(),
                v.getDistanceTraveled())));
    }
}