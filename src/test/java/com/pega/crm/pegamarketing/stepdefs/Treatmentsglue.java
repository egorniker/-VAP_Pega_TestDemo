package com.pega.crm.pegamarketing.stepdefs;

import org.testng.Assert;

import com.pega.crm.pegamarketing.pages.Treatments;
import com.pega.crm.pegamarketing.rules.EmailTreatment;
import com.pega.crm.pegamarketing.utils.ObjectsBean;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Treatmentsglue {

	@Then("^Treatment landing Page should be displayed$")
	public void treatment_Landing_Page_should_be_displayed() {
		Treatments treatments = ObjectsBean.getTreatments();
		Assert.assertTrue(treatments.verifyElement(Treatments.TREATMENTS_PAGE_HEADER),
				"Treatments landing page is not opened..!!");
	}

	@When("^User creates Email treatment$")
	public void user_creates_treatment() {
		Treatments treatments = ObjectsBean.getTreatments();
		treatments.create();
		EmailTreatment emailTreatment = treatments.createEmailTreatment();
		ObjectsBean.setEmailTreatment(emailTreatment);
	}

}
