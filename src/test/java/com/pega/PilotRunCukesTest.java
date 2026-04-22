package com.pega;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "classpath:com/pega/pilot/open_pilot_application.feature",
    glue = { "com.pega" },
    dryRun = false,
    plugin = {
        "pretty",
        "html:target/cucumber-pilot-htmlreport.html",
        "json:target/cucumber-pilot-report.json",
        "com.pega.config.test.CustomFormatter"
    },
    monochrome = true
)
public class PilotRunCukesTest extends AbstractTestNGCucumberTests {
}