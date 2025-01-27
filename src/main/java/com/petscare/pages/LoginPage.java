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

}
