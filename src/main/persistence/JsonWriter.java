package persistence;

import model.MySandwich;
import model.SandwichComponent;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

// Represents a writer that writes JSON representation of mySandwiches to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of mySandwiches to file
    public void write(List<MySandwich> mySandwiches) {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (MySandwich s : mySandwiches) {
            jsonArray.put(s.toJson());
        }
        json.put("sandwiches", jsonArray);
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}

