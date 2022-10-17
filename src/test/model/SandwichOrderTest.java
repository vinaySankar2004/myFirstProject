package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SandwichOrderTest {
    private SandwichOrder bread;
    private SandwichOrder cheese;
    private SandwichOrder protein;
    private SandwichOrder vegetable;
    private SandwichOrder sauce;
    private SandwichOrder seasoning;
    private MySandwich myOrder;

    @BeforeEach
    public void runBefore() {
        bread = new Bread("Bread 1", 3.50);
        cheese = new Cheese("Cheese 1", 3.50);
        protein = new Protein("Protein 1", 4.00);
        vegetable = new Vegetable("Vegetable 1", 1.00);
        sauce = new Sauce("Sauce 1", 2.50);
        seasoning = new Seasoning("Salt & Pepper", 0.00);
        myOrder = new MySandwich();
    }

    @Test
    public void testSandwichOrderConstructor() {
        assertEquals("Bread 1", bread.getName());
        assertEquals("Cheese 1", cheese.getName());
        assertEquals("Protein 1", protein.getName());
        assertEquals("Vegetable 1", vegetable.getName());
        assertEquals("Sauce 1", sauce.getName());
        assertEquals("Salt & Pepper", seasoning.getName());
        assertEquals(3.50, bread.getPrice());
        assertEquals(3.50, cheese.getPrice());
        assertEquals(4.00, protein.getPrice());
        assertEquals(1.00, vegetable.getPrice());
        assertEquals(2.50, sauce.getPrice());
        assertEquals(0.00, seasoning.getPrice());
        assertEquals(0, myOrder.getFillings().size());
        HashMap<String, Double> hash = new HashMap<>();
        assertEquals(hash, myOrder.getAddedFillings());
    }

    @Test
    public void testAddComponentOneAdded() {
        myOrder.addComponent(bread);
        assertEquals(1, myOrder.getFillings().size());
        HashMap<String, Double> hash = new HashMap<>();
        hash.put("Bread 1", 3.50);
        assertEquals(hash, myOrder.getAddedFillings());
    }

    @Test
    public void testAddComponentMultipleAdded() {
        myOrder.addComponent(bread);
        myOrder.addComponent(protein);
        myOrder.addComponent(vegetable);
        assertEquals(3, myOrder.getFillings().size());
        HashMap<String, Double> hash = new HashMap<>();
        hash.put("Bread 1", 3.50);
        hash.put("Protein 1", 4.00);
        hash.put("Vegetable 1", 1.00);
        assertEquals(hash, myOrder.getAddedFillings());
    }

    @Test
    public void testAddExtra() {
        myOrder.addComponent(vegetable);
        myOrder.addExtra(vegetable);
        assertEquals(1, myOrder.getFillings().size());
        HashMap<String, Double> hash = new HashMap<>();
        hash.put("Vegetable 1", (1.00 * 2));
        assertEquals(hash, myOrder.getAddedFillings());
        myOrder.addExtra(vegetable);
        hash.put("Vegetable 1", (1.00 * 3));
        assertEquals(hash, myOrder.getAddedFillings());
    }

    @Test
    public void testReturnPriceWithoutTaxNotSixInch() {
        myOrder.addComponent(bread);
        myOrder.addComponent(cheese);
        myOrder.addComponent(protein);
        myOrder.addComponent(vegetable);
        myOrder.addComponent(sauce);
        myOrder.addComponent(seasoning);
        double price = 14.50;
        assertEquals(price, myOrder.returnPriceWithoutTax());
    }

    @Test
    public void testReturnPriceWithoutTaxSixInch() {
        myOrder.addComponent(bread);
        myOrder.addComponent(cheese);
        myOrder.addComponent(protein);
        myOrder.addComponent(vegetable);
        myOrder.addComponent(sauce);
        myOrder.addComponent(seasoning);
        myOrder.setIsSixInch();
        double price = 8.45;
        assertEquals(price, myOrder.returnPriceWithoutTax());
    }

    @Test
    public void testReturnPriceWithTax() {
        myOrder.addComponent(bread);
        myOrder.addComponent(cheese);
        myOrder.addComponent(protein);
        myOrder.addComponent(vegetable);
        myOrder.addComponent(sauce);
        myOrder.addComponent(seasoning);
        double price = 15.515;
        assertEquals(price, myOrder.returnPriceWithTax());
    }

    @Test
    public void testToString() {
        myOrder.addComponent(bread);
        myOrder.addComponent(cheese);
        myOrder.addComponent(protein);
        myOrder.addComponent(vegetable);
        myOrder.addComponent(sauce);
        myOrder.addComponent(seasoning);
        double price = 15.52;
        String string = "\nThe total price for your order (including tax) is $" + price + "\nThank you for using MySandwich!";
        assertEquals(string, myOrder.toString());
    }


}