package com.regiojet;

import org.openqa.selenium.By;

public class Locators {

    public final By email = By.xpath("//input[@class='tracking-email-input']");
    public final By password = By.xpath("//input[@class='tracking-password-input']");
    public final By login = By.id("tracking-button-submit");
    public final By panels = By.id("filter-sub-pane");
    public final By hiddenPanel = By.id("//div[@class='hide-collapsed ng-star-inserted']");
    public final By mainMetrix = By.xpath("(//span[@class='mat-tooltip-trigger name'])");
    public final By checkoxChecked = By.xpath("(//span[@class='mat-checkbox-inner-container'])");

}
