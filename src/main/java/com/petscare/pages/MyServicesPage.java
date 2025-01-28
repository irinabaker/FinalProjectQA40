package com.petscare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MyServicesPage extends BasePage{

    public MyServicesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'My Services')]")
    WebElement myServiceButton;
    public MyServicesPage clickOnMyServices() {
        click(myServiceButton);
        return this;
    }

    @FindBy(xpath = "//span[contains(text(),'Add a New Service')]")
    WebElement addNewService;

    public MyServicesPage clickOnAddNewService() {
        click(addNewService);
        return this;
    }

    @FindBy(xpath = "(//div[@id='root']//details/div/input)[1]")
    WebElement titleField;

    @FindBy(xpath = "(//div[@id='root']//details/div/input)[2]")
    WebElement priceField;

    @FindBy(xpath = "//div[@id='root']//details[1]//textarea[1]")
    WebElement descriptionField;

    @FindBy(xpath = "//div[@id='root']//details[1]/div[4]//select")
    WebElement categoryField;

    @FindBy(xpath = "//option[contains(text(),'Dog')]")
    WebElement dogChoice;

    public MyServicesPage enterServiceData(String sitterName, String price, String desc) {
        type(titleField, sitterName);
        type(priceField, price);
        type(descriptionField, desc);
        click(categoryField);

        Select categorySelect = new Select(categoryField);
        categorySelect.selectByVisibleText("Dog");

        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Add Service')]")
    WebElement addServiceButton;
    public MyServicesPage clickOnAddServiceButton() {
        click(addServiceButton);
        return this;
    }

    @FindBy(xpath = "//h3[contains(text(),'Dog sitter')]")
    WebElement confirmText;

    public MyServicesPage verifyServiceAdded(String text) {
        Assert.assertTrue(confirmText.getText().contains(text));
        return this;
    }
}
