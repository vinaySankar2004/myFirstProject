package persistence;

import model.MySandwich;
import model.SandwichComponent;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {
    @Test
    void testWriterInvalidFile() {
        try {
            List<MySandwich> sandwiches = new ArrayList<>();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyList() {
        try {
            List<MySandwich> sandwiches = new ArrayList<>();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyList.json");
            writer.open();
            writer.write(sandwiches);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyList.json");
            sandwiches = reader.read();
            assertEquals(0, sandwiches.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterWithOneSandwich() {
        try {
            MySandwich mySandwich = new MySandwich();
            mySandwich.addComponent(new SandwichComponent("Italian, Herbs and Cheese", 1));
            mySandwich.addComponent(new SandwichComponent("Feta Cheese", 2));
            mySandwich.addComponent(new SandwichComponent("Bacon Strips", 1));
            mySandwich.addComponent(new SandwichComponent("Tomato", 0.35));
            List<MySandwich> mySandwiches = new ArrayList<>();
            JsonWriter writer = new JsonWriter("./data/testWriterWithOneSandwich.json");
            mySandwiches.add(mySandwich);
            writer.open();
            writer.write(mySandwiches);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterWithOneSandwich.json");
            mySandwiches = reader.read();
            assertEquals(1, mySandwiches.size());
            checkFilling("Italian, Herbs and Cheese", 1, mySandwiches.get(0).getFillings().get(0));
            checkFilling("Feta Cheese", 2, mySandwiches.get(0).getFillings().get(1));
            checkFilling("Bacon Strips", 1, mySandwiches.get(0).getFillings().get(2));
            checkFilling("Tomato", 0.35, mySandwiches.get(0).getFillings().get(3));
            assertFalse(mySandwiches.get(0).getIsSixInch());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterWithMultipleSandwich() {
        try {
            MySandwich mySandwich = new MySandwich();
            mySandwich.addComponent(new SandwichComponent("Italian, Herbs and Cheese", 1));
            mySandwich.addComponent(new SandwichComponent("Feta Cheese", 2));
            mySandwich.addComponent(new SandwichComponent("Ham", 1.5));
            MySandwich mySandwich1 = new MySandwich();
            mySandwich1.addComponent(new SandwichComponent("English Bread", 1));
            mySandwich1.addComponent(new SandwichComponent("Cheddar Cheese", 1.5));
            mySandwich1.addComponent(new SandwichComponent("Veggie Patty", 1.5));
            mySandwich1.setIsSixInch();
            List<MySandwich> mySandwiches = new ArrayList<>();
            JsonWriter writer = new JsonWriter("./data/testWriterWithOneSandwich.json");
            mySandwiches.add(mySandwich);
            mySandwiches.add(mySandwich1);
            writer.open();
            writer.write(mySandwiches);
            writer.close();
            assertEquals(2, mySandwiches.size());
            checkFilling("Italian, Herbs and Cheese", 1, mySandwiches.get(0).getFillings().get(0));
            checkFilling("Feta Cheese", 2, mySandwiches.get(0).getFillings().get(1));
            checkFilling("Ham", 1.5, mySandwiches.get(0).getFillings().get(2));
            assertFalse(mySandwiches.get(0).getIsSixInch());
            checkFilling("English Bread", 1, mySandwiches.get(1).getFillings().get(0));
            checkFilling("Cheddar Cheese", 1.5, mySandwiches.get(1).getFillings().get(1));
            checkFilling("Veggie Patty", 1.5, mySandwiches.get(1).getFillings().get(2));
            assertTrue(mySandwiches.get(1).getIsSixInch());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
