package com.automation.steps;

import com.automation.pages.RecentlyViewedPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class RecentlyViewedSteps {

    RecentlyViewedPage recentlyViewedPage = new RecentlyViewedPage();

    @Then("verify the product is added to Recently viewed")
    public void verifyTheProductIsAddedToRecentlyViewed() {
        Assert.assertTrue(recentlyViewedPage.isOnRecentlyViewedPage());

    }
    @Then("verify the recently searched product is visible")
    public void verifyTheRecentlySearchedProductIsVisible() {
        Assert.assertEquals(ConfigReader.getValue("product.title"),recentlyViewedPage.recentlyProductListTitle());
        System.out.println(ConfigReader.getValue("product.title")+".............");
        System.out.println(recentlyViewedPage.recentlyProductListTitle()+"///////////////////");

    }

}
