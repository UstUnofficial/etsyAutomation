package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    @FindBy(xpath = "//android.widget.TextView[@text=\"About this item\"]")
    WebElement itemDescription;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    WebElement backNavigationBtn;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Add to watchlist\"]")
    WebElement wishlistIcon;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView//android.widget.TextView[@text]")
    WebElement productTitleText;


    public void clickOnButtons(String button) {

        Dimension dimension=driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while(!isPresent(itemDescription)){
            scrollOrSwipe(width/2,height/2,width/2,0);
        }
        String xpath = "//android.widget.Button[@text='%s']";
        xpath = String.format(xpath, button);
        driver.findElement(By.xpath(xpath)).click();


    }

    public void goBackToHome() {
        backNavigationBtn.click();

    }
    public boolean isOnFirstProductPage() {
        return isDisplayed(wishlistIcon);
    }

    public void storeTitleOfProduct(String key) {
        ConfigReader.saveValue(key,productTitleText.getText());
    }
}
