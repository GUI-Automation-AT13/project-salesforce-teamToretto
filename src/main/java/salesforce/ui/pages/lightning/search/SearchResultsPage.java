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
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;
import salesforce.ui.pages.lightning.Header;
import salesforce.ui.pages.tables.Record;
import salesforce.ui.pages.tables.Table;
import salesforce.ui.pages.tables.TableGroup;

/**
 * POM for the Salesforce search result page.
 */
public class SearchResultsPage extends BasePage {

    private Header header;
    private SearchResultSideMenu searchResultSideMenu;
    private TableGroup tableGroup;
    private int tableCount;
    private By tablesLocator = By.cssSelector("div.resultsWrapper table");
    private By searchBox = By.cssSelector("input[title]");
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

    private void getTableCount() {
        tableCount = webElementAction.getElements(allTablesSelector).size();
    }

    /**
     * Sends the word text to search and press the Enter key.
     *
     * @param textToSearch represents the text to search for
     */
    public void search(final String textToSearch) {
        webElementAction.setInputField(searchBox, textToSearch);
        webElementAction.pressKey(searchBox, Keys.ENTER);
        tableGroup = new TableGroup(webDriverManager);
    }

    /**
     * Sets the text in the search box.
     *
     * @param textToSearch is the text to search for
     */
    public void setTextToSearch(final String textToSearch) {
        webElementAction.setInputField(searchBox, textToSearch);
    }

    /**
     * Sends the Enter key to the search.
     */
    public void pressEnter() {
        webElementAction.pressKey(searchBox, Keys.ENTER);
        tableGroup = new TableGroup(webDriverManager);
    }

    /**
     * Returns all table records.
     *
     * @return a List of the recods
     */
    public List<Record> getRecords() {
        return tableGroup.getEachTableRecords();
    }

    /**
     * Return all the tables.
     *
     * @return a List of the tables
     */
    public List<Table> getTables() {
        return tableGroup.getTables();
    }

    /**
     * Checks if all records contain the given text.
     *
     * @param text is the text that was searched
     */
    public boolean doAllRecordsContainTheText(final String text) {
        List<Record> results = getRecords();
        boolean recordsContainText = true;
        if (!results.isEmpty()) {
            for (Record record : results) {
                if (!record.thereIsValueContainingText(text)) {
                    recordsContainText = false;
                }
            }
        } else {
            recordsContainText = false;
        }
        return recordsContainText;
    }

    @Override
    protected void waitForPageLoaded() {
        webDriverManager.getWait().until(ExpectedConditions.presenceOfElementLocated(tablesLocator));
    }
}