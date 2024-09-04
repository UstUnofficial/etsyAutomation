package com.automation.pages;

import org.openqa.selenium.By;

public class CategoryListPage extends BasePage{

    public void clickOnTheProductCategory(String category) {

        String xpath = "//android.widget.TextView[@text='%s']";
        xpath = String.format(xpath, category);
        driver.findElement(By.xpath(xpath)).click();

        //android.widget.TextView[@text="Books & Magazines"]

    }

    public void clickOnTheProductSubCategory(String subCategory) {
        String xpath = "//android.widget.TextView[@text='%s']";
        xpath = String.format(xpath, subCategory);
        driver.findElement(By.xpath(xpath)).click();

    }
}
