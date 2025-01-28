package com.petscare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'Welcome')]")
    WebElement welcomeText;

    public LoginPage verifySuccessRegistration(String text) {
        Assert.assertTrue(welcomeText.getText().contains(text));
        return this;
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    public LoginPage enterUserData(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement signInButton;

    public Object clickOnSignInButton() {
        click(signInButton);
        if (driver.getCurrentUrl().contains("/login")) {
            return this;
        }
        return new MyPersonalDataPage(driver);
    }
}
