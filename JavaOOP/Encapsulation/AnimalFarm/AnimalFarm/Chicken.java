package Encapsulation.AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private String getName() { return this.name; }

    private void setName(String name) {
        if (name.length() < 1 || name.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = name;
    }

    private int getAge() { return this.age; }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age shold be between 0 and 15.");
        }

        this.age = age;
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.getName(), this.getAge(), this.productPerDay());
    }

    private double calculateProductPerDay() {
        if (this.getAge() < 6) {
            return 2;
        } else if (this.getAge() < 12) {
            return 1;
        }

        return 0.75;
    }
}