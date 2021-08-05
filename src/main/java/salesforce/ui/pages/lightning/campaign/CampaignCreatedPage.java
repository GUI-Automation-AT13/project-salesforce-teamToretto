/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.campaign;

import static salesforce.utils.Internalization.translate;

import core.selenium.WebDriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.CreatedFeature;
import salesforce.utils.supplier.StringSupplier;

/**
 * This class for elements of Campaign page created.
 */
public class CampaignCreatedPage extends BasePage implements CreatedFeature {

    private By alertSuccess = By.cssSelector(".slds-theme--success");
    private By createdCampaignTitle = By
            .cssSelector("[class='slds-media__body'] span[class='custom-truncate uiOutputText']");
    private By createdCampaignOptionBtn = By
            .xpath("//ul[contains(@class,\'branding-actions\')]/li/div//a[@role=\'button\']");
    private By detailsTab = By.xpath("//a[@data-tab-name='detailTab']");
    private By campaignNameCreated = By
            .xpath("//div/div/span[text()=\"Campaign Name\"]/../..//span/span");
    private By createBy = By.xpath("//span[text()='Created By']/../../div/span/span");
    protected By dateCreateByTxt = By.xpath(String.format("//*[contains(text(),'Created By')]/../.."
            + "//*[@class='uiOutputDateTime forceOutputModStampWithPreview']", translate("Created By")));
    private static final String BASE_XPATH = "//div[./div[./span[text()='%s']]]";
    private static final HashMap<String, String> XPATH_COMPLEMENTS = new HashMap<>();

    static {
        XPATH_COMPLEMENTS.put("Campaign Name", "//span//span");
        XPATH_COMPLEMENTS.put("Start Date", "//span//span");
        XPATH_COMPLEMENTS.put("End Date", "//span//span");
        XPATH_COMPLEMENTS.put("Expected Revenue in Campaign", "//span//span");
        XPATH_COMPLEMENTS.put("Budgeted Cost in Campaign", "//span//span");
        XPATH_COMPLEMENTS.put("Actual Cost in Campaign", "//span//span");
        XPATH_COMPLEMENTS.put("Num Sent in Campaign", "//span//span");
        XPATH_COMPLEMENTS.put("Description", "//span//span");
    }

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public CampaignCreatedPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets the text inside the element.
     *
     * @param field represents the text to be introduced
     * @return the text set on the field requested contract
     */
    public String getTextByFieldName(final String field) {
        String xpathComplement = XPATH_COMPLEMENTS.get(field);
        String xpath = String.format(BASE_XPATH, field).concat(xpathComplement);
        By xpathLocator = By.xpath(xpath);
        return webElementAction.getTextOfByFieldByLocator(xpathLocator);
    }

    public MenuPage clickCreatedCampaignOptionBtn() {
        webElementAction.clickByLocator(createdCampaignOptionBtn);
        return new MenuPage(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(alertSuccess);
    }

    /**
     * Returns title text of page when was created.
     *
     * @return text of element title.
     */
    public String getCreatedCampaignTitleText() {
        return webElementAction.getTextOfByFieldByLocator(createdCampaignTitle);
    }

    /**
     * Gets the alert text.
     *
     * @return the text value.
     */
    public String getTextAlertSuccess() {
        return webElementAction.getTextOfByFieldByLocator(alertSuccess);
    }

    /**
     * Clicks details menu tabs.
     */
    public void clickDetailTab() {
        webElementAction.clickByLocator(detailsTab);
    }

    /**
     * Returns text of elements.
     *
     * @return text of element campaign created.
     */
    public String getCampaignNameCreatedText() {
        return webElementAction.getTextOfByFieldByLocator(campaignNameCreated);
    }

    /**
     * Returns created by.
     *
     * @return text of elements created by.
     */
    public String getCreatedByText() {
        return webElementAction.getTextOfByFieldByLocator(createBy);
    }

    /**
     * Waits elements of details part.
     */
    public void waitElementCampaignNameCreated() {
        webElementAction.waitForVisibilityOfLocator(campaignNameCreated);
    }

    /**
     * Gets a date when workType is created.
     *
     * @return a String to date
     */
    @Override
    public String getCreateDayTxt() {
        return webElementAction.getTextOfByFieldByLocator(dateCreateByTxt);
    }

    @Override
    public List<String> getValueField(Map<String, String> table) {
        List<String> result = new ArrayList<>();
        HashMap<String, StringSupplier> actionsCampaignMap = getTxtFields();
        table.keySet().forEach(key -> result.add(actionsCampaignMap.get(key).getAsString()));
        return result;
    }

    /**
     * Gets text fields of workType.
     *
     * @return a map with methods of CreatedWorkType
     */
    private HashMap<String, StringSupplier> getTxtFields() {
        webElementAction.clickByLocator(detailsTab);
        webElementAction.dropDownTillTheEnd();
        HashMap<String, StringSupplier> mapValues = new HashMap<>();
        mapValues.put("Campaign Name", () -> getTextByFieldName("Campaign Name"));
        mapValues.put("Start Date", () -> getTextByFieldName("Start Date"));
        mapValues.put("End Date", () -> getTextByFieldName("End Date"));
        mapValues.put("Expected Revenue in Campaign", () -> getTextByFieldName("Expected Revenue in Campaign"));
        mapValues.put("Budgeted Cost in Campaign", () -> getTextByFieldName("Budgeted Cost in Campaign"));
        mapValues.put("Actual Cost in Campaign", () -> getTextByFieldName("Actual Cost in Campaign"));
        mapValues.put("Num Sent in Campaign", () -> getTextByFieldName("Num Sent in Campaign"));
        mapValues.put("Description", () -> getTextByFieldName("Description"));
        return mapValues;
    }
}
