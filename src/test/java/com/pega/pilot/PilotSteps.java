package com.pega.pilot;

import static org.junit.Assert.assertTrue;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;

import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

@ScenarioScoped
public class PilotSteps {

    private final CRMTestEnvironment testEnv;
    private final CRMBrowser browser;

    @Inject
    public PilotSteps(CRMTestEnvironment testEnv) {
        this.testEnv = testEnv;
        this.browser = (CRMBrowser) testEnv.getBrowser();
    }

    @Given("the user opens the Pega application")
    public void theUserOpensThePegaApplication() {
        browser.open();
    }

    @Then("the Pega application login page should be displayed")
    public void thePegaApplicationLoginPageShouldBeDisplayed() {
        String currentUrl = testEnv.getPegaDriver().getDriver().getCurrentUrl();
        String pageSource = testEnv.getPegaDriver().getDriver().getPageSource();

        assertTrue(
            "Expected a non-empty URL, but current URL was: " + currentUrl,
            currentUrl != null && !currentUrl.isEmpty()
        );

        assertTrue(
            "Expected Pega login page content was not found.",
            pageSource.contains("Pega") || pageSource.contains("Log in") || pageSource.contains("Sign in")
        );
    }
}