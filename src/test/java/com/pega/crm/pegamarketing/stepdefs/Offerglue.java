package com.pega.crm.pegamarketing.stepdefs;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.pega.crm.pegamarketing.elmt.OfferShape;
import com.pega.crm.pegamarketing.impl.rules.PegaOffer;
import com.pega.crm.pegamarketing.rules.Offer;
import com.pega.crm.pegamarketing.rules.Offer.SendEmailShapeProperties;
import com.pega.crm.pegamarketing.rules.Offer.Shape;
import com.pega.crm.pegamarketing.rules.RuleInstance;
import com.pega.crm.pegamarketing.utils.ObjectsBean;
import com.pega.crm.pegamarketing.utils.TestDataReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Offerglue {

	private Offer offer;
	private OfferShape sendEmailShape;
	private SendEmailShapeProperties sendEmailShapeProps;

	@When("^User enters \"([^\"]*)\" as Offer Name$")
	public void user_enters_as_Treatment_Name(String treatmentName) {
		offer = ObjectsBean.getOffer();
		offer.setRuleName(ObjectsBean.putTimeStampedValue(treatmentName));
	}

	@When("^selects \"([^\"]*)\" as Offer Issue and \"([^\"]*)\" as Offer Group$")
	public void selects_as_Offer_Issue_and_as__Offer_Group(String issue, String group) {
		issue = TestDataReader.getTestDataValue(issue);
		offer.setIssue(issue);
		group = TestDataReader.getTestDataValue(group);
		offer.setGroup(group);
	}

	@When("^Selects \"([^\"]*)\" as Offer Development branch$")
	public void selects_as_Offer_Development_branch(String branch) {
		offer.selectDevBranch(branch);
	}

	@When("^Clicks on Create and Open button in Offer Page$")
	public void clicks_on_Create_and_Open_button_in_Offer_Page() {
		offer.createAndOpen();
	}

	@Then("^Offer Rule should be opened$")
	public void Offer_Rule_should_be_opened() {
		Assert.assertTrue(offer.verifyElement(RuleInstance.SAVE_BUTTON), "Offer Rule page did not open..!!");
	}

	@When("^switches to Flow tab$")
	public void switches_to_Flow_tab() {
		ObjectsBean.getOffer().switchTab("Flow");
	}

	@When("^user deletes the existing start connector$")
	public void user_deletes_the_existing_start_connector() {
		ObjectsBean.getOffer().findConnector(PegaOffer.START_CONNECTOR).delete();
		ObjectsBean.getOffer().findEndShape().delete();
		ObjectsBean.getOffer().dragShape(Shape.END, 450, 100);
			}

	@When("^adds a new send email shape to the offer$")
	public void adds_a_new_send_email_shape_to_the_offer() {
		offer.dragShape(Shape.SEND_EMAIL);
	}

	@When("^adds a new send email shape to the offer at point \"([^\"]*)\",\"([^\"]*)\" in the offer$")
	public void adds_a_new_send_email_shape_to_the_offer_at_point_in_the_offer(String xEnd, String yEnd)
			throws Throwable {
		ObjectsBean.getOffer().dragShape(Shape.SEND_EMAIL, Integer.parseInt(xEnd), Integer.parseInt(yEnd));
	}

	@When("^opens the properties of send email shape with name \"([^\"]*)\"$")
	public void opens_the_properties_of_send_email_shape_with_name(String shapeName) {
		sendEmailShape =  ObjectsBean.getOffer().findShape(shapeName);
		sendEmailShapeProps = (SendEmailShapeProperties) sendEmailShape.openProperties(Shape.SEND_EMAIL);
	}

	@When("^renames the send email shape as \"([^\"]*)\"$")
	public void renames_the_send_email_shape_as(String shapeName) {
		sendEmailShapeProps.setShapeName(shapeName);
	}

	@When("^sets the treatment as \"([^\"]*)\"$")
	public void sets_the_treatment_as(String treatmentName) throws Throwable {
//		sendEmailShapeProps.specifyTreatment();
		sendEmailShapeProps.setTreatmentName(treatmentName);
	}

	/*
	 * @When("^sets the email account as \"([^\"]*)\"$") public void
	 * sets_the_email_account_as(String emailAccount) throws Throwable {
	 * sendEmailShapeProps.setEmailAccount(emailAccount); }
	 */

	@When("^sets the email account as \"([^\"]*)\"$")
	public void sets_the_email_account_as(String emailAccount) throws Throwable {
		String emailaccount = emailAccount.equals("") ? TestDataReader.getTestDataValue("EmailAccount") : emailAccount;
		sendEmailShapeProps.setEmailAccount(emailaccount);
	}

	@When("^submits the properties$")
	public void submits_the_properties() throws Throwable {
		sendEmailShapeProps.submit();
	}

	@When("^connects the start shape to the send email shape$")
	public void connects_the_start_shape_to_the_send_email_shape() {
		OfferShape startShape = ObjectsBean.getOffer().findShape("Start");
		OfferShape sendEmailShape = ObjectsBean.getOffer().findShape("Send Email");
		startShape.makeConnection(startShape, sendEmailShape, "Start-Email");
	}

	@When("^connects the send email shape to the end shape$")
	public void connects_the_send_email_shape_to_the_end_shape() {
		OfferShape endShape = ObjectsBean.getOffer().findShape("End");
		OfferShape sendEmailShape = ObjectsBean.getOffer().findShape("Send Email");
		sendEmailShape.makeConnection(sendEmailShape, endShape);
	}

	@When("^Saves the Offer$")
	public void saves_the_Offer() {
		ObjectsBean.getOffer().save();
		// Thread.sleep(10000);
	}

}
