package com.regiojet;

import org.openqa.selenium.WebDriver;

public class Browser {

    WebDriver driver ;
    Locators locators = new Locators();

    public Browser(WebDriver driver){
        this.driver=driver;
    }

    public void setUpPage() {
        driver.get("https://app.roivenue.com/explore/process/marketingInvestment,mromi?dateRangeFrom=2020-11-01&dateRangeTo=2020-12-15");
//        if (driver.findElement(locators.acceptCookies).isDisplayed()){
//            driver.findElement(locators.acceptCookies).click();
//        }
    }

    public void quitDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
