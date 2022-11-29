package persistence;

import model.MySandwich;
import model.SandwichComponent;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Represents a reader that reads mySandwiches from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads mySandwiches from file and returns it;
    // throws IOException if an error occurs reading data from file
    public List<MySandwich> read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return addSandwiches(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses mySandwiches from JSON object and returns it
    private MySandwich parseSandwich(JSONObject jsonObject) {
        MySandwich sandwich = new MySandwich();
        boolean isSixInch = jsonObject.getBoolean("isSixInch");
        if (isSixInch) {
            sandwich.setIsSixInch2(true);
        }
        addComponents(sandwich, jsonObject);
        return sandwich;
    }

    //MODIFIES: sandwich
    //EFFECTS: parses components from JSON object and adds them to sandwich
    private List<MySandwich> addSandwiches(JSONObject jsonObject) {
        List<MySandwich> sandwiches = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("sandwiches");
        for (Object json : jsonArray) {
            JSONObject nextSandwich = (JSONObject) json;
            sandwiches.add(parseSandwich(nextSandwich));
        }
        return sandwiches;
    }

    // MODIFIES: sandwich
    // EFFECTS: parses components from JSON object and adds them to sandwich
    private void addComponents(MySandwich sandwich, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("fillings");
        for (Object json : jsonArray) {
            JSONObject nextComponent = (JSONObject) json;
            addComponent(sandwich, nextComponent);
        }
    }

    // MODIFIES: sandwich
    // EFFECTS: parses a single component from JSON object and adds it to sandwich
    private void addComponent(MySandwich sandwich, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Double price = jsonObject.getDouble("price");
        SandwichComponent component = new SandwichComponent(name, price);
        sandwich.addComponent2(component);
    }
}
