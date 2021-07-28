/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.campaign;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * This class for elements of Campaign page created.
 */
public class CampaignCreatedPage extends BasePage {

    @FindBy(css = ".slds-theme--success")
    private WebElement alertSuccess;

    @FindBy(css = "[class='slds-media__body'] span[class='custom-truncate uiOutputText']")
    private WebElement createdCampaingTitle;

    @FindBy(xpath = "//ul[contains(@class,\'branding-actions\')]/li/div//a[@role=\'button\']")
    private WebElement createdCampaignOptionBtn;

    @FindBy(xpath = "//a[@data-tab-name='detailTab']")
    private WebElement detailsTab;

    @FindBy(xpath = "//div/div/span[text()=\"Campaign Name\"]/../..//span/span")
    private WebElement campaignNameCreated;

    @FindBy(xpath = "//span[text()='Created By']/../../div/span/span")
    private WebElement createBy;

    public MenuPage clickCreatedCampaignOptionBtn() {
        createdCampaignOptionBtn.click();
        return new MenuPage();
    }

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisible(alertSuccess);
        webElementAction.waitForVisible(createdCampaingTitle);
    }

    /**
     * Returns title text of page when was created.
     *
     * @return text of element title.
     */
    public String getCreatedCampaignTitleText() {
        return createdCampaingTitle.getText();
    }

    /**
     * Gets the alert text.
     *
     * @return the text value.
     */
    public String getTextAlertSuccess() {
        return alertSuccess.getText();
    }

    /**
     * Clicks details menu tabs.
     */
    public void clickDetailTab() {
        webElementAction.clickField(detailsTab);
    }

    /**
     * Returns text of elements.
     *
     * @return text of element campaign created.
     */
    public String getCampaignNameCreatedText() {
        return campaignNameCreated.getText();
    }

    /**
     * Returns created by.
     *
     * @return text of elements created by.
     */
    public String getCreatedByText() {
        return createBy.getText();
    }

    /**
     * Waits elements of details part.
     */
    public void waitElementCampaignNameCreated() {
        wait.until(ExpectedConditions.visibilityOf(campaignNameCreated));
    }
}
