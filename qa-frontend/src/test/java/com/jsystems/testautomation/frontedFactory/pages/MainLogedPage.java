package com.jsystems.testautomation.frontedFactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainLogedPage extends BasePage {
    WebDriver driver;

    public MainLogedPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement avatar = driver.findElement(By.cssSelector("a[data-tip-target=\"me\"]"));
    public WebElement mySite = driver.findElement(By.cssSelector("a[data-tip-target=\"my-sites\"] span"));

    public boolean isContentPresent(){
        String title=driver.getTitle();
        System.out.println(title);
        assertTrue(title.equals("Log In — WordPress.com"));
        return true;
    }


}
