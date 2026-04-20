package com.pega.crm.pegamarketing.rules;

import org.openqa.selenium.By;

public interface PropositionFilter extends RuleInstance {
	By DEAFULT_CRITERIA_TRUE_RADIO = By.id("pyDefaultBehaviortrue");

	public enum DefaultCriteria {
		TRUE("True"), FALSE("False"), USING_CUSTOM_CRITERIA("Using custom criteria");
		String criteriaType;

		DefaultCriteria(String criteriaType) {
			this.criteriaType = criteriaType;
		}

		public String getCriteria() {
			return criteriaType;
		}
	}

	void setDefaultCriteria(DefaultCriteria criteria);
}
