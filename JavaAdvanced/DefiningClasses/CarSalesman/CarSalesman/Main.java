package DefiningClasses.CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();

        int enginesLines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < enginesLines; i++) {
            String[] engineInfo = reader.readLine().split("\\s+");
            String model = engineInfo[0];
            String power = engineInfo[1];

            Engine engine = new Engine(model, power);

            if (engineInfo.length == 3) {
                if (Character.isDigit(engineInfo[2].charAt(0))) {
                    engine.setDisplacement(engineInfo[2]);
                } else {
                    engine.setEfficiency(engineInfo[2]);
                }
            } else if (engineInfo.length == 4) {
                engine.setDisplacement(engineInfo[2]);
                engine.setEfficiency(engineInfo[3]);
            }

            engines.put(model, engine);
        }

        int carLines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < carLines; i++) {
            String[] carInfo = reader.readLine().split("\\s+");
            String carModel = carInfo[0];
            String engineModel = carInfo[1];
            Engine engine = engines.get(engineModel);

            Car car = new Car(carModel, engine);

            if (carInfo.length == 3) {
                if (Character.isDigit(carInfo[2].charAt(0))) {
                    car.setWeight(carInfo[2]);
                } else {
                    car.setColor(carInfo[2]);
                }
            } else if (carInfo.length == 4) {
                car.setWeight(carInfo[2]);
                car.setColor(carInfo[3]);
            }

            cars.add(car);
        }

        cars.forEach(c -> System.out.print(c.toString()));
    }
}