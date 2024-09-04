package com.automation.pages;

import org.openqa.selenium.By;

public class CategoryPage extends BasePage{

    public boolean isOnCategoryPage(String category) {
        String xpath = "//android.widget.TextView[@text='%s']";
        xpath = String.format(xpath, category);
        return isDisplayed(driver.findElement(By.xpath(xpath)));
    }
}
