package org.salesforce.steps;

import core.selenium.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import salesforce.ui.PageTransporter;
import salesforce.utils.Internalization;
import salesforce.utils.strategy.CreatedFeature;
import salesforce.utils.strategy.FeatureNew;
import salesforce.utils.strategy.FeaturesPage;
import salesforce.utils.strategy.MapPages;

public class featureSteps {
    private Logger log = Logger.getLogger(getClass());
    private WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;
    private SoftAssert softAssert;
    private Internalization internalization;
    private MapPages mapPages;
    private FeaturesPage featurePage;
    private FeatureNew featureNew;
    private CreatedFeature createdFeature;
    private Map<String, String> tableFeature;

    public featureSteps(final WebDriverManager webDriverManager) {
        log.info("GeneralHooks featureSteps");
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(this.webDriverManager);
        this.mapPages = new MapPages(this.webDriverManager);
        this.softAssert = new SoftAssert();
    }

    @Given("I navigate to the {string} page")
    public void iNavigateToThePage(String featureName) {
        log.info("Navigate pages");
        internalization = new Internalization(featureName);
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
