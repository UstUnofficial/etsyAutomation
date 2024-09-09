package com.automation.steps;

import com.automation.pages.ProductListingPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
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




    @When("user apply laptop filter option {string}")
    public void userApplyLaptopFilterOption(String category) {
        productListingPage.laptopFiltering(category);
    }

//    @When("user apply filter option {string}")
//    public void userApplyFilterOption(String category) {
//        productListingPage.LaptopFiltering(category);
//    }


    @And("user apply subCategory {string} from category")
    public void userApplySubCategoryFromCategory(String subCategory) {
        productListingPage.subFiltering(subCategory);
    }

    @And("user apply subCategory {string} from Shipping category")
    public void userApplySubCategoryFromShippingCategory(String subCategory) {
        productListingPage.subFilteringFromShipping(subCategory);
    }

    @Then("verify the product are displayed contains {string} based on filtering")
    public void verifyTheProductAreDisplayedContainsBasedOnFiltering(String data) {
        Assert.assertTrue(productListingPage.isLaptopFiltered(ConfigReader.getValue(data)));
    }

    @And("user search for result")
    public void userSearchForResult() {
        productListingPage.clickOnSearchBtn();
    }

    @When("user apply filter option {string}")
    public void user_apply_filter_option(String filter) {
        productListingPage.filter(filter);

    }


    @When("user sorts with {string}")
    public void userSortsWith(String sortingOption) {
        productListingPage.sortWith(ConfigReader.getValue(sortingOption));
    }

    @Then("verify price is sorted in {string} order")
    public void verifyPriceIsSortedInOrder(String sortingOption) {
        Assert.assertTrue(productListingPage.isPriceSortedIn(ConfigReader.getValue(sortingOption)));

    }

    @Then("verify price is sorted not in {string} order")
    public void verifyPriceIsSortedNotInOrder(String sortingOption) {

        Assert.assertFalse(productListingPage.isPriceSortedIn(ConfigReader.getValue(sortingOption)));
    }
    @Then("verify the product are displayed contains {string}  and {string} based on filtering")
    public void verifyTheProductAreDisplayedContainsAndBasedOnFiltering(String data1, String data2) {
        Assert.assertTrue(productListingPage.isLaptopFilteredByTwoCondition(ConfigReader.getValue(data1),ConfigReader.getValue(data2)));

    }

    @And("user select color as {string}")
    public void userSelectColorAs(String arg0) {
    }

    @And("user select gender as {string}")
    public void userSelectGenderAs(String arg0) {
    }

    @And("user click on first product")
    public void userClickOnFirstProduct() {
        productListingPage.clickOnFirstProduct();

    }
    @And("user click on second product")
    public void userClickOnSecondProduct() {



        productListingPage.clickOnSecondProduct();

    }

    @When("user shop the product by size {string}")
    public void userShopTheProductBySize(String size) {
        productListingPage.clickOnSize(size);
    }

    @And("user shop the product by sleeve length {string}")
    public void userShopTheProductBySleeveLength(String sleeveSize) {
        productListingPage.selectSleevSize(sleeveSize);
    }
}
