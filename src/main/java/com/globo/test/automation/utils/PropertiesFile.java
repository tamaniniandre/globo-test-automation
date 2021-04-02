package com.globo.test.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

    public static Properties readPropertiesFile(){
        Properties prop = new Properties();
        try {
            //load a properties file from class path, inside static method
            prop.load(new FileInputStream("serenity.properties"));

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}
