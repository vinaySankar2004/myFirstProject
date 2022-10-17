package model;

public class SandwichOrder {
    protected String name;
    protected double price;

    public SandwichOrder(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
