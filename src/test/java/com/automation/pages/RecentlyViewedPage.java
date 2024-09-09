package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RecentlyViewedPage extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[@text=\"Recently viewed\"]")
    WebElement recentlyViewedText;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/following-sibling::android.view.View//android.widget.TextView[1]")
    List<WebElement> recentlyViewedProductList;


    public boolean isOnRecentlyViewedPage() {
        return isDisplayed(recentlyViewedText);
    }

    public String recentlyProductListTitle() {
        return recentlyViewedProductList.get(0).getText();
    }

}
