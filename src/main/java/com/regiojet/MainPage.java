package com.regiojet;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MainPage {

    WebDriver driver;
    Locators locators = new Locators();
    Properties prop = new Properties();
    FileInputStream input = new FileInputStream("src/main/resources/settings.properties");


    public MainPage(WebDriver driver) throws FileNotFoundException {
        this.driver=driver;
    }

    public void login() throws InterruptedException, IOException {
        prop.load(input);
        driver.findElement(locators.email).sendKeys(prop.getProperty("email"));
        driver.findElement(locators.password).sendKeys(prop.getProperty("password"));
        driver.findElement(locators.login).submit();
        Thread.sleep(5000);
    }
}

