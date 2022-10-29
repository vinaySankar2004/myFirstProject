package model;

import org.json.JSONObject;
import persistence.Writable;

//represents a sandwich component
public class SandwichComponent implements Writable {
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.name);
        json.put("price", this.price);
        return json;
    }



}
