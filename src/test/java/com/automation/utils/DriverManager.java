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
        capabilities.setCapability("autoGrandPermission", "true");


        driver = new AndroidDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.setLocation(new Location(8.51, 76.88, 100));

    }

    public static AndroidDriver getDriver(){
        return driver;
    }

}
