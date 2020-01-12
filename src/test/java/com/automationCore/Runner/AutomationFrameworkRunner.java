package com.automationCore.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature",glue = "com.automationCore.stepDefination",
monochrome = true )
public class AutomationFrameworkRunner {
}
