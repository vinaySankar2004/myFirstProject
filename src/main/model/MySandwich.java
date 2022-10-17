package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MySandwich {
    private List<String> fillings;
    private HashMap<String, Double> addedFillings;
    private boolean isToasted;
    private boolean isSixInch;

    public MySandwich() {
        fillings = new ArrayList<>();
        addedFillings = new HashMap<>();
    }

    public void addComponent(SandwichOrder sc) {
        fillings.add(sc.getName());
        addedFillings.put(sc.getName(), sc.getPrice());
    }

    public void addExtra(SandwichOrder sc) {
        addedFillings.replace(sc.getName(), (addedFillings.get(sc.getName()) + sc.getPrice()));
    }

    public void setIsSixInch() {
        isSixInch = true;
    }

    public boolean getIsSixInch() {
        return isSixInch;
    }

    public List<String> getFillings() {
        return fillings;
    }

    public HashMap<String, Double> getAddedFillings() {
        return addedFillings;
    }

    public double returnPriceWithoutTax() {
        double priceWithoutTax = 0;
        for (int i = 0; i < fillings.size(); i++) {
            priceWithoutTax += addedFillings.get(fillings.get(i));
        }
        if (getIsSixInch()) {
            priceWithoutTax = (priceWithoutTax / 2) + 1.20;
        }
        return priceWithoutTax;
    }

    public double returnPriceWithTax() {
        double price = returnPriceWithoutTax();
        price += (price * 0.07);
        return price;
    }

    @Override
    public String toString() {
        String price = String.format("%.2f", returnPriceWithTax());  // get balance to 2 decimal places as a string
        return ("\nThe total price for your order (including tax) is $" + price + "\nThank you for using MySandwich!");
    }
}
