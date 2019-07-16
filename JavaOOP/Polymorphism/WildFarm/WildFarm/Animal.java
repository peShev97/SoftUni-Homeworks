package Polymorphism.WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private static final String DECIMAL_FORMAT_STR = "#.##";

    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    protected String getAnimalName() { return this.animalName; }

    protected String getAnimalType() { return this.animalType; }

    protected Double getAnimalWeight() { return this.animalWeight; }

    public String getAnimalWeightFormatted() {
        DecimalFormat format = new DecimalFormat(DECIMAL_FORMAT_STR);
        return format.format(this.getAnimalWeight());
    }

    protected Integer getFoodEaten() { return this.foodEaten; }

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);
}