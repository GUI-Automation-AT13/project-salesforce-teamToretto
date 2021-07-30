/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.campaign;

import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;

/**
 * This class for elements of Campaign page created.
 */
public class CampaignCreatedPage extends BasePage {

    private By alertSuccess = By.cssSelector(".slds-theme--success");
    private By createdCampaignTitle = By
            .cssSelector("[class='slds-media__body'] span[class='custom-truncate uiOutputText']");
    private By createdCampaignOptionBtn = By
            .xpath("//ul[contains(@class,\'branding-actions\')]/li/div//a[@role=\'button\']");

    private By detailsTab = By.xpath("//a[@data-tab-name='detailTab']");
    private By campaignNameCreated = By
            .xpath("//div/div/span[text()=\"Campaign Name\"]/../..//span/span");
    private By createBy = By.xpath("//span[text()='Created By']/../../div/span/span");

    public MenuPage clickCreatedCampaignOptionBtn() {
        webElementAction.clickByLocator(createdCampaignOptionBtn);
        return new MenuPage();
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
}
