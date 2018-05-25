package com.jsystems.testautomation.frontedBDD.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationsPage extends BasePage {
    public NotificationsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"primary\"]/main/div[3]/div/div[1]/div[2]/div[3]/ul/li[2]/input"));

    public boolean isContentPresent(){
        assertTrue(checkbox.isDisplayed());
        assertTrue(checkbox.isSelected());
        return true;
    }
}

