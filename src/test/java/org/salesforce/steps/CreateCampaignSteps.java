package org.salesforce.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.lightning.campaign.CampaignCreatedPage;
import salesforce.ui.pages.lightning.campaign.CampaignPage;
import salesforce.ui.pages.lightning.campaign.CreateCampaignPage;

public class CreateCampaignSteps {

    private CampaignPage campaignPage;
    private CampaignCreatedPage campaignCreatedPage;
    protected LoginPage loginPage;
    private PageTransporter pageTransporter;
    String campaignName = "New Campaign Created";

    public CreateCampaignSteps(PageTransporter pageTransporter) {
        this.pageTransporter = pageTransporter;
    }

    @Given("I login to salesforce site as an developer user")
    public void iLoginToSalesforceSiteAsAnDeveloperUser() {
    }

//    @And("I navigate to Campaign page")
//    public void iNavigateToPage() {
//        campaignPage = pageTransporter.navigateToCampaignPage();
//    }

    @And("I navigate to {string} page")
    public void iNavigateToPage(String arg0) {
        campaignPage = pageTransporter.navigateTofeaturePage(arg0);
    }

    @When("I create a new Campaign with fields")
    public void iCreateANewCampaignWithFields() {
        CreateCampaignPage createCampaignPage = campaignPage.clickCreateCampaignBtn();
        createCampaignPage.setInputField("campaign name", campaignName);
        createCampaignPage.clickActive();
        campaignCreatedPage = createCampaignPage.clickSaveBtn();
        campaignCreatedPage.clickDetailTab();
        campaignCreatedPage.waitElementCampaignNameCreated();
    }

    @Then("A successful message of creating is display")
    public void aSuccessfulMessageOfCreatingIsDisplay() {
        Assert.assertEquals(campaignCreatedPage.getTextAlertSuccess(), "success\nCampaign " + "\"" + campaignName + "\"" + " was created.\nClose", "Campaign was not created");
    }

    @And("All header fields match")
    public void allHeaderFieldsMatch() {
        Assert.assertEquals(campaignCreatedPage.getCreatedCampaignTitleText(), campaignName, "Campaign was not created");
    }

    @And("All detail fields match")
    public void allDetailFieldsMatch() {
        Assert.assertEquals(campaignCreatedPage.getCampaignNameCreatedText(), campaignName, "Campaign was not created");
    }

    @And("The title matches")
    public void theTitleMatches() {
    }

    @And("The created date matches")
    public void theCreatedDateMatches() {
    }
}
