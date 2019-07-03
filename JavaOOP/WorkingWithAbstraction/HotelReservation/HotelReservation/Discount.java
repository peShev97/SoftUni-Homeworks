package WorkingWithAbstraction.HotelReservation;

public enum Discount {
    VIP(20),
    SECONDVISIT(10),
    NONE(0);

    private int percent;

    Discount(int percent) {
        this.percent = percent;
    }

    public int getPercent() { return this.percent; }
}
