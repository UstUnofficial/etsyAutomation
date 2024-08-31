package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "com.etsy.android:id/cancelText")
    WebElement continueAsGuest;

    @FindBy(id = "com.etsy.android:id/empty_view_tertiary_button")
    WebElement locationSkip;

    public void openApplication() {
        if (isDisplayed(continueAsGuest)) {
            continueAsGuest.click();
            if (isPresent(locationSkip)) {
                locationSkip.click();

            }
        }

    }
}
