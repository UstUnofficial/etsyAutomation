package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "com.ebay.mobile:id/button_classic")
    WebElement useUserNameOrEmail;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.ebay.mobile:id/edit_text_username\"]")
    WebElement userNameEmailInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.ebay.mobile:id/password_input_text\"]")
    WebElement passwordInput;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.ebay.mobile:id/button_sign_in\"]")
    WebElement singInButton;

    public boolean isSingInPageDisplayed() {
        return isDisplayed(useUserNameOrEmail);
    }

    public void clickOnUserNameOrEmail() {
        useUserNameOrEmail.click();

    }

    public boolean isInputDisplayed() {
        return isDisplayed(userNameEmailInput) && isDisplayed(passwordInput);
    }

    public void doLogin(String userName, String password) {
        userNameEmailInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        singInButton.click();
    }
}
