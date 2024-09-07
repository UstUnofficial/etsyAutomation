package com.automation.steps;

import com.automation.pages.CategoryListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CategoryListSteps {

    CategoryListPage categoryListPage = new CategoryListPage();

    @When("click on {string} from category")
    public void click_on_from_category(String category) {
        categoryListPage.clickOnTheProductCategory(category);
    }

    @When("click on {string} from sub category")
    public void click_on_from_sub_category(String subCategory) {
        categoryListPage.clickOnTheProductSubCategory(subCategory);
    }

    @And("click on {string} from inner sub category")
    public void clickOnFromInnerSubCategory(String innerSubCategory) {
        categoryListPage.clickOnTheProductInnerSubCategory(innerSubCategory);
    }
}
