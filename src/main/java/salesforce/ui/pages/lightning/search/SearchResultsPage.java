/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.search;

import core.selenium.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import salesforce.ui.pages.BasePage;
import salesforce.ui.pages.lightning.Header;

/**
 * POM for the Salesforce search result page.
 */
public class SearchResultsPage extends BasePage {

    private Header header;
    private SearchResultSideMenu searchResultSideMenu;
    private List<WebElement> table;
    private int tableCount;
    private By allTablesSelector = By.cssSelector("div.resultsWrapper div.resultsItem");
    private By visibleTablesSelector = By.cssSelector("div.resultsWrapper div.resultsItem:not(.slds-hide)");


    /**
     * SearchResultsPage constructor.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public SearchResultsPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
        header = new Header(webDriverManager);
        searchResultSideMenu = new SearchResultSideMenu(webDriverManager);
    }

    public void getTableCount() {
        tableCount = webElementAction.getElements(allTablesSelector).size();
    }

    @Override
    protected void waitForPageLoaded() {

    }
}
