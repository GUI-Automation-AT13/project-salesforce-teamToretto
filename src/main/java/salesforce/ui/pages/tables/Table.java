/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.tables;

import core.selenium.WebDriverManager;
import salesforce.ui.pages.BasePage;

/**
 * Represents a UI table, contains the header name of the table and the table.
 */
public class Table extends BasePage {

    private String name;
    private String baseLocator;

    /**
     * BaseElement constructor.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public Table(final WebDriverManager webDriverManager, final String baseLocator, final String titleName) {
        super(webDriverManager);
    }

    /**
     * Returns the name.
     *
     * @return a String
     */
    public String getName() {
        return name;
    }

    @Override
    protected void waitForPageLoaded() {

    }
}
