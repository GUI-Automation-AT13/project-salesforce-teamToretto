/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning;

import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;

/**
 * Page object model for a base page.
 */
public class HomePage extends BasePage {

    public static final String URL = "/lightning/page/home";
    private By labelObjectManager = By.cssSelector(".hasActions .title");

    /**
     * Checks if the ObjectManager label is visible.
     *
     * @return boolean.
     */
    public boolean labelObjectManageriIsVisible() {
        return webElementAction.isDisplayed(labelObjectManager);
    }

    @Override
    protected void waitForPageLoaded() {
    }
}
