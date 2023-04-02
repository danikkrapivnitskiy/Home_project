package com.roivenue;

import org.openqa.selenium.By;

public class Locators {

    public final By email = By.xpath("//input[@class='tracking-email-input']");
    public final By password = By.xpath("//input[@class='tracking-password-input']");
    public final By login = By.id("tracking-button-submit");
    public final By panels = By.xpath("//mat-expansion-panel[@id='filter-sub-panel']");
    public final By showHiddenPanel = By.xpath("//div[@class='hide-collapsed ng-star-inserted']");
    public final By hideHiddenPanel = By.xpath("//div[@class='hide ng-star-inserted']");
    public final By mainMetrix = By.xpath("(//span[@class='mat-tooltip-trigger name'])");
    public final By checkoxChecked = By.xpath("(//span[@class='mat-checkbox-inner-container'])");
    public final By buttonOnlyMainMeetrix = By.xpath("(//cdk-virtual-scroll-viewport//button[@class='mat-focus-indicator " +
            "only-button mat-stroked-button mat-button-base'])");
    public final By setUpTime = By.xpath("//roi-granularity-picker[@class='ng-star-inserted']");
    public final By setUpTimeValues = By.xpath("//button[@role='menuitem']");
    public final By setUpDate = By.xpath("//button[@class='mat-focus-indicator mat-tooltip-trigger " +
            "not-a-real-button mat-button mat-button-base']");
    public final By setUpDateValuesFrom = By.xpath("//input[@id='tracking-date-range-picker-from-input']");
    public final By setUpDateValuesTo = By.xpath("//input[@id='tracking-date-range-picker-to-input']");
    public final By calendarButtonOK = By.xpath("//button[@id='tracking-date-range-picker-confirm-button']");
    public final By matCell = By.xpath("//td[@class='mat-cell cdk-cell cdk-column-date mat-column-date ng-star-inserted']");
    public final By attributionModel = By.xpath("//button[@id='attributionButton']");
    public final By radioButtonModel = By.xpath("(//label[@class='mat-radio-label'])");
    public final By marginReturn = By.xpath("//td[@class='mat-cell cdk-cell cdk-column-mromi mat-column-mromi ng-star-inserted']//div[@class='current']");

}
