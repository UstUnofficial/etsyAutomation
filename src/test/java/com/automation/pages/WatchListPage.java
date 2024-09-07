package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchListPage extends BasePage{


    @FindBy(xpath = "//android.view.View[@content-desc=\"Swipe to Refresh\"]/android.view.View/android.view.View/android.widget.CheckBox")
    List<WebElement> checkboxList;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Swipe to Refresh\"]/android.view.View[2]/android.view.View/android.widget.Button")
    WebElement listTag;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Close sheet\"]")
    WebElement closeSheet;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Swipe to Refresh\"]/android.view.View[5]/android.view.View/android.view.View[3]/android.widget.Button")
    List<WebElement> removeMenu;

    @FindBy(xpath = "//android.widget.TextView[@text=\"There's nothing here\"]")
    WebElement emptyWishlistText;

    @FindBy(xpath = "//android.widget.TextView[@text='Delete from Watchlist']")
    WebElement deleteOption;


    public boolean productAddedToWatchlist() {
        if(removeMenu.size()>0){
            return true;
        }
        return false;
    }

    public void removeProductFromWatchList() {
        listTag.click();
        closeSheet.click();
        for (WebElement menu : removeMenu){
            menu.click();
            deleteOption.click();

        }
    }

    public boolean watchListIsEmpty() {
        return isDisplayed(emptyWishlistText);
    }
}
