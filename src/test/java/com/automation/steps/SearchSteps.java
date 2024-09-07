package com.automation.steps;

import com.automation.pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchSteps {
    SearchPage searchPage = new SearchPage();

    @Then("verify clear search is present")
    public void verifyClearSearchIsPresent() {
        Assert.assertTrue(searchPage.clearSearchIsDisplayed());
    }

    @When("user clicks on clear search")
    public void userClicksOnClearSearch() {
        searchPage.clickOnClearSearch();
    }

    @Then("verify search history has been cleared")
    public void verifySearchHistoryHasBeenCleared() {

        Assert.assertTrue(searchPage.searchHistoryIsCleared());

    }
}
