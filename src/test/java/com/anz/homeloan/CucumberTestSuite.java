package com.anz.homeloan;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber/report/report.json",
                "junit:target/cucumber/report/report.xml"}, publish = true,
        features = "src/test/resources/features"
)
public class CucumberTestSuite {

}