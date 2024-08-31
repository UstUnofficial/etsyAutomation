package com.automation.pages;

import com.automation.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {
    AppiumDriver driver;

    public BasePage(){

        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed(WebElement element){

        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public boolean isPresent(WebElement element){
        try {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            return element.isDisplayed();

        } catch (Exception e) {

            return false;

        } finally {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        }
    }

}
