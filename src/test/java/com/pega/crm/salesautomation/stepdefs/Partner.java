package com.pega.crm.salesautomation.stepdefs;

import java.util.Random;

import com.pega.sync.WaitForDocStateReady;
import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.SFAPortal;
import com.pega.crm.salesautomation.workobjects.Partners;
import com.pega.crm.salesautomation.workobjects.PartnersList;
import com.pega.framework.PegaWebDriver;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Partner {

    private SFAPortal sfaPortal = null;
    private TestEnvironment testEnv;
    private CRMBrowser browser;
    private PegaWebDriver pegaDriver;
    public static String Subject = null;

    @Inject
    public Partner(CRMTestEnvironment testEnv, CRMBrowser browser) {
        this.testEnv = testEnv;
        this.browser = browser;
        pegaDriver = testEnv.getPegaDriver();
        sfaPortal = browser.getPortal(SFAPortal.class);

        this.partList = browser.parList;
    }

    /*
     *
     * Partners creation
     *
     */

    private Scenario scenario;
    PartnersList partList;
    PartnersList partnerslist;
    Partners part;

    String PARTNER_NAME = "Automation Partner" + Math.random();
    String PARTNER_NAME_CLOSE = "First Alert";
    String PARTNER_PHONE = "8995994999";
    String PARTNER_WEBSITE = "www.partner1.com";
    String TERRITORY_NAME = new String("Automation_Partner_Territory" + new Random().nextInt(10000));

    String TERRITORY_OWNER = "Terry Mason";
    String PARENT_TERRITORY = "Global";
    String PARTNER_TYPE = "Agency";
    String PARTNER_EMAIL = "partner.pega@gmail.com";
    String PARTNER_UPDATED_EMAIL = "updatedpartner.pega@gmail.com";
    String PARTNER_UPDATED_PHONE = "9874561230";

    String PartnerID = "Partner120";
    String PartnerTaxID = "PartnerTax120";
    String PartnerFax = "67890";

    @When("^User clicks on Create Partner and enters all the madatory data$")
    public void user_clicks_on_Create_Partner_and_enters_all_the_madatory_data() {
        partList = sfaPortal.getLeftNav().getPartnersList();
        part = partList.createPartner();
        part.setEmail(PARTNER_EMAIL);
        part.setWebSite(PARTNER_WEBSITE);
        part.setPhone(PARTNER_PHONE);
        part.setPartnerName(PARTNER_NAME);
        pegaDriver.waitForDocStateReady(3);
        pegaDriver.waitForDocStateReady(3);
        part.setSFAAccess();
        part.clickcreateTerritory();
        part.setTerritoryName(TERRITORY_NAME);
        part.setOwner(TERRITORY_OWNER);
        part.setParentTerritory(PARENT_TERRITORY);
        part.clickSubmitTerritoryScreen();
        part.setPartnerType(PARTNER_TYPE);
        part.setPartnerID(PartnerID);
        part.setPartnerTaxID(PartnerTaxID);
        part.setPartnerWorkFax(PartnerFax);
    }

    @When("^clicks on OK button$")
    public void clicks_on_OK_button() {
        part.SubmitPartner();
        try{
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("^Partner should be created$")
    public void partner_should_be_created() {
        Assert.assertEquals(part.getWebSite().trim(), PARTNER_WEBSITE);
        Assert.assertEquals(part.getPartnerID().trim(), PartnerID);
        Assert.assertEquals(part.getPhone().trim(), PARTNER_PHONE);
        Assert.assertEquals(part.getPartnerName().trim(), PARTNER_NAME);
        Assert.assertEquals(part.getPartnerWorkFax().trim(), PartnerFax);
        Assert.assertEquals(part.getEmail().trim(), PARTNER_EMAIL);
        Assert.assertEquals(part.getPartnerTaxID().trim(), PartnerTaxID);
        Assert.assertEquals(part.getPartnerType().trim(), PARTNER_TYPE);
    }

}
