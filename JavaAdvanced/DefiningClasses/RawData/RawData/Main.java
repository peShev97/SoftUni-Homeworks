package DefiningClasses.RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Car> cars = new ArrayList<>();

        int lines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lines; i++) {
            String[] info = reader.readLine().split("\\s+");
            String model = info[0];
            int engineSpeed = Integer.parseInt(info[1]);
            int enginePower = Integer.parseInt(info[2]);
            int cargoWeight = Integer.parseInt(info[3]);
            String cargoType = info[4];
            double tireOnePressure = Double.parseDouble(info[5]);
            int tireOneAge = Integer.parseInt(info[6]);
            double tireTwoPressure = Double.parseDouble(info[7]);
            int tireTwoAge = Integer.parseInt(info[8]);
            double tireThreePressure = Double.parseDouble(info[9]);
            int tireThreeAge = Integer.parseInt(info[10]);
            double tireFourPressure = Double.parseDouble(info[11]);
            int tireFourAge = Integer.parseInt(info[12]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tireOnePressure, tireOneAge,
                    tireTwoPressure, tireTwoAge, tireThreePressure, tireThreeAge, tireFourPressure, tireFourAge);

            cars.add(car);
        }

        String word = reader.readLine();

        Predicate<Car> tirePressure = c -> c.getTireOnePressure() < 1 || c.getTireTwoPressure() < 1 ||
                c.getTireThreePressure() < 1 || c.getTireFourPressure() < 1;

        cars.stream()
                .filter(c -> word.equals("fragile") ? c.getCargoType().equals(word) && tirePressure.test(c) :
                        c.getCargoType().equals("flamable") && c.getEnginePower() > 250)
                .forEach(c -> System.out.println(c.getModel()));

    }
}
