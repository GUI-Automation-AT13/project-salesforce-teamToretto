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
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.CreatedFeature;
import salesforce.utils.strategy.FeatureDetails;

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

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public CampaignCreatedPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
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
     * Clicks details menu tabs.
     */
    @Override
    public FeatureDetails clickDetails() {
        webElementAction.clickByLocator(detailsTab);
        webElementAction.dropDownTillTheEnd();
        return new CampaignDetails(webDriverManager);
    }
}
