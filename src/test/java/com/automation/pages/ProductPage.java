package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    @FindBy(xpath = "//android.widget.TextView[@text=\"About this item\"]")
    WebElement itemDescription;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    WebElement backNavigationBtn;


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
}
