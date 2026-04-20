package com.pega.config;

import com.google.inject.AbstractModule;
import com.pega.Browser;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;

public class TestEnvInjector extends AbstractModule {
	
	String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	String VERSION = "$Id: TestEnvInjector.java 174698 2018-02-08 08:24:26Z SachinVellanki $";
	 
    @Override
    protected void configure() {
    	
        //bind the service to implementation class
        bind(TestEnvironment.class).to(CRMTestEnvironment.class);
        bind(Browser.class).to(CRMBrowser.class);
    }
}
