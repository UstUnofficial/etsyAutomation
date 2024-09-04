package com.automation.pages;

import com.automation.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasePage {
    AppiumDriver driver;

    public BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed(WebElement element) {

        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public boolean isPresent(WebElement element) {
        try {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            System.out.println(element.isDisplayed());
            return element.isDisplayed();

        } catch (Exception e) {
            return false;

        } finally {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        }
    }

    public void scrollOrSwipe(int startX, int startY, int endX, int endY) {

//        System.out.println(startX + " " + startY);
//        System.out.println(endX + " " + endY);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(2)))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singleton(sequence));

    }

    public List<WebElement> scrollTillAndGet(WebElement tillElement, WebElement getElement) {
        List<WebElement> returnElement = new ArrayList<>();

        while (!isPresent(tillElement)) {
            returnElement.add(getElement);
        }

        System.out.println("test");
        return returnElement;
    }

}
