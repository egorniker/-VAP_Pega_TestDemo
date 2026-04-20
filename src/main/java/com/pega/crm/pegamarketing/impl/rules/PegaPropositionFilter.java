package com.pega.crm.pegamarketing.impl.rules;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.rules.PropositionFilter;
import com.pega.framework.PegaWebElement;

public class PegaPropositionFilter extends PegaRuleInstance implements PropositionFilter {

	public PegaPropositionFilter(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public void setDefaultCriteria(DefaultCriteria criteria) {
		PegaWebElement radio = findElement(By.xpath("//span/label[text()='" + criteria.getCriteria() + "']"));
		testEnv.getScriptExecutor().click(radio);
	}

}
