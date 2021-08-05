/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages;

import core.selenium.WebDriverManager;
import core.selenium.WebElementAction;

/**
 * Load home page.
 */
public abstract class BasePage {
    public WebElementAction webElementAction;
    public WebDriverManager webDriverManager;

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public BasePage(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        webElementAction = new WebElementAction(this.webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     */
    protected abstract void waitForPageLoaded();


}
