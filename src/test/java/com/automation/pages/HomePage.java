package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Get started']")
    WebElement getStartedBtn;

    @FindBy(xpath = "//android.widget.Button[@text='Skip']")
    WebElement skipIcon;

    @FindBy(xpath = "//android.view.View[@content-desc='Allow location access,Button,Allow location access']")
    WebElement enterLocationTab;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    WebElement whileUsingTheApp;

    @FindBy(id = "in.swiggy.android:id/not_now")
    WebElement notificationNotNow;

    public void openApplication() {
        if (isDisplayed(getStartedBtn)) {
            getStartedBtn.click();
        }
        if (isDisplayed(skipIcon)) {
            skipIcon.click();
        }
        if (isDisplayed(enterLocationTab)) {
            enterLocationTab.click();
        }
        if (isDisplayed(whileUsingTheApp)) {
            whileUsingTheApp.click();
        }
        if(isDisplayed(notificationNotNow)){
            notificationNotNow.click();
        }
    }

    public void setUp() {


    }
}
