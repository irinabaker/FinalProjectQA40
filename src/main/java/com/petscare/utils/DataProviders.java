package com.petscare.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "loginUserWithCsv")
    public Iterator<Object[]> loginUserWithCsv() throws IOException {
//        CSVUpdater.updateCSVFileAndGetEmail(); // Обновляем CSV перед получением данных

        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/user.csv")));

        String line = reader.readLine();

        while (line != null){

            list.add(line.split(","));

            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewUserWithCsv() throws IOException {
        CSVUpdater.updateCSVFileAndGetEmail();
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/userRegistration.csv")));

        String line = reader.readLine();

        while (line != null){

            list.add(line.split(","));

            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> UserRegistrationNegative() throws IOException {
        CSVUpdater.updateCSVFileAndGetEmail();
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/userRegistration.csv")));

        String line = reader.readLine();

        while (line != null){

            list.add(line.split(","));

            line = reader.readLine();
        }

        return list.iterator();
    }

//    @DataProvider
//    public Iterator<Object[]> registrationOfExistedUser(){
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"Alex", "Pereira", "pereira@gmail.com", "Pereira123!"});
//        return list.iterator();
//    }
//
//    @DataProvider
//    public Iterator<Object[]> registrationWithInvalidPassword(){
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"Alex", "Pereira", "pereira@gmail.com", "11111111111"});
//        return list.iterator();
//    }
//
//    @DataProvider
//    public Iterator<Object[]> registrationWithInvalidEmail(){
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"Alex", "Pereira", "pereiragmail.com", "Admin123!"});
//        return list.iterator();
//    }
//
//    @DataProvider
//    public Iterator<Object[]> registrationWithoutCheckboxes(){
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"Alex", "Pereira", "pereira@gmail.com", "Admin123!"});
//        return list.iterator();
//    }
//
//    @DataProvider
//    public Iterator<Object[]> registrationWithoutFirstName(){
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"", "Pereira", "pereira@gmail.com", "Admin123!"});
//        return list.iterator();
//    }
//
//    @DataProvider
//    public Iterator<Object[]> registrationWithoutLastName(){
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"Alex", "", "pereira@gmail.com", "Admin123!"});
//        return list.iterator();
//    }
}
