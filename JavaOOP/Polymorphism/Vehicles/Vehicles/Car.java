package Polymorphism.Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    protected Car(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm + 0.9);
    }

    @Override
    public void drive(double distance) {
        if (distance * this.getFuelConsumptionPerKm() <= this.getFuelQuantity()) {
            DecimalFormat format = new DecimalFormat("#.##");
            this.reduceFuel(distance * this.getFuelConsumptionPerKm());
            System.out.println(String.format("Car travelled %s km", format.format(distance)));
        } else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void refuel(double fuel) {
        this.addFuel(fuel);
    }
}