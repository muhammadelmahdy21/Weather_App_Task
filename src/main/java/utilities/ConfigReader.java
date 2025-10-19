package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static Properties props = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("ConfigurationFile.properties")) {
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }
}
