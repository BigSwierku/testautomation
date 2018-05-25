package com.jsystems.testautomation.frontedBDD.Steps;

import com.jsystems.testautomation.Configuration;
import com.jsystems.testautomation.frontedBDD.Pages.*;
import com.jsystems.testautomation.frontedBDD.Pages.NotificationsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordpressSteps extends  BaseSteps {

    MainPage mainPage;
    LoginPageEmail loginPageEmail;
    LoginPasswordPage loginPasswordPage;
    MainLogedPage mainLogedPage;
    PersonalPage  personalPage;
    NotificationsPage notificationPage;
    public WordpressSteps(StepsConfig config){
        super(config);
        try{
            driver = config.setUp();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(config.id);
        }

    }



    @Given("^User is on wordpress website \"([^\"]*)\"$")
    public void userIsOnWordpressWebsite(String website){
    driver.get(Configuration.WORDPRESS_BASE_URL);
        mainPage = new MainPage(driver);

    }

    @When("^User click on login button$")
    public void userClickOnLoginButton()  {
        mainPage.logInButton.click();
    }

    @Then("^Email login page is displayed$")
    public void emailLoginPageIsDisplayed()  {
        loginPageEmail = new LoginPageEmail(driver);

    }

    @When("^User enter email and click continue button$")
    public void userEnterEmailAndClickContinueButton() {
        loginPageEmail.waitForVisibilityForElement(loginPageEmail.emailField,10);
        loginPageEmail.emailField.sendKeys(Configuration.WORDPRESS_EMAIL);
        loginPageEmail.continueButton.click();
    }

    @Then("^Password login page is displayed$")
    public void passwordLoginPageIsDisplayed()  {
        loginPasswordPage = new LoginPasswordPage(driver);

        // Write code here that turns the phrase above into concrete actions

    }

    @When("^User enters password and press login button$")
    public void userEntersPasswordAndPressLoginButton()  {
        // Write code here that turns the phrase above into concrete actions
        loginPasswordPage.waitForVisibilityForElement(loginPasswordPage.passwordField,10);
        loginPasswordPage.passwordField.sendKeys(Configuration.WORDPRESS_PASSWORD);
        loginPasswordPage.continuePasswordButton.click();

    }

    @Then("^Main login page is displayed$")
    public void mainLoginPageIsDisplayed() {

        mainLogedPage = new MainLogedPage(driver);
        mainLogedPage.waitForVisibilityForElement(mainLogedPage.avatar,10);
        mainLogedPage.isContentPresent();
    }

    @When("^User press avatar$")
    public void userPressAvatar()  {

        mainLogedPage.avatar.click();
    }

    @Then("^Personal page is displayed$")
    public void personalPageIsDisplayed()   {
        personalPage = new PersonalPage(driver);
        assertTrue(personalPage.titleNotification.isDisplayed());
        personalPage.gotIt.click();
        personalPage.waitForClickabilityForElement(personalPage.notification,10);
        personalPage.notification.click();
    }

    @When("^User clicks notification$")
    public void userClicksNotification()  {
        notificationPage = new NotificationsPage(driver);
        notificationPage.isContentPresent();
        notificationPage.checkbox.isDisplayed();
        notificationPage.checkbox.isSelected();

    }

    @Then("^Notification page is displayed$")
    public void notificationPageIsDisplayed()  {

    }

    @When("^User press checkbox$")
    public void userPressCheckbox() {
        notificationPage.checkbox.click();
    }

    @Then("^Checkbox is unpressed$")
    public void checkboxIsUnpressed()  {
        assertFalse(notificationPage.checkbox.isSelected());
        notificationPage.checkbox.click();
    }
}
