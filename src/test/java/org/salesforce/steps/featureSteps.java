package org.salesforce.steps;

import core.selenium.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import salesforce.config.EnvConfig;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.lightning.HomePage;
import salesforce.utils.strategy.ICreatedFeature;
import salesforce.utils.strategy.IFeatureNew;
import salesforce.utils.strategy.IFeaturesPage;
import salesforce.utils.strategy.MapPages;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class featureSteps {
    public PageTransporter pageTransporter = new PageTransporter();
    private HomePage homePage;
    private MapPages mapPages = new MapPages();
    private IFeaturesPage featurePage;
    private IFeatureNew featureNew;
    private ICreatedFeature createdFeature;
    private Map<String, String> tableFeature;

    @Given("I login to Salesforce site as an admin user")
    public void iLoginToSalesforceSiteAsAnAdminUser() {
        WebDriverManager.getInstance();
        WebDriverManager.getInstance().getWebDriver().get(EnvConfig.getInstance().getLoginUrl());
        WebDriverManager.getInstance().getWebDriver().manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        homePage = loginPage.loginSuccessful(EnvConfig.getInstance().getUser(),
                EnvConfig.getInstance().getPassword());
    }

    @When("I navigate to {string} page in mode {string}")
    public void iNavigateToPageInMode(String arg0, String arg1) {
        pageTransporter.navigateToWorkTypePageLightningDirect();
    }

    @When("^I create a new (.*) with (?:.*)$")
    public void iCreateANewWorkTypeOnlyWithRequiredFields(String nameFeature, final Map<String, String> table) {
        tableFeature = table;
        featurePage = mapPages.featuresPage(nameFeature);
        featureNew = featurePage.clickNewButton();
        featureNew.fillUpField(table);
        createdFeature=featureNew.clickSaveButton();
    }

    @Then("^I verify (?:.*) created with (?:.*)$")
    public void iVerifyWorkTypeCreatedWithRequirementFields() {
       List<String> valuesField = createdFeature.getValueField(tableFeature);
        Assert.assertEquals(valuesField, new ArrayList<String>(tableFeature.values()));
    }
}
