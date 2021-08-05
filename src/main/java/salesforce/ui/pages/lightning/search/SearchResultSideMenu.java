/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.search;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;

/**
 * Side Menu component for the search result page.
 */
public class SearchResultSideMenu extends BasePage {

    private By optionTpResults;
    private By optionUsers;
    private By optionProfiles;
    private By optionPermissionSets;
    private By optionObjects;
    private By optionFields;
    private By optionGroupAndQueues;
    private By optionShowMore;

    /**
     * SearchResultsSideMenu constructor.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public SearchResultSideMenu(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {

    }
}
