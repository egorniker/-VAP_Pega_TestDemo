package com.pega;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "classpath:com/pega/pilot/features/dx_sap_pilot.feature",
    glue = { "com.pega.pilot.steps" },
    dryRun = false,
    plugin = {
        "pretty",
        "html:target/cucumber-dx-sap-smoke-htmlreport.html",
        "json:target/cucumber-dx-sap-smoke-report.json"
    },
    monochrome = true
)
public class PilotDxSapRunCukesTest extends AbstractTestNGCucumberTests {
}
