package com.petscare.tests;

import com.petscare.pages.HomePage;
import com.petscare.pages.LoginPage;
import com.petscare.pages.MyServicesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyServicesTests extends TestBase{

    @BeforeMethod()
    public void precondition(){

        new HomePage(driver).selectLogIn();
    }

    @Test
    @Parameters({"email", "password", "title", "price", "description"})
    public void addNewService(@Optional("pereira12345@gmail.com") String email,
                              @Optional("Pereira123!") String password,
                              @Optional("Dog sitter") String title,
                              @Optional("25") String price,
                              @Optional("I'm a good dog sitter") String description){
        new LoginPage(driver)
                .enterUserData(email, password)
                .clickOnSignInButton();
        new MyServicesPage(driver)
                .clickOnMyServices()
                .clickOnAddNewService()
                .enterServiceData(title, price, description)
                .clickOnAddServiceButton()
                .verifyServiceAdded("Dog sitter");
    }
}
