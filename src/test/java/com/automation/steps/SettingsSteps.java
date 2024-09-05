package com.automation.steps;

import com.automation.pages.SettingsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SettingsSteps {

    SettingsPage settingsPage = new SettingsPage();

    @Then("verify user is on settings page")
    public void verify_user_is_on_settings_page() {
        Assert.assertTrue(settingsPage.isSettingsPageDisplayed());
    }
    @When("user clicks on the signOut link")
    public void user_clicks_on_the_sign_link() {

        settingsPage.clickOnLogout();

    }
}
