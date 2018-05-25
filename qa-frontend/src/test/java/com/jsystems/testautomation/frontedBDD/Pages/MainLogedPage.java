package com.jsystems.testautomation.frontedBDD.Pages;

import org.openqa.selenium.By;
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

    @FindBy(css="a[data-tip-target=\"me\"]")
    public WebElement avatar;
    //public WebElement mySite = driver.findElement(By.cssSelector("a[data-tip-target=\"my-sites\"] span"));

    public boolean isContentPresent(){

       // assertTrue(driver.getTitle().equals("Log In — WordPress.com"));
        return true;
    }


}
