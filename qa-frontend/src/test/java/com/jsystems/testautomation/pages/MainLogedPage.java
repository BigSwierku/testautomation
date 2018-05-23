package com.jsystems.testautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainLogedPage extends BasePage {
    WebDriver driver;

    public MainLogedPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isContentPresent(){
        String title=driver.getTitle();
        System.out.println(title);
        assertTrue(title.equals("Log In — WordPress.com"));
        return true;
    }


}
