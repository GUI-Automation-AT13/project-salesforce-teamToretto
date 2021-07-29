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
import salesforce.ui.pages.BasePage;

/**
 * This class is of Campaign Page.
 */
public class CampaignPage extends BasePage {

    @FindBy(css = ".forceActionLink > div")
    private WebElement createCampaignBtn;

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisible(createCampaignBtn);
    }

    /**
     * Returns a Campaing page form to create.
     *
     * @return a object CreateCampaignPage.
     */
    public CreateCampaignPage clickCreateCampaignBtn() {
        createCampaignBtn.click();
        return new CreateCampaignPage();
    }
}
