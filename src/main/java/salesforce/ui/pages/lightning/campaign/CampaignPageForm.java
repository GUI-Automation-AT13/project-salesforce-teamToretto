/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.campaign;

import core.selenium.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.FeatureForm;
import salesforce.utils.supplier.VoidSupplier;

import static salesforce.utils.Internalization.translate;

/**
 * This class is for create a new Campaign element.
 */
public class CampaignPageForm extends BasePage implements FeatureForm {

    private By activeCheck = By.xpath(String.format("//label/span[text()='%s']/../..//input",
            translate("Active")));
    private By expectedResponseTextBox = By.xpath(String.format("//label/span[text()='%s']/../..//input",
            translate("Expected Response (%)")));
    private By descriptionTextArea = By.xpath(String.format("//label/span[text()='%s']/../..//textarea",
            translate("Description")));
    private By saveButton = By.xpath(String.format("//button[@title='%s']", translate("Save")));
    private By saveAndNewButton = By.xpath(String.format("//button[@title='%s']", translate("Save & New")));
    private By cancelButton = By.xpath(String.format("//button[@title='%s']", translate("Cancel")));
    private String INPUT_XPATH = "//label/span[text()='%s']/../..//input";
    private String statusComboBox = "(//*[contains(text(),'%s')]/../..//a[@class='select'])[2]";
    private String typeComboBox = "(//*[contains(text(),'%s')]/../..//a[@class='select'])[1]";
    private String xpathValueComboBoxSomeFields = "//div[@aria-labelledby][@id]//*[contains(text(),'%s')]/..";

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public CampaignPageForm(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }


    /**
     * Sets the inputs fields.
     *
     * @param fieldName the name field to set.
     * @param value of the field.
     */
    public void setInputField(final String fieldName, final String value) {
        webDriverActions.setInputField(By.xpath(String.format(INPUT_XPATH, fieldName)), value);
    }

    /**
     * Sets description element.
     *
     * @param description is a description of new campaign.
     * @return this class.
     */
    public CampaignPageForm setDescription(final String description) {
        webDriverActions.setInputField(descriptionTextArea, description);
        return this;
    }

    /**
     * Sets value and select type and Status.
     *
     * @param nameComboBox is name of comboBox
     * @param selectValue  is a value in comboBox
     */
    public void setStatus(final String nameComboBox, final String selectValue) {
        webDriverActions.selectByAction(By.xpath(String.format(statusComboBox, nameComboBox)));
        webDriverActions.clickByXpath(String.format(xpathValueComboBoxSomeFields, selectValue));
    }

    /**
     * Sets value and select type and Type.
     *
     * @param nameComboBox is name of comboBox
     * @param selectValue  is a value in comboBox
     */
    public void setType(final String nameComboBox, final String selectValue) {
        webDriverActions.selectByAction(By.xpath(String.format(typeComboBox, nameComboBox)));
        webDriverActions.clickByXpath(String.format(xpathValueComboBoxSomeFields, selectValue));
    }

    /**
     * Clicks active check element.
     */
    public void clickActive() {
        webDriverActions.clickByLocator(activeCheck);
    }

    /**
     * Sets Expected response element.
     *
     * @param expectedResponse is a expected response of new campaign.
     */
    public void setExpectedResponse(final String expectedResponse) {
        webDriverActions.setInputField(expectedResponseTextBox, expectedResponse);
    }

    /**
     * Returns a page of Campaign created.
     *
     * @return Object of new CampaignCreatedPage.
     */
    @Override
    public CampaignPageCreated clickSaveButton() {
        webDriverActions.clickByLocator(saveButton);
        return new CampaignPageCreated(webDriverManager);
    }


    /**
     * Waits to load save button appear.
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(saveButton);
    }

    /**
     * Sets values to create a new campaign according key of map table input.
     *
     * @param table contains wish method is running
     */
    @Override
    public void fillUpField(Map<String, String> table) {
        HashMap<String, VoidSupplier> actionsContractMap = mapActionsContract(table);
        table.keySet().forEach(key -> actionsContractMap.get(key).run());
    }

    /**
     * Saves actions in New work type page in map.
     *
     * @param campaignMap is map
     * @return a map with action of fields
     */
    private HashMap<String, VoidSupplier> mapActionsContract(final Map<String, String> campaignMap) {
        HashMap<String, VoidSupplier> mapActions = new HashMap<>();
        mapActions.put("Campaign Name", () -> setInputField(translate("Campaign Name"),
                campaignMap.get("Campaign Name")));
        mapActions.put("Start Date", () -> setInputField(translate("Start Date"),
                campaignMap.get("Start Date")));
        mapActions.put("End Date", () -> setInputField(translate("End Date"),
                campaignMap.get("End Date")));
        mapActions.put("Expected Revenue in Campaign", () -> setInputField(
                translate("Expected Revenue in Campaign"), campaignMap.get("Expected Revenue in Campaign")));
        mapActions.put("Budgeted Cost in Campaign", () -> setInputField(translate("Budgeted Cost in Campaign"),
                campaignMap.get("Budgeted Cost in Campaign")));
        mapActions.put("Actual Cost in Campaign", () -> setInputField(translate("Actual Cost in Campaign"),
                campaignMap.get("Actual Cost in Campaign")));
        mapActions.put("Num Sent in Campaign", () -> setInputField(translate("Num Sent in Campaign"),
                campaignMap.get("Num Sent in Campaign")));
        mapActions.put("Description", () -> setInputField(translate("Description"),
                campaignMap.get("Description")));
        mapActions.put("Status", () -> setStatus(
                translate("Status"), campaignMap.get("Status")));
        mapActions.put("Type", () -> setType(
                translate("Type"), campaignMap.get("Type")));
        return mapActions;
    }
}
