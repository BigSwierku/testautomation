package com.jsystems.testautomation.frontedBDD;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "classpath:com.jsystems.testautomation",
        plugin = {"html:target/cucumber-html-report","rerun:target/rerun.txt"},
        tags = {
                "@wordpress",
//                "@login" mvn clean install -Dcucumber.option ="tags @wordpress"

        }


)
public class RunTest {



}
