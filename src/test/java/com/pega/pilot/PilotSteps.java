package com.pega.pilot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.inject.Inject;
import com.pega.CRMTestEnvironment;

import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;

@ScenarioScoped
public class PilotSteps {

    private final CRMTestEnvironment testEnv;

    @Inject
    public PilotSteps(CRMTestEnvironment testEnv) {
        this.testEnv = testEnv;
    }

    @Then("the user should be logged in to Pega successfully")
    public void theUserShouldBeLoggedInToPegaSuccessfully() {
        String currentUrl = testEnv.getPegaDriver().getDriver().getCurrentUrl();
        String pageSource = testEnv.getPegaDriver().getDriver().getPageSource();

        assertTrue(
            "Expected a non-empty URL after SSO login, but current URL was: " + currentUrl,
            currentUrl != null && !currentUrl.isEmpty()
        );

        assertFalse(
            "Login page still seems to be displayed after SSO login.",
            pageSource.contains("Login with SSO") || pageSource.contains("Incorrect user name or password")
        );
    }
}