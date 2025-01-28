package com.petscare.tests;

import com.petscare.pages.HomePage;
import com.petscare.pages.LoginPage;
import com.petscare.pages.RegistrationPage;
import com.petscare.pages.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).selectSignUp();
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "addNewUserWithCsv")
    public void newUserRegistrationPositiveTest(String firstName, String lastName, String email, String password){
        new RegistrationPage(driver)
                .enterUserData(firstName, lastName, email, password)
                .checkBoxes()
                .clickOnCreateAccountButton();
        new LoginPage(driver).verifySuccessRegistration("Welcome");
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "registrationOfExistedUser")
    public void newUserRegistrationNegativeTest(String firstName, String lastName, String email, String password){
        new RegistrationPage(driver)
                .enterUserData(firstName, lastName, email, password)
                .checkBoxes()
                .clickOnCreateAccountButton();
        new RegistrationPage(driver).verifyMessageOfExistedUser("An error occurred during registration. You may have entered an existing email.");
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "registrationWithInvalidPassword")
    public void registrationWithInvalidPasswordNegativeTest(String firstName, String lastName, String email, String password){
        new RegistrationPage(driver)
                .enterUserData(firstName, lastName, email, password)
                .checkBoxes()
                .clickOnCreateAccountButton();
        new RegistrationPage(driver)
                .verifyMessageOfInvalidPassword("Password must be at least 8 characters long, include one uppercase letter, one number, and one special character.");
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "registrationWithInvalidEmail")
    public void registrationWithInvalidEmailNegativeTest(String firstName, String lastName, String email, String password){
        new RegistrationPage(driver)
                .enterUserData(firstName, lastName, email, password)
                .checkBoxes()
                .clickOnCreateAccountButton();
        Assert.assertTrue(new RegistrationPage(driver).verifyMessageOfInvalidEmail());
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "registrationWithoutCheckboxes")
    public void registrationWithoutCheckboxesNegativeTest(String firstName, String lastName, String email, String password){
        new RegistrationPage(driver)
                .enterUserData(firstName, lastName, email, password)
                .clickOnCreateAccountButton();
        Assert.assertTrue(new RegistrationPage(driver).checkBoxValidationTest());
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "registrationWithoutFirstName")
    public void registrationWithoutFirstNameNegativeTest(String firstName, String lastName, String email, String password){
        new RegistrationPage(driver)
                .enterUserData(firstName, lastName, email, password)
                .checkBoxes()
                .clickOnCreateAccountButton();
        Assert.assertTrue(new RegistrationPage(driver).isFirstNameErrorDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "registrationWithoutLastName")
    public void registrationWithoutLastNameNegativeTest(String firstName, String lastName, String email, String password){
        new RegistrationPage(driver)
                .enterUserData(firstName, lastName, email, password)
                .checkBoxes()
                .clickOnCreateAccountButton();
        Assert.assertTrue(new RegistrationPage(driver).isLastNameErrorDisplayed());
    }


}
