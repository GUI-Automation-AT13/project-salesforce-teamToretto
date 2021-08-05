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
import salesforce.utils.strategy.FeatureNew;
import salesforce.utils.supplier.VoidSupplier;

/**
 * This class is for create a new Campaign element.
 */
public class CreateCampaignPage extends BasePage implements FeatureNew {

    private By campaignNameTextBox = By.xpath("//label/span[text()=\"Campaign Name\"]/../..//input");
    private By activeCheck = By.xpath("//label/span[text()=\"Active\"]/../..//input");
    private By startDateTextBox = By.xpath("//label/span[text()=\"Start Date\"]/../..//input");
    private By endDateTextBox = By.xpath("//label/span[text()=\"End Date\"]/../..//input");
    private By expectedRevenueInCampaignTextBox = By
            .xpath("//label/span[text()=\"Expected Revenue in Campaign\"]/../..//input");
    private By budgetedCostInCampaignTextBox = By
            .xpath("//label/span[text()=\"Budgeted Cost in Campaign\"]/../..//input");
    private By actualCostInCampaignTextBox = By
            .xpath("//label/span[text()=\"Actual Cost in Campaign\"]/../..//input");
    private By expectedResponseTextBox = By
            .xpath("//label/span[text()=\"Expected Response (%)\"]/../..//input");
    private By numSentInCampaignTextBox = By
            .xpath("//label/span[text()=\"Num Sent in Campaign\"]/../..//input");
    private By parentCampaignTextBox = By
            .xpath("//label/span[text()=\"Parent Campaign\"]/../..//input");
    private By descriptionTextArea = By.xpath("//label/span[text()=\"Description\"]/../..//textarea");
    private By saveButton = By.xpath("//button[@title=\'Save\']");
    private By saveAndNewButton = By.xpath("//button[@title='Save & New']");
    private By cancelButton = By.xpath("//button[@title='Cancel']");

    private static final String INPUT_XPATH = "//label/span[text()='%s']/../..//input";

    private static final HashMap<String, String> inputFieldNames = new HashMap<>();

    static {
        inputFieldNames.put("Campaign Name", "Campaign Name");
        inputFieldNames.put("Start Date", "Start Date");
        inputFieldNames.put("End Date", "End Date");
        inputFieldNames.put("Expected Revenue in Campaign", "Expected Revenue in Campaign");
        inputFieldNames.put("Budgeted Cost in Campaign", "Budgeted Cost in Campaign");
        inputFieldNames.put("Actual Cost in Campaign", "Actual Cost in Campaign");
        inputFieldNames.put("Num Sent in Campaign", "Num Sent in Campaign");
        inputFieldNames.put("Description", "Description");
    }

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager .
     */
    public CreateCampaignPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(saveButton);
    }

    /**
     * Sets the inputs fields.
     *
     * @param fieldName the name field to set.
     * @param value     the value of the field.
     * @return a this object.
     */
    public CreateCampaignPage setInputField(final String fieldName, final String value) {
        webElementAction.setInputField(By.xpath(String.format(INPUT_XPATH, inputFieldNames.get(fieldName))), value);
        return this;
    }

    /**
     * Sets Expected response element.
     *
     * @param expectedResponse is a expected response of new campaign.
     * @return this class.
     */
    public CreateCampaignPage setExpectedResponse(final String expectedResponse) {
        webElementAction.setInputField(expectedResponseTextBox, expectedResponse);
        return this;
    }

    /**
     * Sets description element.
     *
     * @param description is a description of new campaign.
     * @return this class.
     */
    public CreateCampaignPage setDescription(final String description) {
        webElementAction.setInputField(descriptionTextArea, description);
        return this;
    }

    /**
     * Returns a page of Campaign created.
     *
     * @return Object of new CampaignCreatedPage.
     */
    public CampaignCreatedPage clickSaveBtn() {
        webElementAction.clickByLocator(saveButton);
        return new CampaignCreatedPage(webDriverManager);
    }

    /**
     * Clicks active check element.
     */
    public void clickActive() {
        webElementAction.clickByLocator(activeCheck);
    }

    @Override
    public void fillUpField(Map<String, String> table) {
        HashMap<String, VoidSupplier> actionsContractMap = mapActionsContract(table);
        table.keySet().forEach(key -> actionsContractMap.get(key).run());
    }

    @Override
    public CampaignCreatedPage clickSaveButton() {
        webElementAction.clickByLocator(saveButton);
        return new CampaignCreatedPage(webDriverManager);
    }

    /**
     * Saves actions in New work type page in map.
     *
     * @param campaignMap is map
     * @return a map with action of fields
     */
    private HashMap<String, VoidSupplier> mapActionsContract(final Map<String, String> campaignMap) {
        HashMap<String, VoidSupplier> mapActions = new HashMap<>();
        mapActions.put("Campaign Name", () -> setInputField(
                "Campaign Name",
                campaignMap.get("Campaign Name")));
        mapActions.put("Start Date", () -> setInputField(
                "Start Date",
                campaignMap.get("Start Date")));
        mapActions.put("End Date", () -> setInputField(
                "End Date",
                campaignMap.get("End Date")));
        mapActions.put("Expected Revenue in Campaign", () -> setInputField(
                "Expected Revenue in Campaign",
                campaignMap.get("Expected Revenue in Campaign")));
        mapActions.put("Budgeted Cost in Campaign", () -> setInputField(
                "Budgeted Cost in Campaign",
                campaignMap.get("Budgeted Cost in Campaign")));
        mapActions.put("Actual Cost in Campaign", () -> setInputField(
                "Actual Cost in Campaign",
                campaignMap.get("Actual Cost in Campaign")));
        mapActions.put("Num Sent in Campaign", () -> setInputField(
                "Num Sent in Campaign",
                campaignMap.get("Num Sent in Campaign")));
        mapActions.put("Description", () -> setInputField(
                "Description",
                campaignMap.get("Description")));
        return mapActions;
    }
}
