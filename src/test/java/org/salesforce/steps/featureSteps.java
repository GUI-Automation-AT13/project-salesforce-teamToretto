package org.salesforce.steps;

import core.selenium.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import salesforce.config.EnvConfig;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.lightning.HomePage;
import salesforce.utils.strategy.CreatedFeature;
import salesforce.utils.strategy.FeatureNew;
import salesforce.utils.strategy.FeaturesPage;
import salesforce.utils.strategy.MapPages;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class featureSteps {

    private PageTransporter pageTransporter;
    private SoftAssert softAssert;
    private HomePage homePage;
    private MapPages mapPages = new MapPages();
    private FeaturesPage featurePage;
    private FeatureNew featureNew;
    private CreatedFeature createdFeature;
    private Map<String, String> tableFeature;

    public featureSteps(final PageTransporter pageTransporter, final SoftAssert softAssert) {
        this.pageTransporter = pageTransporter;
        this.softAssert = softAssert;
    }

    @When("I navigate to the {string} page")
    public void iNavigateToThePage(String featureName) {
        pageTransporter.navigateToFeaturePage(featureName);
    }

    @When("^I create a new (.*) with (?:.*)$")
    public void iCreateANewWorkTypeOnlyWithRequiredFields(String nameFeature, final Map<String, String> table) {
        tableFeature = table;
        featurePage = mapPages.featuresPage(nameFeature);
        featureNew = featurePage.clickNewButton();
        featureNew.fillUpField(table);
        createdFeature=featureNew.clickSaveButton();
    }

    @When("^I create a new (.*) object with the following field values$")
    public void iCreateAnewObjectWithTheFollowingFieldValues(String nameFeature, final Map<String, String> table) {
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
