package org.salesforce.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.lightning.HomePage;
import salesforce.utils.strategy.CreatedFeature;
import salesforce.utils.strategy.FeatureNew;
import salesforce.utils.strategy.FeaturesPage;
import salesforce.utils.strategy.MapPages;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class featureSteps {
    private Logger log = Logger.getLogger(getClass());
    private PageTransporter pageTransporter;
    private SoftAssert softAssert;
    private HomePage homePage;
    private MapPages mapPages = new MapPages();
    private FeaturesPage featurePage;
    private FeatureNew featureNew;
    private CreatedFeature createdFeature;
    private Map<String, String> tableFeature;

    public featureSteps(final PageTransporter pageTransporter, final SoftAssert softAssert) {
        log.info("GeneralHooks featureSteps");
        this.pageTransporter = pageTransporter;
        this.softAssert = softAssert;
    }

    @Given("I navigate to the {string} page")
    public void iNavigateToThePage(String featureName) {
        log.info("Navigate pages");
        pageTransporter.navigateToFeaturePage(featureName);
    }

    @When("^I create a new (.*) with (?:.*)$")
    public void iCreateANewWorkTypeOnlyWithRequiredFields(String nameFeature, final Map<String, String> table) {
        log.info("Create page");
        tableFeature = table;
        featurePage = mapPages.featuresPage(nameFeature);
        featureNew = featurePage.clickNewButton();
        featureNew.fillUpField(table);
        createdFeature=featureNew.clickSaveButton();
    }

    @Then("^I verify (?:.*) created with (?:.*)$")
    public void iVerifyWorkTypeCreatedWithRequirementFields() {
        log.info("Asserts fields of feature");
       List<String> valuesField = createdFeature.getValueField(tableFeature);
        Assert.assertEquals(valuesField, new ArrayList<String>(tableFeature.values()));
    }
}
