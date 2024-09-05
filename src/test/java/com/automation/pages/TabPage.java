package com.automation.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TabPage extends BasePage{


    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.ebay.mobile:id/primary_toolbar']//android.widget.TextView")
    WebElement tabTitle;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Sign in\"]")
    WebElement signInLink;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.ebay.mobile:id/bt_maybe_later\"]")
    WebElement skipForNow;

    @FindBy(xpath = "(//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.ebay.mobile:id/myebay_summary_compose_view\"]//android.widget.TextView)[2]")
    WebElement userNameElement;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Settings\"]")
    WebElement settingsLink;





    public boolean isTabDisplayed(String tabOption) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return isDisplayed(tabTitle) && tabTitle.getText().equalsIgnoreCase(tabOption);
    }

    public void clickOnSignInLink() {

        signInLink.click();

    }

    public boolean isUserNameCorrect(String userName) {
        if(isDisplayed(skipForNow)) {
            skipForNow.click();
        }
        System.out.println(userNameElement.getText() + "-11111111111111");
        System.out.println(userName + "-11111111111111111111");
        return userNameElement.getText().equalsIgnoreCase(userName);
    }

    public void clickOnSettings() {

        Dimension dimension = driver.manage().window().getSize();
        int x = dimension.getWidth();
        int y = dimension.getHeight();


        while(!isPresent(settingsLink)){

            scrollOrSwipe(x/2, y/2, x/2, 0);

        }
        settingsLink.click();

    }
}
