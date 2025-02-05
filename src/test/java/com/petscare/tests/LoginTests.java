package com.petscare.tests;

import com.petscare.pages.HomePage;
import com.petscare.pages.LoginPage;
import com.petscare.pages.MyPersonalDataPage;
import com.petscare.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).selectLogIn();
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "loginUserWithCsv")
    public void userLoginPositiveTest(String email, String password){
        new LoginPage(driver)
                .enterUserData(email, password)
                .clickOnSignInButton();
        new MyPersonalDataPage(driver)
                .verifyMyPersonalDataPage("My Personal Data");
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "loginUserWithCsv")
    public void userLoginNegativeTest(String email, String password){
        new LoginPage(driver)
                .enterUserData(email, password)
                .clickOnSignInButton();
        new LoginPage(driver)
                .verifyErroMessage("Произошла ошибка. Попробуйте позже.");
    }
}
