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
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.CreatedFeature;

/**
 * Page Object Model for the salesforce individual record page.
 */
public class IndividualRecordPage extends BasePage implements CreatedFeature {

    private By nameHeaderLabel = By.cssSelector("h1 div .uiOutputText");
    private By editHeaderButton = By.cssSelector("div[title=\"Edit\"]");
    private By deleteHeaderButton = By.cssSelector("div[title=\"Delete\"]");
    private By cloneHeaderButton = By.cssSelector("div[title=\"Clone\"]");
    private By confirmDeleteIndividualButton = By.cssSelector("button[title=\"Delete\"] span");
    private final String relatedFeatureLink = "h2 [title=\"%s\"]";
    private final String newFeatureButton = "//span[@title=\"%s\"]/ancestor::div[contains("
            + "@class,\"slds-grid\")]//div[@title=\"New\"]";
    private By labelNameDetail = By.xpath("//span[contains(text(),\"Name\")]/../.."
            + "//span[@class=\"uiOutputText\"]");
    private By labelBirthdateDetail = By.xpath("//span[contains(text(),\"Birth Date\")]"
            + "/../..//span[contains(@class,\"test-id__field-value\")]");
    private String checkboxDetail = "//span[contains(text(),\"%s\")]/../..//img[@alt]";
    private By labelIndividualsAgeDetail = By.xpath("//span[contains(text(),\"Individual's Age\")]"
            + "/../..//span[contains(@class,\"test-id__field-value\")]");
    private By deletedSuccessMessage = By.xpath("//span[contains(.,\"was deleted.\")]");
    private By detailsTabButton = By.xpath("//span[contains(.,\"Details\")]");
    protected By dateCreateByTxt = By.xpath(String.format("//*[contains(text(),'Created By')]/../.."
            + "//*[@class='uiOutputDateTime forceOutputModStampWithPreview']", translate("Created By")));

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public IndividualRecordPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Deletes the created individual.
     *
     * @return a HomePage instance.
     */
    public IndividualListPage deleteCreatedIndividual() {
        webElementAction.clickByLocator(deleteHeaderButton);
        webElementAction.clickByLocator(confirmDeleteIndividualButton);
        return new IndividualListPage(webDriverManager);
    }

    /**
     * Returns an alert message.
     *
     * @return String
     */
    public String getDeletedSuccessMessage() {
        return webElementAction.getTextOfByFieldByLocator(deletedSuccessMessage);
    }

    /**
     * Returns the individual's full name in the Header.
     *
     * @return String
     */
    public String getNameHeaderText() {
        return webElementAction.getTextOfByFieldByLocator(nameHeaderLabel);
    }

    /**
     * Clicks on the Edit button in the header.
     */
    public void clickEditHeaderButton() {
        webElementAction.clickByLocator(editHeaderButton);
    }

    /**
     * Clicks on the Delete button in the header.
     */
    public void clickDeleteHeaderButton() {
        webElementAction.clickByLocator(deleteHeaderButton);
    }

    /**
     * Clicks on the Clone button in the header.
     */
    public void clickCloneHeaderButton() {
        webElementAction.clickByLocator(cloneHeaderButton);
    }

    /**
     * Clicks on the relatedIndividualHistoryLink.
     */
    public void clickRelatedIndividualHistoryLink() {
        webElementAction.clickOnElement(relatedFeatureLink, "Individual History");
    }

    /**
     * Clicks on the relatedContactsLink.
     */
    public void clickRelatedContactsLink() {
        webElementAction.clickOnElement(relatedFeatureLink, "Contacts");
    }

    /**
     * Clicks on the relatedLeadsLink.
     */
    public void clickRelatedLeadsLink() {
        webElementAction.clickOnElement(relatedFeatureLink, "Leads");
    }

    /**
     * Clicks on the relatedContactPointEmailsLink.
     */
    public void clickRelatedContactPointEmailsLink() {
        webElementAction.clickOnElement(relatedFeatureLink, "Contact Point Emails");
    }

    /**
     * Clicks on the relatedContactPointPhonesLink.
     */
    public void clickRelatedContactPointPhonesLink() {
        webElementAction.clickOnElement(relatedFeatureLink, "Contact Point Phones");
    }

    /**
     * Clicks on the Details tab.
     */
    public void clickonDetailsTab() {
        webElementAction.clickByLocator(detailsTabButton);
    }

    /**
     * Returns the name text in the details tab.
     *
     * @return String
     */
    public String getNameDetail() {
        return webElementAction.getTextOfByFieldByLocator(labelNameDetail);
    }

    /**
     * Returns the birthdate text in the details tab.
     *
     * @return String
     */
    public String getBrithdateDetail() {
        return webElementAction.getTextOfByFieldByLocator(labelBirthdateDetail);
    }

    /**
     * Returns the value of the Don't Process checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontProcess() {
        return webElementAction.isSelected(checkboxDetail, "Don't Process");
    }

    /**
     * Returns the value of the Don't Market checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontMarket() {
        return webElementAction.isSelected(checkboxDetail, "Don't Market");
    }

    /**
     * Returns the value of the Export Individual's Data checkbox.
     *
     * @return boolean
     */
    public boolean checkIfExportIndividualsData() {
        return webElementAction.isSelected(checkboxDetail, "Export Individual's Data");
    }

    /**
     * Returns the value of the OK to Store PII Data Elsewhere checkbox.
     *
     * @return boolean
     */
    public boolean checkIfOkToStorePiiDataElsewhere() {
        return webElementAction.isSelected(checkboxDetail, "OK to Store PII Data Elsewhere");
    }

    /**
     * Returns the value of the BlockGeolocation checkbox.
     *
     * @return boolean
     */
    public boolean checkIfBlockGeolocationTracking() {
        return webElementAction.isSelected(checkboxDetail, "Block Geolocation Tracking");
    }

    /**
     * Returns the value of the Don't Profile checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontProfile() {
        return webElementAction.isSelected(checkboxDetail, "Don't Profile");
    }

    /**
     * Returns the value of the Don't Track checkbox.
     *
     * @return boolean
     */
    public boolean checkIfDontTrack() {
        return webElementAction.isSelected(checkboxDetail, "Don't Track");
    }

    /**
     * Returns the value of the ForgetThisIndividual checkbox.
     *
     * @return boolean
     */
    public boolean checkIfForgetThisIndividual() {
        return webElementAction.isSelected(checkboxDetail, "Forget This Individual");
    }

    /**
     * Returns the individual's age in the details tab.
     *
     * @return String
     */
    public String getIndividualAgeDetail() {
        return webElementAction.getTextOfByFieldByLocator(labelIndividualsAgeDetail);
    }

    /**
     * Clicks on the new Contact button.
     */
    public void clickOnNewContactButton() {
        webElementAction.clickOnElement(newFeatureButton, "Contact");
    }

    /**
     * Clicks on the new Lead button.
     */
    public void clickOnNewLeadButton() {
        webElementAction.clickOnElement(newFeatureButton, "Lead");
    }

    /**
     * Clicks on the new Contact Point Emails button.
     */
    public void clickNewContactPointEmailButton() {
        webElementAction.clickOnElement(newFeatureButton, "Contact Point Emails");
    }

    /**
     * Clicks on the new Contact Point Phones button.
     */
    public void clickNewContactPointPhoneButton() {
        webElementAction.clickOnElement(newFeatureButton, "Contact Point Phones");
    }

    /**
     * Gets a date when Individual is created.
     *
     * @return a String to date.
     */
    @Override
    public String getCreateDayTxt() {
        return webElementAction.getTextOfByFieldByLocator(dateCreateByTxt);
    }

    /**
     * Waits for the nameHeader element to load.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(nameHeaderLabel);
    }

    @Override
    public List<String> getValueField(Map<String, String> table) {
        return null;
    }
}
