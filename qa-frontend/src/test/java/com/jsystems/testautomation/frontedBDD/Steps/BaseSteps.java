package com.jsystems.testautomation.frontedBDD.Steps;

import org.openqa.selenium.WebDriver;

public class BaseSteps {

    WebDriver driver;

    public BaseSteps(StepsConfig config){
    this.driver = config.setUp();
    }
}
