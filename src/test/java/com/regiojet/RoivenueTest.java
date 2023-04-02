package com.regiojet;


import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;


public class RoivenueTest {
    static WebDriver driver;
    Locators locators = new Locators();
    Browser browser = new Browser(driver);
    MainPage mainPage = new MainPage(driver);
    SearchPage searchPage = new SearchPage(driver);

    public RoivenueTest() throws FileNotFoundException {
    }

    @BeforeClass
    public static void setUpDriver() throws Exception {
        driver = DriverSetUp.setUpDriver("chrome");
    }

    @After
    public void quitDriver() throws Exception {
        browser.quitDriver();
        setUpDriver();
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
    }

    @Test
    public void shortestDirection() throws Exception {
        browser.setUpPage();
        mainPage.login();
        searchPage.setUpGoogleAds();
    }

}
