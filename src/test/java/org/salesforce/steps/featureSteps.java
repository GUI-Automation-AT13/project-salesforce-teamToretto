package org.salesforce.steps;

import core.selenium.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import salesforce.ui.entities.PersonalInformation;
import salesforce.ui.PageTransporter;
import salesforce.utils.GeneratorUniqueString;
import salesforce.utils.Internalization;
import salesforce.utils.strategy.CreatedFeature;
import salesforce.utils.strategy.FeatureNew;
import salesforce.utils.strategy.FeaturesPage;
import salesforce.utils.strategy.FeatureDetails;
import salesforce.utils.strategy.MapPages;

import static core.utils.date.DateManager.generateDateActual;

public class featureSteps {
    private Logger log = Logger.getLogger(getClass());
    private WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;
    private SoftAssert softAssert;
    private Internalization internalization;
    private PersonalInformation personalInformation;
    private MapPages mapPages;
    private FeaturesPage featurePage;
    private FeatureNew featureNew;
    private CreatedFeature createdFeature;
    private FeatureDetails featureDetails;
    private Map<String, String> tableFeature;

    public featureSteps(final WebDriverManager webDriverManager, final PersonalInformation personalInformation) {
        log.info("GeneralHooks featureSteps");
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(this.webDriverManager);
        this.personalInformation = personalInformation;
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
        tableFeature = GeneratorUniqueString.nameUnique(table, nameFeature);
        featurePage = mapPages.featuresPage(nameFeature);
        featureNew = featurePage.clickNewButton();
        featureNew.fillUpField(table);
        createdFeature=featureNew.clickSaveButton();
        featureDetails = createdFeature.clickDetails();
    }

    @Then("^I verify that the created (?:.*) contains the correct information")
    public void iVerifyThatTheCreatedContractContainsTheCorrectInformation() {
        log.info("Asserts fields of feature");
        List<String> valuesField = featureDetails.getValueField(tableFeature);
        Assert.assertEquals(valuesField, new ArrayList<String>(tableFeature.values()));
    }

    @And("I verify that the date matches the creation date")
    public void iVerifyDateCreate() {
        Assert.assertEquals(featureDetails.getCreateDayTxt(),generateDateActual("M/d/yyyy, h:mm a"));
    }

    @Then("^I verify (.*) created and matches with values of table$")
    public void iVerifyWorkTypeCreatedInTable(String nameFeature) {
        pageTransporter.navigateToFeaturePage(nameFeature);
        List<String> actual = featurePage.getValueTables(tableFeature);
        List<String> expected = featurePage.getExpected(tableFeature, personalInformation);
        Assert.assertEquals(actual, expected);
    }
}
