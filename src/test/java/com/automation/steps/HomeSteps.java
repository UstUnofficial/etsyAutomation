package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user opens the application")
    public void user_opens_the_application() {
        homePage.openApplication();
        homePage.setUp();

    }

    @When("user goes to the crazy deals section")
    public void userGoesToTheCrazyDealsSection() {
        homePage.goToCrazyDeals();
    }


    @When("user goes to the food section")
    public void user_goes_to_the_food_section() {
        homePage.goToFoodSection();
    }
    @Then("verify crazy deal navigator is displayed")
    public void verify_crazy_deal_navigator_is_displayed() {
        Assert.assertTrue(homePage.isCrazyDealNavigatorDisplayed());
        
    }
    @When("user opens each crazy deals")
    public void user_opens_each_crazy_deals() {
        for(int i = 1 ; i < HomePage.crazyDealsSize ; i++){
            homePage.clickOnCrazyDeals(i);
            Assert.assertTrue(homePage.isCrazyDealPageOpened(i));
        }
        
    }
    @Then("verify that crazy deal is opened")
    public void verify_that_crazy_deal_is_opened() {
        
    }

}
