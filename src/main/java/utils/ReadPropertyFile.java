package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

    private ReadPropertyFile(){

    }
    public static String get(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("/Users/prerana/IdeaProjects/FlipkartAutomation/src/main/resources/config.properties");
        prop.load(file);
        return prop.getProperty(key);
    }

}
