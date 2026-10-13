package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            FileInputStream fis =
                    new FileInputStream("src/test/resources/config/config.properties");

            properties = new Properties();
            properties.load(fis);
            fis.close();

        } catch (IOException e) {
            throw new RuntimeException("Config file not found", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}