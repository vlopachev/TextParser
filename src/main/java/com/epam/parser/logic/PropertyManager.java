package com.epam.parser.logic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private Properties properties = new Properties();

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public PropertyManager(String fileName) {
        try (InputStream inputStream =
                     PropertyManager.class.getClassLoader().getResourceAsStream(fileName);){
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
