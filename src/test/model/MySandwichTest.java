package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySandwichTest {
    private SandwichComponent bread;
    private SandwichComponent cheese;
    private SandwichComponent protein;
    private SandwichComponent vegetable;
    private SandwichComponent sauce;
    private SandwichComponent seasoning;
    private SandwichComponent drink;
    private SandwichComponent dessert;
    private MySandwich myOrder;

    @BeforeEach
    public void runBefore() {
        bread = new Bread("Bread 1", 3.50);
        cheese = new Cheese("Cheese 1", 3.50);
        protein = new Protein("Protein 1", 4.00);
        vegetable = new Vegetable("Vegetable 1", 1.00);
        sauce = new Sauce("Sauce 1", 2.50);
        seasoning = new Seasoning("Salt & Pepper", 0.00);
        drink = new Drink("Water", 1.20);
        dessert = new Dessert("Cake", 3.50);
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
        assertEquals("Water", drink.getName());
        assertEquals("Cake", dessert.getName());
        assertEquals(3.50, bread.getPrice());
        assertEquals(3.50, cheese.getPrice());
        assertEquals(4.00, protein.getPrice());
        assertEquals(1.00, vegetable.getPrice());
        assertEquals(2.50, sauce.getPrice());
        assertEquals(0.00, seasoning.getPrice());
        assertEquals(1.20, drink.getPrice());
        assertEquals(3.50, dessert.getPrice());
        assertEquals(0, myOrder.getFillings().size());
    }

    @Test
    public void testAddComponentOneAdded() {
        myOrder.addComponent(bread);
        assertEquals(1, myOrder.getFillings().size());
    }

    @Test
    public void testAddComponentMultipleAdded() {
        myOrder.addComponent(bread);
        myOrder.addComponent(protein);
        myOrder.addComponent(vegetable);
        assertEquals(3, myOrder.getFillings().size());
    }

    @Test
    public void testAddComponentDuplicateAdded() {
        myOrder.addComponent(bread);
        myOrder.addComponent(protein);
        myOrder.addComponent(protein);
        assertEquals(3, myOrder.getFillings().size());
    }

    @Test
    public void testReturnPriceWithoutTaxNotSixInch() {
        myOrder.addComponent(bread);
        myOrder.addComponent(cheese);
        myOrder.addComponent(protein);
        myOrder.addComponent(vegetable);
        myOrder.addComponent(sauce);
        myOrder.addComponent(seasoning);
        myOrder.setIsSixInch(false);
        assertFalse(myOrder.getIsSixInch());
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
        myOrder.setIsSixInch(true);
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
        String string = "\nThe total price for this order (including tax) is $" + price + "\nThank you for using MySandwich!";
        assertEquals(string, myOrder.toString());
    }


}