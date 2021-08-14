/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.individuals;

import static salesforce.utils.Internalization.translate;

import core.selenium.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import salesforce.ui.entities.IndividualEntity;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.FeatureForm;
import salesforce.utils.supplier.VoidSupplier;

/**
 * Page Object Model for the salesforce individual form page.
 */
public class IndividualPageForm extends BasePage implements FeatureForm {


    private String generalSalutationOptionSelector = "[title='%s']";
    private String generalCheckboxSelector = "//div[label[contains(.,'%s')]]/input";
    private String ageGeneralSelector = "//a[contains(text(),'%s')]";
    private By salutationSelector = By.cssSelector(".salutation a");
    private By firstnameTextbox = By.cssSelector(".firstName");
    private By lastnameTextbox = By.cssSelector(".lastName");
    private By birthdateDateField = By.cssSelector("input[class=' input']");
    private By individualAgeSelector = By.xpath(String.format("//div[span[span[contains(text(),'%s')]]]/div//a",
            translate("Age")));
    private By age13Option = By.xpath("//a[contains(text(),'13 or Older')]");
    private By age16Option = By.xpath("//a[contains(text(),'16 or Older')]");
    private By saveButton = By.cssSelector(String.format("button[title='%s']", translate("Save")));
    private By createdIndividualLabel = By.cssSelector(".slds-page-header__title > .uiOutputText");
    private By createdSuccessMessage = By.xpath("//span[contains(.,'was created.')]");

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public IndividualPageForm(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks the saluatation selector.
     */
    public void clickOnSalutationDropDownMenu() {
        webDriverActions.clickByLocator(salutationSelector);
    }

    /**
     * Clicks the Mr. option
     */
    public void clickOnMrOption() {
        webDriverActions.clickOnElement(generalSalutationOptionSelector, "Mr.");
    }

    /**
     * Clicks the Mrs. option
     */
    public void clickOnMrsOption() {
        webDriverActions.clickOnElement(generalSalutationOptionSelector, "Mrs.");
    }

    /**
     * Clicks the Ms. option
     */
    public void clickOnMsOption() {
        webDriverActions.clickOnElement(generalSalutationOptionSelector, "Ms.");
    }

    /**
     * Clicks the Dr. option
     */
    public void clickOnDrOption() {
        webDriverActions.clickOnElement(generalSalutationOptionSelector, "Dr.");
    }

    /**
     * Clicks the Prof. option
     */
    public void clickOnProfOption() {
        webDriverActions.clickOnElement(generalSalutationOptionSelector, "Prof.");
    }

    /**
     * Sets the firstname value to the field.
     *
     * @param firstname represents a firstname
     */
    public void setFirstnameTextbox(final String firstname) {
        webDriverActions.setInputField(firstnameTextbox, firstname);
    }

    /**
     * Sets the lastname value to the field.
     *
     * @param lastname represents the lastname to be set
     */
    public void setLastnameTextbox(final String lastname) {
        webDriverActions.setInputField(lastnameTextbox, lastname);
    }

    /**
     * Sets the date for the birthdate field.
     *
     * @param date represents the date to be set
     */
    public void setBirthdateDateField(final String date) {
        webDriverActions.setInputField(birthdateDateField, date);
    }

    /**
     * Clicks on the Don't Process checkbox.
     */
    public void clickOnDontProcessCheckbox() {
        webDriverActions.clickOnElement(generalCheckboxSelector, translate("Don't Process"));
    }

    /**
     * Clicks on the Don't Market checkbox.
     */
    public void clickOnDontMarketCheckbox() {
        webDriverActions.clickOnElement(generalCheckboxSelector, translate("Don't Market"));
    }

    /**
     * Clicks on the Export Individual's Data checkbox.
     */
    public void clickOnExportIndividualDataCheckbox() {
        webDriverActions.clickOnElement(generalCheckboxSelector, translate("Export Individual's Data"));
    }

    /**
     * Clicks on the OK to Store PII Data checkbox.
     */
    public void clickOnOkToStorePiiDataCheckbox() {
        webDriverActions.clickOnElement(generalCheckboxSelector, translate("OK to Store PII Data"));
    }

    /**
     * Clicks on the Block Geolocation checkbox.
     */
    public void clickOnBlockGeolocationCheckbox() {
        webDriverActions.clickOnElement(generalCheckboxSelector, translate("Block Geolocation Tracking"));
    }

    /**
     * Clicks on the Don't Profile checkbox.
     */
    public void clickOnDontProfileCheckbox() {
        webDriverActions.clickOnElement(generalCheckboxSelector, translate("Don't Profile"));
    }

    /**
     * Clicks on the Don't Track Checkbox.
     */
    public void clickOnDontTrackCheckbox() {
        webDriverActions.clickOnElement(generalCheckboxSelector, translate("Don't Track"));
    }

    /**
     * Clicks on the Forget This Individual checkbox.
     */
    public void clickOnForgetThisIndividualCheckbox() {
        webDriverActions.clickOnElement(generalCheckboxSelector, translate("Forget this Individual"));
    }

    /**
     * Clicks on the IndividualAgeSelector.
     */
    public void clickOnIndividualAgeSelector() {
        webDriverActions.clickByLocator(individualAgeSelector);
    }

    /**
     * Clicks on the Age13 option.
     */
    public void clickOnAge13Option() {
        webDriverActions.clickByLocator(age13Option);
    }

    /**
     * Clicks on the Age16 option.
     */
    public void clickOnAge16Option() {
        webDriverActions.clickByLocator(age16Option);
    }

    /**
     * Returns an alert message.
     *
     * @return String
     */
    public String getCreatedSuccessMessage() {
        return webDriverActions.getTextOfByFieldByLocator(createdSuccessMessage);
    }

    /**
     * Checks if the createdIndividual label element is visible.
     *
     * @return a boolean
     */
    public Boolean isVisibleIndividualNameInHeader() {
        return webDriverActions.isDisplayed(createdIndividualLabel);
    }

    /**
     * Returns the text of the IndividualName element.
     *
     * @return String
     */
    public String getCreatedIndividualNameInHeader() {
        return webDriverActions.getTextOfByFieldByLocator(createdIndividualLabel);
    }

    /**
     * Clicks and selects an Individual age option.
     *
     * @param age represents the age
     */
    private void clickOnIndividualAgeOption(String age) {
        clickOnIndividualAgeSelector();
        webDriverActions.clickOnElement(ageGeneralSelector, age);
    }

    /**
     * Clicks on a salutation option.
     *
     * @param salutation represents a salutation abbreviation.
     */
    private void clickOnSalutationOption(String salutation) {
        clickOnSalutationDropDownMenu();
        webDriverActions.clickOnElement(generalSalutationOptionSelector, salutation);
    }

    /**
     * Clicks on the save button.
     *
     * @return IndividualRecordPage
     */
    @Override
    public IndividualPageCreated clickSaveButton() {
        webDriverActions.clickByLocator(saveButton);
        return new IndividualPageCreated(webDriverManager);
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(saveButton);
    }

    /**
     * Sets values to create a new individual according key of map table input.
     *
     * @param table contains wish method is running
     */
    @Override
    public void fillUpField(Map<String, String> table) {
        HashMap<String, VoidSupplier> actionsWorkTypeMap = mapActionsWorkType(table);
        table.keySet().forEach(key -> actionsWorkTypeMap.get(key).run());
    }

    /**
     * Saves actions in New work type page in map.
     *
     * @param workTypeMap is map
     * @return a map with action of fields
     */
    private HashMap<String, VoidSupplier> mapActionsWorkType(final Map<String, String> workTypeMap) {
        HashMap<String, VoidSupplier> mapActions = new HashMap<>();
        mapActions.put("salutation", () -> clickOnSalutationOption(workTypeMap.get("salutation")));
        mapActions.put("lastname", () -> setLastnameTextbox(workTypeMap.get("lastname")));
        mapActions.put("firstname", () -> setFirstnameTextbox(workTypeMap.get("firstname")));
        mapActions.put("birthdate", () -> setBirthdateDateField(workTypeMap.get("birthdate")));
        mapActions.put("dontProcess", () -> clickOnDontProcessCheckbox());
        mapActions.put("dontMarket", () -> clickOnDontMarketCheckbox());
        mapActions.put("exportIndividualsData", () -> clickOnExportIndividualDataCheckbox());
        mapActions.put("okToStorePiiDataElsewhere", () -> clickOnIndividualAgeSelector());
        mapActions.put("blockGeolocationTracking", () -> clickOnBlockGeolocationCheckbox());
        mapActions.put("dontProfile", () -> clickOnDontProfileCheckbox());
        mapActions.put("dontTrack", () -> clickOnDontTrackCheckbox());
        mapActions.put("forgetThisIndividual", () -> clickOnForgetThisIndividualCheckbox());
        mapActions.put("individualsAge", () -> clickOnIndividualAgeOption(workTypeMap.get("individualsAge")));
        return mapActions;
    }

}
