/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import salesforce.ui.pages.BasePage;

/**
 * Header element for the Salesforce pages.
 */
public class Header extends BasePage {

    private By searchBar = By.cssSelector("input[title]");

    /**
     * Header constructor.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public Header(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    public void enterTextInSearchBar(final String text) {
        webDriverActions.setInputField(searchBar, text);
    }

    public void pressEnterforSearchBar() {
        webDriverActions.pressKey(searchBar, Keys.ENTER);
    }

    @Override
    protected void waitForPageLoaded() {

    }
}
