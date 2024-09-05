package com.automation.pages;

import org.checkerframework.checker.interning.qual.FindDistinct;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sign out\"]")
    WebElement logoutLink;
    public boolean isSettingsPageDisplayed() {
        return isDisplayed(logoutLink);
    }

    public void clickOnLogout() {
        logoutLink.click();
    }
}
