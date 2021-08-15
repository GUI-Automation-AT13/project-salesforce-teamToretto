package org.salesforce.steps;

import static core.utils.date.DateManager.generateDateActual;

import core.selenium.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import salesforce.ui.pages.lightning.TablesDefectValues;
import salesforce.ui.pages.lightning.individuals.IndividualPageCreated;
import salesforce.ui.pages.lightning.individuals.IndividualsPage;
import salesforce.utils.GeneratorUniqueString;
import salesforce.utils.Internalization;
import salesforce.utils.PageTransporter;
import salesforce.utils.strategy.FeatureCreated;
import salesforce.utils.strategy.FeatureDetails;
import salesforce.utils.strategy.FeatureForm;
import salesforce.utils.strategy.FeaturesPage;
import salesforce.utils.strategy.MapPages;

/**
 * This defines the features steps.
 */
public class FeatureSteps {
    private Logger log = LogManager.getLogger(getClass());
    private WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;
    private TablesDefectValues tablesDefectValues;
    private SoftAssert softAssert;
    private Internalization internalization;
    private MapPages mapPages;
    private FeaturesPage featurePage;
    private FeatureForm featureForm;
    private FeatureCreated featureCreated;
    private FeatureDetails featureDetails;
    private Map<String, String> tableFeature;

    /**
     * This defines the features steps.
     */
    public FeatureSteps(final WebDriverManager webDriverManager) {
        log.info("GeneralHooks featureSteps");
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(this.webDriverManager);
        this.mapPages = new MapPages(this.webDriverManager);
        this.softAssert = new SoftAssert();
        tablesDefectValues = new TablesDefectValues();
    }

    /**
     * Navigates to a page according to the page's name.
     *
     * @param featureName the page's name.
     */
    @Given("^I navigate to the (.*) page$")
    public void navigatesToFeaturePage(String featureName) {
        log.info("Navigate pages");
        internalization = new Internalization(featureName);
        pageTransporter.navigateToFeaturePage(featureName);
    }

    /**
     * Creates a feature with the value on a table.
     *
     * @param table the values to be filled up.
     * @param nameFeature the feature that will receive the values.
     */
    @When("^I create a new (.*) with (?:.*)$")
    public void createFeature(String nameFeature, final Map<String, String> table) {
        log.info("Create page");
        tableFeature = GeneratorUniqueString.nameUnique(table, nameFeature);
        featurePage = mapPages.featuresPage(nameFeature);
        featureForm = featurePage.clickNewButton();
        featureForm.fillUpField(tableFeature);
        featureCreated = featureForm.clickSaveButton();
        featureDetails = featureCreated.clickDetails();
    }

    /**
     * Verifies if the feature contains the set values.
     */
    @Then("^I verify that the created (?:.*) contains the correct information")
    public void verifyFeatureValues() {
        log.info("Asserts fields of feature");
        List<String> valuesField = featureDetails.getValuesFromFields(tableFeature);
        Assert.assertEquals(valuesField, new ArrayList<String>(tableFeature.values()));
    }

    /**
     * Verifies the feature's creation date values.
     */
    @And("I verify that the date matches the creation date")
    public void verifyCreationDate() {
        Assert.assertEquals(featureDetails.getCreateDayTxt(), generateDateActual("M/d/yyyy, h:mm a"));
    }

    /**
     * Verifies the feature's creation date values.
     *
     * @param featureName to verify the table.
     */
    @Then("^I verify (.*) created and matches with values of table$")
    public void verifyTableInfo(String featureName) {
        List<String> actual = featurePage.getTablesValues(tableFeature);
        List<String> expected = tablesDefectValues.getExpectedValues(featureName, tableFeature);
        Assert.assertEquals(actual, expected);
    }

    /**
     * Verifies the displayed Name content.
     *
     * @param text to be verified.
     */
    @Then("The name displayed should contain {string}")
    public void verifyDisplayedNameContent(final String text) {
        IndividualPageCreated individualPageCreated = new IndividualPageCreated(webDriverManager);
        String headerNameText = individualPageCreated.getNameHeaderText();
        Assert.assertEquals(headerNameText, text);
    }

    /**
     * Verifies the content on a list's page.
     *
     * @param text to be verified.
     */
    @Then("The feature list Page should contain a record with {string}")
    public void verifyListPageRecordContent(final String text) {
        IndividualsPage individualsPage = pageTransporter.navigateToIndividualListPage();
        Assert.assertTrue(individualsPage.isThereRecordWithName(text));
    }
}
