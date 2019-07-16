package Polymorphism.Vehicles;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    protected Bus(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        this.addFuelConsumptionPerKm(1.4);
        this.driveEmpty(distance);
    }

    public void driveEmpty(double distance) {
        if (distance * this.getFuelConsumptionPerKm() <= this.getFuelQuantity()) {
            DecimalFormat format = new DecimalFormat("#.##");
            this.reduceFuel(distance * this.getFuelConsumptionPerKm());
            System.out.println(String.format("Bus travelled %s km", format.format(distance)));
        } else {
            System.out.println("Bus needs refueling");
        }
    }

    @Override
    public void refuel(double fuel) {
        this.addFuel(fuel);
    }
}