package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

//represents the order
public class MySandwich implements Writable {
    private List<SandwichComponent> fillings;
    private boolean isSixInch;

    //EFFECTS: initialises an array list and a hash map to keep track of the order
    public MySandwich() {
        fillings = new ArrayList<>();
        isSixInch = false;
    }

    //MODIFIES: this
    //EFFECTS: adds the sandwich component to the list and hash map (with price)
    public void addComponent(SandwichComponent sc) {
        fillings.add(sc);
        EventLog.getInstance().logEvent(new Event("Added " + sc.getName() + " to the sandwich order"));
    }

    //MODIFIES: this
    //EFFECTS: adds the sandwich component to the list and hash map (with price)
    public void addComponent2(SandwichComponent sc) {
        fillings.add(sc);
    }

    //MODIFIES: this
    //EFFECTS: makes the sandwich six inch if true, false otherwise
    public void setIsSixInch(boolean b) {
        isSixInch = b;
        if (isSixInch == true) {
            EventLog.getInstance().logEvent(new Event("Bread size is chosen to be 6 inches"));
        } else {
            EventLog.getInstance().logEvent(new Event("Bread size is chosen to be 12 inches"));
        }
    }

    //MODIFIES: this
    //EFFECTS: makes the sandwich six inch if true, false otherwise
    public void setIsSixInch2(boolean b) {
        isSixInch = b;
    }

    //EFFECTS: retrieves isSixInch
    public boolean getIsSixInch() {
        return isSixInch;
    }

    //EFFECTS: retrieves the list of added component names
    public List<SandwichComponent> getFillings() {
        return fillings;
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
