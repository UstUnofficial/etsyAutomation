package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Given;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user opens the application")
    public void user_opens_the_application() {
        homePage.openApplication();

    }

}
