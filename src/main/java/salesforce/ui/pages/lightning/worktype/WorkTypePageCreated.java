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
import salesforce.utils.strategy.FeatureCreated;
import salesforce.utils.strategy.FeatureDetails;

/**
 * This class has webElement for work type created.
 */
public class WorkTypePageCreated extends BasePage implements FeatureCreated {
    protected By detailsBtn = By.xpath(String.format("(//span[text()='%s'])[last()]", translate("Details")));

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public WorkTypePageCreated(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Clicks details menu tabs.
     *
     * @return a FeatureDetails object
     */
    @Override
    public FeatureDetails clickDetails() {
        webDriverActions.clickByLocator(detailsBtn);
        webDriverActions.scrollToBottom();
        return new WorkTypeDetails(webDriverManager);
    }

    /**
     * Waits to load page and display the alert successful.
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(detailsBtn);
    }
}
