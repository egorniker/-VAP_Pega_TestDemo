package com.pega.crm.customerservice.stepdefs;

import com.google.inject.Inject;
import com.pega.Browser;
import com.pega.CRMBrowser;
import com.pega.crm.customerservice.CSPortal;
import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.crm.customerservice.interactions.NewDemoInteraction;
import com.pega.crm.customerservice.interactions.NewInboundInteraction;
import com.pega.crm.customerservice.interactions.OutboundPhoneCall;
import com.pega.crm.customerservice.interactions.PhoneCall;
import com.pega.crm.customerservice.interactions.ResearchInteraction;
import com.pega.crm.customerservice.tiles.TopNav;

import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class NewTopNav {

	private CSPortal csPortal;
	private Browser browser;
	private NewDemoInteraction demoInteraction;
	private PhoneCall phoneCall;
	private ResearchInteraction researchInteraction;
	private NewInboundInteraction inboundInteraction;
	private OutboundPhoneCall outboundPhoneCall;
	private TopNav topNav;
	public String[] caseStatus = new String[10];
	private Interactions interactions;

	@Inject
	public NewTopNav(CRMBrowser browser) {
		this.browser = browser;
		csPortal = browser.getPortal(CSPortal.class);
		topNav = browser.getPortal(CSPortal.class).getTopNav();
	}

	@When("^CSR launched the New Phone Interaction$")
	public void csr_launched_the_New_Phone_Interaction() throws Throwable {

		phoneCall = topNav.getInteractionType("Phone call");// c
															// changed
															// to
															// C
		interactions = phoneCall;
	}

	@When("^CSR launches Demo Interaction for \"([^\"]*)\" and accepts the call$")
	public void csr_launches_Demo_Interaction_for_and_accepts_the_call(String demoInteraction) throws Throwable {

		this.demoInteraction = topNav.getDemoInteractionType(demoInteraction);
		interactions = this.demoInteraction;
	}

	@When("^User places an outbound phone call$")
	public void user_places_an_outbound_phone_call() {

		outboundPhoneCall = topNav.getInteractionType("Outbound Phone Call");
		System.out.println(outboundPhoneCall);
		interactions = outboundPhoneCall;
	}

	@When("^Select \"([^\"]*)\" and serach for \"([^\"]*)\"$")
	public void select_and_serach_for(String searchType, String value) {

		researchInteraction = topNav.selectandSearchResearchType(searchType, value);
		interactions = researchInteraction;

	}

	public NewDemoInteraction getDemoInteraction() {
		return demoInteraction;
	}

	public PhoneCall getPhoneCall() {
		return phoneCall;
	}

	public ResearchInteraction getResearchInteraction() {

		return researchInteraction;
	}

	public NewInboundInteraction getInboundInteraction() {
		return inboundInteraction;
	}

	public Interactions getInteractions() {
		return interactions;
	}

	public OutboundPhoneCall getOutboundPhoneCall() {
		return outboundPhoneCall;
	}

	@When("^switch to Interaction of \"([^\"]*)\"$")
	public void switch_to_Interaction_of(String interactionItem) {

		researchInteraction = topNav.switchInteraction(interactionItem);
		interactions = researchInteraction;
	}
}
