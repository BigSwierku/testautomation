package com.jsystems.testautomation.frontedFactory.tests;

import com.jsystems.testautomation.Configuration;
import com.jsystems.testautomation.frontedFactory.FrontendConfig;
import com.jsystems.testautomation.frontedFactory.pages.LoginPageEmail;
import com.jsystems.testautomation.frontedFactory.pages.LoginPasswordPage;
import com.jsystems.testautomation.frontedFactory.pages.MainLogedPage;
import com.jsystems.testautomation.frontedFactory.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontendTestMainPage extends FrontendConfig {

    MainPage mainPage;

    @Test
    @DisplayName("Test of content on  main page")
    public void contentMainPageTest(){
        driver.get("https://wordpress.com");
        mainPage = new MainPage(driver);
        assertTrue( mainPage.isContentPresent());

    }

    @Test
    @DisplayName("Log In test")
    public void logInTest(){
        driver.get(Configuration.WORDPRESS_BASE_URL);
        mainPage = new MainPage(driver);
        mainPage.logInButton.click();
        LoginPageEmail loginPageEmail = new LoginPageEmail(driver);
        loginPageEmail.waitForVisibilityForElement(loginPageEmail.emailField,10);
        loginPageEmail.emailField.sendKeys(Configuration.WORDPRESS_EMAIL);
        loginPageEmail.continueButton.click();
        LoginPasswordPage loginPasswordPage = new LoginPasswordPage(driver);
        loginPasswordPage.waitForVisibilityForElement(loginPasswordPage.passwordField,10);
        loginPasswordPage.passwordField.sendKeys(Configuration.WORDPRESS_PASSWORD);
        loginPasswordPage.continuePasswordButton.click();
        MainLogedPage mainLogedPage = new MainLogedPage(driver);
        mainLogedPage.isContentPresent();

    }

}
