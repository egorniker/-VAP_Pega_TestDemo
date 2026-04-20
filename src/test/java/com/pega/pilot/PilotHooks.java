package com.pega.pilot;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;

import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.Before;

@ScenarioScoped
public class PilotHooks {

    private final CRMBrowser browser;

    @Inject
    public PilotHooks(CRMTestEnvironment testEnv) {
        this.browser = (CRMBrowser) testEnv.getBrowser();
    }

    @Before("@pilot")
    public void loginToPegaViaSSO() throws Throwable {
        browser.open();
        browser.user_logs_in_to_pega_platform_via_sso();
    }
}