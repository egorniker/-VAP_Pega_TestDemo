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

    @Then("der Benutzer ist erfolgreich in Pega angemeldet")
    public void derBenutzerIstErfolgreichInPegaAngemeldet() {

        String currentUrl =
                testEnv.getPegaDriver().getDriver().getCurrentUrl();

        String pageSource =
                testEnv.getPegaDriver().getDriver().getPageSource();

        assertTrue(
            "Nach dem SSO-Login wurde keine gültige URL geladen: " + currentUrl,
            currentUrl != null && !currentUrl.isEmpty()
        );

        assertFalse(
            "Die Login-Seite wird weiterhin angezeigt.",
            pageSource.contains("Login with SSO")
            || pageSource.contains("Incorrect user name or password")
        );
    }
}