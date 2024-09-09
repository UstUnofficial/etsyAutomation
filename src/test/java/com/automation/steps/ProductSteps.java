package com.automation.steps;

import com.automation.pages.ProductPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ProductSteps {

    ProductPage productPage = new ProductPage();


    @And("user click on {string} button")
    public void userClickOnButton(String button) {
        productPage.clickOnButtons(button);
    }

    @And("user go back to home page")
    public void userGoBackToHomePage() {
        productPage.goBackToHome();
    }

    @Then("verify user is on first product")
    public void verifyUserIsOnFirstProduct() {
        Assert.assertTrue(productPage.isOnFirstProductPage());


    }


    @And("user store the product title as {string}")
    public void userStoreTheProductTitleAs(String key) {
        productPage.storeTitleOfProduct(key);
        System.out.println(ConfigReader.getValue("product.title"));

    }
}
