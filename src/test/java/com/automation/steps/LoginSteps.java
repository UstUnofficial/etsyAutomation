package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Then("verify sign in page is displayed")
    public void verify_sign_in_page_is_displayed() {

        Assert.assertTrue(loginPage.isSingInPageDisplayed());

    }
    @When("usr clicks on the user email or username")
    public void usr_clicks_on_the_user_email_or_username() {
        loginPage.clickOnUserNameOrEmail();

    }
    @Then("verify username input field is displayed")
    public void verify_username_input_field_is_displayed() {
        Assert.assertTrue(loginPage.isInputDisplayed());

    }
    @When("user does the sign in using the credentials {string} and {string}")
    public void user_does_the_sign_in_using_the_credentials_and(String userName, String password) {
        loginPage.doLogin(ConfigReader.getValue(userName), ConfigReader.getValue(password));

    }
}
