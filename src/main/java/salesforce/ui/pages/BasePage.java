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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Load home page.
 */
public abstract class BasePage {
    public WebElementAction webElementAction;
    public WebDriverWait wait;
    public WebDriver driver;

    /**
     * Initializes the elements and wait for page to be loaded.
     */
    public BasePage() {
        webElementAction = new WebElementAction();
    }

    /**
     * Waits for the page to be loaded.
     */
    protected abstract void waitForPageLoaded();


}
