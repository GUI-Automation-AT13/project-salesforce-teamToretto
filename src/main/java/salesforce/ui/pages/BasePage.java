/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages;

import core.selenium.WebDriverActions;
import core.selenium.WebDriverManager;

/**
 * Load home page.
 */
public abstract class BasePage {

    public WebDriverActions webDriverActions;
    public WebDriverManager webDriverManager;

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public BasePage(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        webDriverActions = new WebDriverActions(this.webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     */
    protected abstract void waitForPageLoaded();
}
