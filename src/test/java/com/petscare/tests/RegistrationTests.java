package com.petscare.tests;

import com.petscare.pages.HomePage;
import com.petscare.pages.LoginPage;
import com.petscare.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).selectSignUp();
    }

    @Test
    public void newUserRegistrationPositiveTest(){
        new RegistrationPage(driver)
                .enterUserData("Alex", "Pereira", "pereira91@gmail.com", "Pereira123!")
                .checkBoxes()
                .clickOnCreateAccountButton();
        new LoginPage(driver).verifySuccessRegistration("Welcome");
    }

    @Test
    public void newUserRegistrationNegativeTest(){
        new RegistrationPage(driver)
                .enterUserData("Alex", "Pereira", "pereira@gmail.com", "Pereira123!")
                .checkBoxes()
                .clickOnCreateAccountButton();
        new RegistrationPage(driver).verifyMessageOfExistedUser("An error occurred during registration. You may have entered an existing email.");
    }

    @Test
    public void registrationWithInvalidPasswordNegativeTest(){
        new RegistrationPage(driver)
                .enterUserData("Alex", "Pereira", "pereira@gmail.com", "qqqqqqqqq")
                .checkBoxes()
                .clickOnCreateAccountButton();
        new RegistrationPage(driver)
                .verifyMessageOfInvalidPassword("Password must be at least 8 characters long, include one uppercase letter, one number, and one special character.");
    }

    @Test
    public void registrationWithInvalidEmailNegativeTest(){
        new RegistrationPage(driver)
                .enterUserData("Alex", "Pereira", "01pereiragmail.com", "Admin123!")
                .checkBoxes()
                .clickOnCreateAccountButton();
        Assert.assertTrue(new RegistrationPage(driver).verifyMessageOfInvalidEmail());
    }



    @Test
    public void registrationWithoutCheckboxesNegativeTest(){
        new RegistrationPage(driver)
                .enterUserData("Alex", "Pereira", "pereira@gmail.com", "Admin123!")
                .clickOnCreateAccountButton();
        Assert.assertTrue(new RegistrationPage(driver).checkBoxValidationTest());
    }

    @Test
    public void registrationWithoutFirstNameNegativeTest(){
        new RegistrationPage(driver)
                .enterUserData("", "Pereira", "pereira@gmail.com", "Admin123!")
                .checkBoxes()
                .clickOnCreateAccountButton();
        Assert.assertTrue(new RegistrationPage(driver).isFirstNameErrorDisplayed());
    }

    @Test
    public void registrationWithoutLastNameNegativeTest(){
        new RegistrationPage(driver)
                .enterUserData("Alex", "", "pereira@gmail.com", "Admin123!")
                .checkBoxes()
                .clickOnCreateAccountButton();
        Assert.assertTrue(new RegistrationPage(driver).isLastNameErrorDisplayed());
    }


}
