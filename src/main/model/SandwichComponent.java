package model;

//represents a sandwich component
public class SandwichComponent {
    protected String name;
    protected double price;

    //EFFECTS: produces a sandwich component with a name and a price
    public SandwichComponent(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //EFFECTS: retrieves the name of the component
    public String getName() {
        return this.name;
    }

    //EFFECTS: retrieves the price of the component
    public double getPrice() {
        return this.price;
    }
}
