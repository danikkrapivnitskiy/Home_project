package com.roivenue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.util.List;

public class SearchPage {

    WebDriver driver;
    Locators locators = new Locators();

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUpGoogleAds() throws InterruptedException {
        openHiddenPanel();
        openPlatform(1);
        chooseMetrix("Google Ads");
    }

    public void openHiddenPanel() {
        if (!driver.findElements((locators.panels)).get(1).isEnabled()) {
            driver.findElement((locators.showHiddenPanel)).click();
        }
    }

    public void hideHiddenPanel() {
        if (driver.findElements((locators.panels)).get(1).isEnabled()) {
            driver.findElement((locators.hideHiddenPanel)).click();
        }
    }

    public void openPlatform (int i) {
        driver.findElements((locators.panels)).get(i).click();
    }

    public void chooseMetrix(String metrix) {
        List<WebElement> elements = driver.findElements(locators.mainMetrix);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            WebElement onlyButton = driver.findElement(By.xpath((locators.buttonOnlyMainMeetrix.toString().substring(9)) + "[" + (i + 1) + "]"));

            if (element.getText().equals(metrix)) {
                js.executeScript("arguments[0].scrollIntoView();", element);
                actions.moveToElement(element).build().perform();
                onlyButton.click();
            }
        }
    }

    public void setUpDateFrom(String dateFrom) {
        driver.findElement((locators.setUpDate)).click();
        driver.findElement(locators.setUpDateValuesFrom).clear();
        driver.findElement(locators.setUpDateValuesFrom).sendKeys(dateFrom);
    }

    public void setUpDateTo(String dateTo) {
        driver.findElement(locators.setUpDateValuesTo).clear();
        driver.findElement(locators.setUpDateValuesTo).sendKeys(dateTo);
        driver.findElement(locators.calendarButtonOK).click();
    }

    public void setUpAllFilters(String dateFrom, String dateTo) throws InterruptedException {
        setUpDateFrom(dateFrom);
        setUpDateTo(dateTo);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate from = LocalDate.parse(dateFrom, formatter);
        LocalDate to = LocalDate.parse(dateTo, formatter);

        driver.findElement(locators.setUpTime).click();
        Thread.sleep(1000);
        List<WebElement> elements = driver.findElements(locators.setUpTimeValues);


        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            Thread.sleep(500);
            element.click();
            String variable = element.getText();
            Thread.sleep(3000);
            List<WebElement> matCells = driver.findElements(locators.matCell);
            switch (variable) {
                case "Daily":
                    long beetwenDates = ChronoUnit.DAYS.between(from, to);
                    Assert.assertNotNull(matCells);
                    Assert.assertEquals(matCells.size(), Math.toIntExact(beetwenDates) + 1);
                    break;

                case "Weekly":
                    Assert.assertNotNull(matCells);
                    Assert.assertEquals(matCells.size(), to.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR)
                                - from.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR) + 1);
                break;

                case "Monthly":
                    Assert.assertNotNull(matCells);
                    Assert.assertEquals(matCells.size(), to.getMonthValue() - from.getMonthValue() + 1);
                break;
            }
            if (i != elements.size() - 1) {
                driver.findElement(locators.setUpTime).click();
            }
        }

    }

    public void comparingModels(int first, int second) throws InterruptedException {
        WebElement openAttributionModel = driver.findElement(locators.attributionModel);
        openAttributionModel.click();
        WebElement firstElement = driver.findElement(By.xpath((locators.radioButtonModel).toString().substring(9) + "[" + first + "]"));
        firstElement.click();

        System.out.println(firstElement.getText());
        List<WebElement> marginReturnsFirst = driver.findElements(locators.marginReturn);
        String[] marginFirst = marginReturnsFirst.stream().map(WebElement::toString).toArray(String[]::new);
        Thread.sleep(2000);
        if (!openAttributionModel.isDisplayed()) {
            openAttributionModel.click();
        }

        WebElement secondElement = driver.findElement(By.xpath((locators.radioButtonModel).toString().substring(9) + "[" + second + "]"));
        secondElement.click();

        System.out.println(secondElement.getText());
        List<WebElement> marginReturnsSecond = driver.findElements(locators.marginReturn);
        String[] marginSecond = marginReturnsSecond.stream().map(WebElement::toString).toArray(String[]::new);

        Assert.assertNotNull(marginFirst);
        Assert.assertNotNull(marginSecond);
        Assert.assertNotEquals(marginFirst, marginSecond);

    }

}
