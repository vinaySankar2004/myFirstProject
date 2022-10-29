package persistence;

import model.MySandwich;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            List<MySandwich> mySandwiches = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    void testReaderEmptyList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyList.json");
        try {
            List<MySandwich> mySandwiches = reader.read();
            assertEquals(0, mySandwiches.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderWithOneSandwich() {
        JsonReader reader = new JsonReader("./data/testReaderWithOneSandwich.json");
        try {
            List<MySandwich> mySandwiches = reader.read();
            assertEquals(1, mySandwiches.size());
            checkFilling("Italian, Herbs and Cheese", 1, mySandwiches.get(0).getFillings().get(0));
            checkFilling("Feta Cheese", 2, mySandwiches.get(0).getFillings().get(1));
            checkFilling("Bacon Strips", 1, mySandwiches.get(0).getFillings().get(2));
            checkFilling("Tomato", 0.35, mySandwiches.get(0).getFillings().get(3));
            assertFalse(mySandwiches.get(0).getIsSixInch());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderWithMultipleSandwich() {
        JsonReader reader = new JsonReader("./data/testReaderWithMultipleSandwich.json");
        try {
            List<MySandwich> mySandwiches = reader.read();
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
            fail("Couldn't read from file");
        }
    }
}
