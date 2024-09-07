package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user opens the application")
    public void user_opens_the_application() {
        homePage.openApplication();
    }

    @Then("verify user is on home Page")
    public void verify_user_is_on_home_page() {
        Assert.assertTrue(homePage.isHomePageDispalyed());
    }

    @When("clicks on category")
    public void clicks_on_category() {
       homePage.clickOnCategories();
    }

    @When("user search for product {string}")
    public void userSearchForProduct(String productName) {
        homePage.searchProduct(ConfigReader.getValue(productName));
    }

    @When("user search for product laptop {string}")
    public void userSearchForProductLaptop(String productName) {
        homePage.searchProduct(productName);
    }

    @When("user clicks on {string}")
    public void user_clicks_on(String tabOption) {

        homePage.clickOnNavigationTab(tabOption);
        
    }
}
