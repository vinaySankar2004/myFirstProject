package persistence;

import model.SandwichComponent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkFilling(String name, double price, SandwichComponent sc) {
        assertEquals(name, sc.getName());
        assertEquals(price, sc.getPrice());
    }
}
