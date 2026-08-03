package com.orangehrm.utilities;

import com.orangehrm.Constants.Env;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    public PropertiesUtil() throws FileNotFoundException {
    }

    public static String loadPropertiesFile(Env env, String propertyname){
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/config/" + env + ".properties");
        FileReader fileReader = null;
        Properties prop = new Properties();
        try {
            fileReader = new FileReader(file);
            prop.load(fileReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.get(propertyname).toString();
    }

}
