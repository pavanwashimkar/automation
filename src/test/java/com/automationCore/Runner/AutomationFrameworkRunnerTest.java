package com.automationCore.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true ,
        features = "src/test/resources/features",
        glue = {"com.automationCore.stepDefination"},
        plugin = {"pretty", "json:target/cucumber-report.json" }
)
public class AutomationFrameworkRunnerTest {
    @AfterClass
    public static void  reportGenerator() {
        try {
            File reportOutputDirectory = new File("target");
            List<String> jsonFiles = new ArrayList<>();
            jsonFiles.add("./target/cucumber-report.json");
            String buildNumber = "1";
            String projectName = "cucumberProject";
            boolean runWithJenkins = false;
            boolean parallelTesting = false;

            Configuration configuration = new Configuration(reportOutputDirectory, projectName);
            configuration.addClassifications("Platform", "Windows");
            configuration.addClassifications("Browser", "Firefox");
            configuration.addClassifications("Branch", "release/1.0");
            List<String> classificationFiles = new ArrayList<>();
            configuration.addClassificationFiles(classificationFiles);
            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
            Reportable result = reportBuilder.generateReports();
            System.out.println("Report generated");
        } catch (Exception e) {
            System.out.println("test");
        }
    }
}
