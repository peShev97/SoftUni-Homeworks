package Polymorphism.Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    protected Truck(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm + 1.6);
    }

    @Override
    public void drive(double distance) {
        if (distance * this.getFuelConsumptionPerKm() <= this.getFuelQuantity()) {
            DecimalFormat format = new DecimalFormat("#.##");
            this.reduceFuel(distance * this.getFuelConsumptionPerKm());
            System.out.println(String.format("Truck travelled %s km", format.format(distance)));
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refuel(double fuel) {
        this.addFuel(fuel * 0.95);
    }
}