package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventHandlingTest {

    MySandwich myOrder;
    private SandwichComponent bread;
    private SandwichComponent cheese;
    private SandwichComponent protein;
    private SandwichComponent vegetable;
    private SandwichComponent sauce;
    private SandwichComponent seasoning;
    private SandwichComponent drink;
    private SandwichComponent dessert;

    @BeforeEach
    public void runBefore() {
        myOrder = new MySandwich();
        bread = new Bread("Bread 1", 3.50);
        cheese = new Cheese("Cheese 1", 3.50);
        protein = new Protein("Protein 1", 4.00);
        vegetable = new Vegetable("Vegetable 1", 1.00);
        sauce = new Sauce("Sauce 1", 2.50);
        seasoning = new Seasoning("Salt & Pepper", 0.00);
        drink = new Drink("Water", 1.20);
        dessert = new Dessert("Cake", 3.50);
        EventLog.getInstance().clear();
    }

    @Test
    public void testMakeASandwichEventHandling1() {
        myOrder.addComponent(bread);
        myOrder.addComponent(cheese);
        myOrder.addComponent(protein);
        myOrder.addComponent(vegetable);
        myOrder.addComponent(sauce);
        myOrder.addComponent(seasoning);
        myOrder.addComponent(drink);
        myOrder.addComponent(dessert);
        myOrder.setIsSixInch(true);
        int i = 0; //counter
        for (Event next : EventLog.getInstance()) {
            if (i == 0) {
                assertEquals("Event log cleared.", next.getDescription());
            }
            if (i > 0 && i < 9) {
                assertEquals("Added " + myOrder.getFillings().get(i-1).getName() + " to the sandwich order",
                        next.getDescription());
            }
            if (i >= 9) {
                assertEquals("Bread size is chosen to be 6 inches", next.getDescription());
            }
            i++;
        }
    }

    @Test
    public void testMakeASandwichEventHandling2() {
        myOrder.addComponent(bread);
        myOrder.addComponent(protein);
        myOrder.addComponent(cheese);
        myOrder.addComponent(sauce);
        myOrder.addComponent(vegetable);
        myOrder.addComponent(dessert);
        myOrder.addComponent(drink);
        myOrder.addComponent(dessert);
        myOrder.addComponent(seasoning);
        myOrder.setIsSixInch(false);
        int i = 0; //counter
        for (Event next : EventLog.getInstance()) {
            if (i == 0) {
                assertEquals("Event log cleared.", next.getDescription());
            }
            if (i > 0 && i < 10) {
                assertEquals("Added " + myOrder.getFillings().get(i-1).getName() + " to the sandwich order",
                        next.getDescription());
            }
            if (i >= 10) {
                assertEquals("Bread size is chosen to be 12 inches", next.getDescription());
            }
            i++;
        }
    }
}
