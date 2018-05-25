package com.jsystems.testautomation.frontedBDD.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage extends  BasePage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="navbar-login-link")
    public WebElement logInButton;

    @FindBy(id="hero-cta")
    WebElement getStartedButton;

    @FindBy(css="a#hero-plans-anchor.button.is-more-link.is-large")
    WebElement seePlansButton;

    @FindBy(css="div.hp-hero__wrapper h1 span.no-widows")
    WebElement textSpan;



    public boolean isContentPresent(){
        assertTrue(logInButton.isDisplayed());
        assertTrue(getStartedButton.isDisplayed());
        assertTrue(seePlansButton.isDisplayed());
        assertTrue(textSpan.isDisplayed());
        assertEquals(textSpan.getText(),"WordPress powers 30% of the internet.");
        return true;
    }



}
