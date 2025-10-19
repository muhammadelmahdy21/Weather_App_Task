package utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

public class JsonUtils {

    private static final JSONParser parser = new JSONParser();

    /**
     * Appends a new JSON object into a JSON array file.
     */
    public static void appendToJsonFile(String filePath, Map<String, Object> data) {
        JSONArray jsonArray = readJsonArray(filePath);

        JSONObject newEntry = new JSONObject();
        newEntry.putAll(data);
        jsonArray.add(newEntry);

        writeJsonArray(filePath, jsonArray);
    }

    /**
     * Overwrites the JSON file with new data (clears old content).
     */
    public static void overwriteJsonFile(String filePath, List<Map<String, Object>> dataList) {
        JSONArray jsonArray = new JSONArray();
        for (Map<String, Object> map : dataList) {
            JSONObject obj = new JSONObject();
            obj.putAll(map);
            jsonArray.add(obj);
        }
        writeJsonArray(filePath, jsonArray);
    }

    /**
     * Reads a JSON array from file.
     * Returns an empty array if the file doesn't exist or is invalid.
     */
    public static JSONArray readJsonArray(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            return new JSONArray();
        }

        try (FileReader reader = new FileReader(file)) {
            Object obj = parser.parse(reader);
            if (obj instanceof JSONArray) {
                return (JSONArray) obj;
            }
        } catch (IOException | ParseException e) {
            System.err.println("⚠️ Error reading JSON file: " + e.getMessage());
        }
        return new JSONArray();
    }

    /**
     * Reads the last object from the JSON array.
     */
    public static JSONObject readLastEntry(String filePath) {
        JSONArray array = readJsonArray(filePath);
        if (array.isEmpty()) return null;
        return (JSONObject) array.get(array.size() - 1);
    }

    /**
     * Reads a specific key value from the last object.
     */
    public static Object readKeyValue(String filePath, String key) {
        JSONObject last = readLastEntry(filePath);
        if (last != null && last.containsKey(key)) {
            return last.get(key);
        }
        return null;
    }

    /**
     * Internal method to write JSON array safely to file.
     */
    private static void writeJsonArray(String filePath, JSONArray jsonArray) {
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(jsonArray.toJSONString());
            writer.flush();
            System.out.println("✅ JSON file updated successfully at: " + filePath);
        } catch (IOException e) {
            System.err.println("❌ Error writing JSON file: " + e.getMessage());
        }
    }
}