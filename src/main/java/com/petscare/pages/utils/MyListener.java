package com.petscare.pages.utils;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

public class MyListener implements WebDriverListener {
    private static final Logger logger = LoggerFactory.getLogger(MyListener.class);

    private void logSeparator() {
        logger.info("*************************************************");
    }

    private void logElements(WebDriver driver, By locator, List<WebElement> elements) {
        if (elements != null && !elements.isEmpty()) {
            logger.info("Found {} elements for locator: {}", elements.size(), locator);
        } else {
            logger.warn("No elements found for locator: {}", locator);
            logger.info("Current URL: {}", driver.getCurrentUrl());
        }
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        logger.error("The test has a problem");
        logSeparator();
        logger.error("Method --> {}", method.getName());
        logger.error("Target exception --> {}: {}",
                e.getTargetException().getClass(),
                e.getTargetException().getMessage());
        if (target != null) {
            logger.error("Object target --> {}", target.toString());
        } else {
            logger.error("Object target is null.");
        }
        logger.error("Stack trace: ", e);
        logSeparator();

        int i = new Random().nextInt(1000) + 1000;
        String link = "screenshots/screen-" + i + ".png";

        WebDriver driver = (ChromeDriver) target;
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File tmp = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp, new File(link));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        logSeparator();
        logger.info("The locator will find: {}", locator);
        logger.info("Current URL: {}", driver.getCurrentUrl());
        logSeparator();
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement element) {
        logSeparator();
        if (element != null) {
            logger.info("Found element with tag: {}, ID: {}, Class: {}",
                    element.getTagName(),
                    element.getAttribute("id"),
                    element.getAttribute("class"));
        } else {
            logger.warn("No element found for locator: {}", locator);
            logger.info("Current URL: {}", driver.getCurrentUrl());
        }
        logSeparator();
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        logSeparator();
        logger.info("The locators will find elements: {}", locator);
        logger.info("Current URL: {}", driver.getCurrentUrl());
        logSeparator();
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> elements) {
        logSeparator();
        logElements(driver, locator, elements);
        logSeparator();
    }
}
