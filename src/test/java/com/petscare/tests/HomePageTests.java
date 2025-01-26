package com.petscare.tests;

import com.petscare.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest(){
        new HomePage(driver).verifyHomeComponentPresentTest("Welcome to Pet Service");
    }

}
