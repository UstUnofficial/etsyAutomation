package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManager {
    static AndroidDriver driver;

    public static void createDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability( "platformName",ConfigReader.getValue("platformName"));
        capabilities.setCapability( "deviceName",ConfigReader.getValue("deviceName"));
        capabilities.setCapability( "automationName",ConfigReader.getValue("automationName"));
        capabilities.setCapability( "app",System.getProperty("user.dir")+ConfigReader.getValue("appPath"));
        capabilities.setCapability( "appActivity",ConfigReader.getValue("appActivity"));
        capabilities.setCapability( "appPackage",ConfigReader.getValue("appPackage"));


        driver = new AndroidDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.setLocation(new Location(8.53584783597855, 76.88346393570237, 100));

    }

    public static AppiumDriver getDriver(){
        return driver;
    }

}
