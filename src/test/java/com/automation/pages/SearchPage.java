package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    @FindBy(id = "com.ebay.mobile:id/button_clear_recent_searches")
    WebElement clearSearchLink;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    WebElement confirmClear;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Search on eBay\"]")
    WebElement searchOnEbayText;

    public boolean clearSearchIsDisplayed() {
        return isDisplayed(clearSearchLink);
    }

    public void clickOnClearSearch() {
        clearSearchLink.click();
        confirmClear.click();
    }

    public boolean searchHistoryIsCleared() {
        return isDisplayed(searchOnEbayText);
    }
}
