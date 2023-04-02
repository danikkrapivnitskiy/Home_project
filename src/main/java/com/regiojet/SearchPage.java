package com.regiojet;

import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchPage {

    WebDriver driver;
    Locators locators = new Locators();

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUpGoogleAds() {
        openHiddenPanel();
        openPlatform(2);
        chooseMetrix("Google Ads");
    }

    public void openHiddenPanel() {
        driver.findElement((locators.hiddenPanel)).click();
    }

    public void openPlatform (int i) {
        driver.findElements((locators.panels)).get(i).click();
    }

    public void chooseMetrix(String metrix) {
        List<WebElement> elements = driver.findElements(locators.mainMetrix);

        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            WebElement checkboxChecked = driver.findElement(By.xpath(locators.checkoxChecked.toString().substring(9) + "[" + (i + 1) + "]"));
            if (!element.getText().equals(metrix) & checkboxChecked.isSelected()) {
                checkboxChecked.click();
            }
        }
    }
}
