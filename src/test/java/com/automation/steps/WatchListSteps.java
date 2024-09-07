package com.automation.steps;

import com.automation.pages.WatchListPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WatchListSteps {
    WatchListPage watchListPage = new WatchListPage();

    @Then("verify the product is added to watch list")
    public void verifyTheProductIsAddedToWatchList() {
        Assert.assertTrue(watchListPage.productAddedToWatchlist());
    }

    @When("user remove the product from watchlist")
    public void userRemoveTheProductFromWatchlist() {
        watchListPage.removeProductFromWatchList();
    }

    @Then("verify the watchlist is empty")
    public void verifyTheWatchlistIsEmpty() {
        Assert.assertTrue(watchListPage.watchListIsEmpty());
    }
}
