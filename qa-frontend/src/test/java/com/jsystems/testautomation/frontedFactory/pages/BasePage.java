package com.jsystems.testautomation.frontedFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver=driver;
    }

    public void waitForVisibilityForElement(WebElement element, int maxWaitTime){
        WebDriverWait webDriverWait = new WebDriverWait(driver,maxWaitTime);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
