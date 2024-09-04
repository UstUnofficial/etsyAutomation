package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Close']")
    WebElement closeIcon;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Search Keyword Search on eBay']")
    WebElement searchTab;


    @FindBy(id = "com.ebay.mobile:id/home_pill")
    List<WebElement> listOfCategory;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.ebay.mobile:id/home_pill' and @text = 'Categories']")
    WebElement categoryElement;

    public void openApplication() {
        if (isDisplayed(closeIcon)) {
            closeIcon.click();
        }
    }

    public boolean isHomePageDispalyed() {
        return isDisplayed(searchTab);
    }


    public void clickOnCategories() {
        List<WebElement> currentCardList = driver.findElements(By.xpath("//android.widget.Button[@resource-id='com.ebay.mobile:id/home_pill' and @text]"));

        int x = currentCardList.get(0).getLocation().getX();
        int y = currentCardList.get(0).getLocation().getY();
        int cardWidth = currentCardList.get(0).getSize().getWidth();
        int cardHeight = currentCardList.get(0).getSize().getHeight();

        while (!isPresent(categoryElement)) {

            scrollOrSwipe(x + cardWidth, y + cardHeight / 2, 0, y + cardHeight / 2);

            currentCardList = driver.findElements(By.xpath("//android.widget.Button[@resource-id='com.ebay.mobile:id/home_pill' and @text]"));
        }
        categoryElement.click();
    }
}


