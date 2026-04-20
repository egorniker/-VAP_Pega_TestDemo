package com.pega.crm.pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.rules.PegaMarketingStrategy;
import com.pega.crm.pegamarketing.pages.Strategies;
import com.pega.crm.pegamarketing.rules.MarketingStrategy;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class PegaStrategies extends PegaLandingPage implements Strategies {

	public PegaStrategies(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public MarketingStrategy createStrategyViaGuideMeThroughIt() {
		findElement(CREATE_BUTTON).click();
		findElement(GUIDE_ME_THROUGH_IT).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		MarketingStrategy strategy = new PegaMarketingStrategy(frameId, testEnv);
		return strategy;
	}

	public MarketingStrategy createStrategyViaStartWithNewCanvas() {
		findElement(CREATE_BUTTON).click();
		findElement(START_WITH_NEW_CANVAS).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		MarketingStrategy strategy = new PegaMarketingStrategy(frameId, testEnv);
		return strategy;
	}
}