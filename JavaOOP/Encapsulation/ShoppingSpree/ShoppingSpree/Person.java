package Encapsulation.ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() { return this.name; }

    private void setName(String name) {
        if (name.trim().length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    private double getMoney() { return this.money; }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public List<Product> getProducts() { return Collections.unmodifiableList(this.products); }

    public void buyProduct(Product product) {
        if (product.getCost() > this.getMoney()) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.getName(), product.getName()));
        }

        this.setMoney(this.getMoney() - product.getCost());
        this.products.add(product);
        System.out.println(String.format("%s bought %s", this.getName(), product.getName()));
    }
}