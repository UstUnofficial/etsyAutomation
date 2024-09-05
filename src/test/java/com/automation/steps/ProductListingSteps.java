package com.automation.steps;

import com.automation.pages.ProductListingPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Collection;

public class ProductListingSteps {

    ProductListingPage productListingPage = new ProductListingPage();

    @Then("verify user is on {string} product page")
    public void verifyUserIsOnProductPage(String productName) {
        productListingPage.clickOnNotification();
        Assert.assertTrue(productListingPage.isOnProductPage(ConfigReader.getValue(productName)));

    }

    @When("select a brand {string} from watches")
    public void selectABrandFromWatches(String brandName) {
        productListingPage.selectBrandFromWatches(ConfigReader.getValue(brandName));
    }

    @Then("verify each product is from {string}")
    public void verifyEachProductIsFrom(String brandName) {
        Assert.assertTrue(productListingPage.containsBrandNameInEachProduct());
    }


    @When("user apply filter options")
    public void userApplyFilterOptions() {
        productListingPage.LaptopFiltering();
    }

    @Then("verify the product are displayed based on filtering")
    public void verifyTheProductAreDisplayedBasedOnFiltering() {
        Assert.assertTrue(productListingPage.isLaptopFiltered());

    }


}
