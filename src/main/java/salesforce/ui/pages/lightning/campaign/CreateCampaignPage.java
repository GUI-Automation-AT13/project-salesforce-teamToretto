package salesforce.ui.pages.lightning.campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.BasePage;
import java.util.HashMap;

/**
 * This class is for create a new Campaign element.
 */
public class CreateCampaignPage extends BasePage {

    @FindBy(xpath = "//label/span[text()=\"Campaign Name\"]/../..//input")
    private WebElement campaignNameTextBox;

    @FindBy(xpath = "//label/span[text()=\"Active\"]/../..//input")
    private WebElement activeCheck;

    @FindBy(xpath = "")
    private WebElement typeComboBox;

    @FindBy(xpath = "")
    private WebElement statusComboBox;

    @FindBy(xpath = "//label/span[text()=\"Start Date\"]/../..//input")
    private WebElement startDateTextBox;

    @FindBy(xpath = "//label/span[text()=\"End Date\"]/../..//input")
    private WebElement endDateTextBox;

    @FindBy(xpath = "//label/span[text()=\"Expected Revenue in Campaign\"]/../..//input")
    private WebElement expectedRevenueInCampaignTextBox;

    @FindBy(xpath = "//label/span[text()=\"Budgeted Cost in Campaign\"]/../..//input")
    private WebElement budgetedCostInCampaignTextBox;

    @FindBy(xpath = "//label/span[text()=\"Actual Cost in Campaign\"]/../..//input")
    private WebElement actualCostInCampaignTextBox;

    @FindBy(xpath = "//label/span[text()=\"Expected Response (%)\"]/../..//input")
    private WebElement expectedResponseTextBox;

    @FindBy(xpath = "//label/span[text()=\"Num Sent in Campaign\"]/../..//input")
    private WebElement numSentInCampaignTextBox;

    @FindBy(xpath = "//label/span[text()=\"Parent Campaign\"]/../..//input")
    private WebElement parentCampaignTextBox;

    @FindBy(xpath = "//label/span[text()=\"Description\"]/../..//textarea")
    private WebElement descriptionTextArea;

    @FindBy(xpath = "//button[@title=\'Save\']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[@title='Save & New']")
    private WebElement saveAndNewButton;

    @FindBy(xpath = "//button[@title='Cancel']")
    private WebElement cancelButton;

    public CreateCampaignPage() {
        super();
    }

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
        webElementAction.waitForVisibilityOfElement(saveButton);
        webElementAction.waitForVisibilityOfElement(campaignNameTextBox);
        webElementAction.waitForVisibilityOfElement(startDateTextBox);
        webElementAction.waitForVisibilityOfElement(endDateTextBox);
        webElementAction.waitForVisibilityOfElement(expectedRevenueInCampaignTextBox);
        webElementAction.waitForVisibilityOfElement(budgetedCostInCampaignTextBox);
        webElementAction.waitForVisibilityOfElement(actualCostInCampaignTextBox);
        webElementAction.waitForVisibilityOfElement(numSentInCampaignTextBox);
        webElementAction.waitForVisibilityOfElement(descriptionTextArea);
    }

    /**
     * Sets the inputs fields.
     *
     * @param fieldName the name field to set.
     * @param value     the value of the field.
     * @return a this object.
     */
    public CreateCampaignPage setInputField(final String fieldName, final String value) {
        webElementAction.setTextInputField(driver.findElement(By.xpath(
                String.format(INPUT_XPATH, inputFieldNames.get(fieldName)))), value);
        return this;
    }

    /**
     * Clicks active check element.
     */
    public void clickActive() {
        activeCheck.click();
    }

    /**
     * Clicks type combobox element.
     */
    public void clickType() {
        typeComboBox.click();
    }

    /**
     * Clicks status combobox element.
     */
    public void clickStatus() {
        statusComboBox.click();
    }

    /**
     * Sets Expected response element.
     *
     * @param expectedResponse is a expected response of new campaign.
     * @return this class.
     */
    public CreateCampaignPage setExpectedResponse(final String expectedResponse) {
        webElementAction.setTextInputField(expectedResponseTextBox, expectedResponse);
        return this;
    }

    /**
     * Sets description element.
     *
     * @param description is a description of new campaign.
     * @return this class.
     */
    public CreateCampaignPage setDescription(final String description) {
        webElementAction.setTextInputField(descriptionTextArea, description);
        return this;
    }

    /**
     * Returns a page of Campaign created.
     *
     * @return Object of new CampaignCreatedPage.
     */
    public CampaignCreatedPage clickSaveBtn() {
        saveButton.click();
        return new CampaignCreatedPage();
    }
}

