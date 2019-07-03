package WorkingWithAbstraction.HotelReservation;

public class PriceCalculator {
    public static double calculate(Reservation reservation) {
        double price = reservation.getPricePerDay() * reservation.getNumberOfDays() * reservation.getSeason().getMultiplier();

        double percent = 1 - (reservation.getDiscount().getPercent() / 100.0);

        return price * percent;
    }
}