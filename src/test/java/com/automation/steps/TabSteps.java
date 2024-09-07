package com.automation.steps;

import com.automation.pages.TabPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TabSteps {

    TabPage tabPage = new TabPage();

    @Then("verify {string} title is displayed")
    public void verify_title_is_displayed(String tabOption) {

        Assert.assertTrue(tabPage.isTabDisplayed(tabOption));

    }

    @When("user clicks on the sign in")
    public void user_clicks_on_the_sign_in() {
        tabPage.clickOnSignInLink();


    }

    @Then("verify username {string} is displayed")
    public void verify_username_is_displayed(String userName) {
        Assert.assertTrue(tabPage.isUserNameCorrect(ConfigReader.getValue(userName)));

    }


    @When("user clicks on settings")
    public void user_clicks_on_settings() {

        tabPage.clickOnSettings();
        
    }

    @And("user click on watchlist")
    public void userClickOnWatchlist() {
        tabPage.clickOnWatchlist();
    }



}
