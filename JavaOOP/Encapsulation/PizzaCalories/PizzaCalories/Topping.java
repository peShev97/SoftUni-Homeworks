package Encapsulation.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;
    private double toppingTypeModifier;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private String getToppingType() {
        return this.toppingType;
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
                this.toppingTypeModifier = 1.2;
                break;
            case "Veggies":
                this.toppingTypeModifier = 0.8;
                break;
            case "Cheese":
                this.toppingTypeModifier = 1.1;
                break;
            case "Sauce":
                this.toppingTypeModifier = 0.9;
                break;
            default:
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }

        this.toppingType = toppingType;
    }

    private double getWeight() {
        return this.weight;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.getToppingType()));
        }

        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * this.getWeight()) * this.toppingTypeModifier;
    }
}