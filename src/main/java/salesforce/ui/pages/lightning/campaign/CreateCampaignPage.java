/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.campaign;

import java.util.HashMap;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;

/**
 * This class is for create a new Campaign element.
 */
public class CreateCampaignPage extends BasePage {

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
        inputFieldNames.put("campaign name", "Campaign Name");
        inputFieldNames.put("start date", "Start Date");
        inputFieldNames.put("end date", "End Date");
        inputFieldNames.put("expected revenue in campaign", "Expected Revenue in Campaign");
        inputFieldNames.put("budgeted cost in campaign", "Budgeted Cost in Campaign");
        inputFieldNames.put("actual cost in campaign", "Actual Cost in Campaign");
        inputFieldNames.put("num sent in campaign", "Num Sent in Campaign");
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
        return new CampaignCreatedPage();
    }
}
