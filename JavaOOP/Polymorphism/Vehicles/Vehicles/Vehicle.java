package Polymorphism.Vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    protected double getFuelQuantity() { return this.fuelQuantity; }

    protected double getFuelConsumptionPerKm() { return this.fuelConsumptionPerKm; }

    protected void addFuel(double fuel) {
        this.fuelQuantity += fuel;
    }

    protected void reduceFuel(double fuel) {
        this.fuelQuantity -= fuel;
    }

    public abstract void drive(double distance);

    public abstract void refuel(double fuel);
}