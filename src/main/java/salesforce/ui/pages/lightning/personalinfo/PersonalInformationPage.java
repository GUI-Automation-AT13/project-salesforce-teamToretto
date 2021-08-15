/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.personalinfo;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;

/**
 * This class has webElement for personal information pages.
 */
public class PersonalInformationPage extends BasePage {

    private By aliasTxtBox = By.id("PersonalInformationSetup:editPage:pageBlock:alias");

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public PersonalInformationPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets text of alias.
     *
     * @return a String with alias.
     */
    public String getAliasTxt() {
        return webDriverActions.getTextOfByFieldByLocator(aliasTxtBox);
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(aliasTxtBox);
    }
}
