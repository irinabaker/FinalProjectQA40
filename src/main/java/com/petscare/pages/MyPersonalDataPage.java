package com.petscare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyPersonalDataPage extends BasePage{

    public MyPersonalDataPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[contains(text(),'My Personal Data')]")
    WebElement personalDataText;

    public MyPersonalDataPage verifyMyPersonalDataPage(String text) {
        Assert.assertTrue(personalDataText.getText().contains(text));
        return this;
    }
}
