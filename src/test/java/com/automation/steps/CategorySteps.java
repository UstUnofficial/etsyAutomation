package com.automation.steps;

import com.automation.pages.CategoryPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CategorySteps {

    CategoryPage categoryPage = new CategoryPage();


    @Then("verify user is on {string} category page")
    public void verifyUserIsOnCategoryPage(String category) {
        Assert.assertTrue(categoryPage.isOnCategoryPage(category));
    }
}
