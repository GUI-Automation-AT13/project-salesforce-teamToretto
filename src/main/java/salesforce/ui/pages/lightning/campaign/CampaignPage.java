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
import salesforce.ui.pages.lightning.contracts.NewContractPage;
import salesforce.utils.strategy.FeatureNew;
import salesforce.utils.strategy.FeaturesPage;

import java.util.List;
import java.util.Map;

/**
 * This class is of Campaign Page.
 */
public class CampaignPage extends BasePage implements FeaturesPage {

    protected By createCampaignBtn = By.xpath("//a[@class='forceActionLink'][@role='button']");

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public CampaignPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(createCampaignBtn);
    }

    /**
     * Returns a Campaing page form to create.
     *
     * @return a object CreateCampaignPage.
     */
    public CreateCampaignPage clickCreateCampaignBtn() {
        webElementAction.clickByLocator(createCampaignBtn);
        return new CreateCampaignPage(webDriverManager);
    }

    @Override
    public CreateCampaignPage clickNewButton() {
        webElementAction.clickByLocator(createCampaignBtn);
        return new CreateCampaignPage(webDriverManager);
    }

    @Override
    public List<String> getValueTables(Map<String, String> table) {
        return null;
    }
}
