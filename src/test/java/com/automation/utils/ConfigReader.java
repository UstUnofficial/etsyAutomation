package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    public static void initProperties(){

        properties = new Properties();

        try {
            properties.load(new FileInputStream("src/test/resources/config/config.properties"));
        } catch (Exception e){

            System.out.println(e.getMessage());
        }

    }

    public static String getValue(String key){

        return properties.getProperty(key);
    }

    public static void saveValue(String key,String value){
        properties.setProperty(key,value);
        try {
            properties.save(new FileOutputStream("src/test/resources/config/config.properties"),"Done");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
