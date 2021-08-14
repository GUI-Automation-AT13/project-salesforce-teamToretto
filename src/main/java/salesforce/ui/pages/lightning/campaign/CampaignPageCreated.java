/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.campaign;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.FeatureCreated;
import salesforce.utils.strategy.FeatureDetails;

/**
 * This class for elements of Campaign page created.
 */
public class CampaignPageCreated extends BasePage implements FeatureCreated {

    private By alertSuccess = By.cssSelector(".slds-theme--success");
    private By createdCampaignTitle = By.cssSelector("[class='slds-media__body'] "
            + "span[class='custom-truncate uiOutputText']");
    private By createdCampaignOptionBtn = By.xpath("//ul[contains(@class,'branding-actions')]/li/div"
             + "//a[@role='button']");
    private By detailsTab = By.xpath("//a[@data-tab-name='detailTab']");

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public CampaignPageCreated(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Returns title text of page when was created.
     *
     * @return text of element title.
     */
    public String getCreatedCampaignTitleText() {
        return webDriverActions.getTextOfByFieldByLocator(createdCampaignTitle);
    }

    /**
     * Gets the alert text.
     *
     * @return the text value.
     */
    public String getTextAlertSuccess() {
        return webDriverActions.getTextOfByFieldByLocator(alertSuccess);
    }

    /**
     * Clicks details menu tabs.
     *
     * @return a FeatureDetails object
     */
    @Override
    public FeatureDetails clickDetails() {
        webDriverActions.clickByLocator(detailsTab);
        webDriverActions.scrollToBottom();
        return new CampaignDetails(webDriverManager);
    }

    /**
     * Waits to load page and display the alert successful.
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(alertSuccess);
    }
}
