package com.jsystems.testautomation.frontedBDD.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonalPage extends BasePage {

        public PersonalPage(WebDriver driver) {
            super(driver);
        }
        public WebElement titleNotification = driver.findElement(By.className("profile-gravatar__user-display-name"));

        public WebElement notification = driver.findElement(By.cssSelector("a[href=\"/me/notifications\"]"));
       public WebElement gotIt = driver.findElement(By.xpath("//*[@id=\"wpcom\"]/div/div[4]/div[2]/button"));
        public boolean isContentPresent(){
            assertTrue(titleNotification.isDisplayed());
            assertTrue(notification.isDisplayed());
            //assertTrue(notification.getText().equals(TestDataStatic.notification));
            return true;
        }
    }

