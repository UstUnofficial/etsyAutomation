package com.automation.steps;

import com.automation.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

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

}
