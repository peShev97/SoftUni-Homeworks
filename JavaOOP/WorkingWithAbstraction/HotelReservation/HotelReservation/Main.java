package WorkingWithAbstraction.HotelReservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] info = reader.readLine().split("\\s+");

        Season season = Season.valueOf(info[2].toUpperCase());
        Discount discount = Discount.valueOf(info[3].toUpperCase());

        Reservation reservation = new Reservation(Double.parseDouble(info[0]), Integer.parseInt(info[1]), season, discount);

        System.out.println(String.format("%.2f", PriceCalculator.calculate(reservation)));
    }
}