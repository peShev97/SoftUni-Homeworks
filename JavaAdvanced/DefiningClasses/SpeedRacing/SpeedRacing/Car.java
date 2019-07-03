package DefiningClasses.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private double distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = 0;
    }

    public double getFuelAmount() { return this.fuelAmount; }

    public double getFuelCostPerKm() { return this.fuelCostPerKm; }

    public String getModel() { return this.model; }

    public double getDistanceTraveled() { return this.distanceTraveled; }

    public void drive(double distance) {
        this.fuelAmount -= distance * fuelCostPerKm;
        this.distanceTraveled += distance;
    }
}