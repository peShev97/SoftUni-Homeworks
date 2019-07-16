package Polymorphism.Vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.tankCapacity = tankCapacity;
    }

    protected double getFuelQuantity() { return this.fuelQuantity; }

    protected double getFuelConsumptionPerKm() { return this.fuelConsumptionPerKm; }

    protected double getTankCapacity() { return this.tankCapacity; }

    protected void addFuelConsumptionPerKm(double value) {
        this.fuelConsumptionPerKm += value;
    }

    protected void addFuel(double fuel) {
        if (this.fuelQuantity + fuel > this.getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += fuel;
        }
    }

    protected void reduceFuel(double fuel) {
        this.fuelQuantity -= fuel;
    }

    public abstract void drive(double distance);

    public abstract void refuel(double fuel);
}