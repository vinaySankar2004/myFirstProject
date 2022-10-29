package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//represents the order
public class MySandwich implements Writable {
    private List<SandwichComponent> fillings;
    private HashMap<String, Double> addedFillings;
    private boolean isSixInch;

    //EFFECTS: initialises an array list and a hash map to keep track of the order
    public MySandwich() {
        fillings = new ArrayList<>();
        addedFillings = new HashMap<>();
        isSixInch = false;
    }

    //MODIFIES: this
    //EFFECTS: adds the sandwich component to the list and hash map (with price)
    public void addComponent(SandwichComponent sc) {
        if (!addedFillings.containsKey(sc.getName())) {
            fillings.add(sc);
            addedFillings.put(sc.getName(), sc.getPrice());
        } else {
            fillings.add(sc);
            addExtra(sc);
        }
    }

    //MODIFIES: this
    //EFFECTS: updates the price of the associated component name in the hash map
    public void addExtra(SandwichComponent sc) {
        addedFillings.replace(sc.getName(), (addedFillings.get(sc.getName()) + sc.getPrice()));
    }

    //MODIFIES: this
    //EFFECTS: makes the sandwich six inch if true, false otherwise
    public void setIsSixInch() {
        isSixInch = true;
    }

    //EFFECTS: retrieves isSixInch
    public boolean getIsSixInch() {
        return isSixInch;
    }

    //EFFECTS: retrieves the list of added component names
    public List<SandwichComponent> getFillings() {
        return fillings;
    }

    //EFFECTS: retrieves the hash map of added components and their prices
    public HashMap<String, Double> getAddedFillings() {
        return addedFillings;
    }

    //REQUIRES: there must be at least one component of the sandwich ordered
    //EFFECTS: returns the price of the sandwich before tax
    public double returnPriceWithoutTax() {
        double priceWithoutTax = 0;
        for (int i = 0; i < fillings.size(); i++) {
            priceWithoutTax += fillings.get(i).getPrice();
        }
        if (getIsSixInch()) {
            priceWithoutTax = (priceWithoutTax / 2) + 1.20;
        }
        return priceWithoutTax;
    }

    //EFFECTS: returns the price of the sandwich with 7% tax
    public double returnPriceWithTax() {
        double price = returnPriceWithoutTax();
        price += (price * 0.07);
        return price;
    }

    //EFFECTS: returns receipt string of taxed price, and thanks user for using MySandwich
    @Override
    public String toString() {
        String price = String.format("%.2f", returnPriceWithTax());  // get balance to 2 decimal places as a string
        return ("\nThe total price for this order (including tax) is $" + price + "\nThank you for using MySandwich!");
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("fillings", this.fillingsToJson());
        json.put("isSixInch", this.isSixInch);
        return json;
    }

    private JSONArray fillingsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < fillings.size(); i++) {
            jsonArray.put(fillings.get(i).toJson());
        }
        return jsonArray;
    }
}
