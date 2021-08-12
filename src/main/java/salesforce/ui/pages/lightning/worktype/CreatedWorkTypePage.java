/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.worktype;

import static salesforce.utils.Internalization.translate;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.CreatedFeature;
import salesforce.utils.strategy.FeatureDetails;

/**
 * This class has webElement for work type created.
 */
public class CreatedWorkTypePage extends BasePage implements CreatedFeature {
    protected By detailsBtn = By.xpath(String.format("(//span[text()='%s'])[last()]", translate("Details")));

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public CreatedWorkTypePage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(detailsBtn);
    }

    @Override
    public FeatureDetails clickDetails() {
        webDriverActions.clickByLocator(detailsBtn);
        webDriverActions.scrollToBottom();
        return new WorkTypeDetailsPage(webDriverManager);
    }
}
