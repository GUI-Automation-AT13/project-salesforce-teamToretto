/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.tables;

import core.selenium.WebDriverManager;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.log4testng.Logger;
import salesforce.ui.pages.BasePage;

/**
 * Represents a table group result from a Search operation in the Salesforce header.
 */
public class TableGroup extends BasePage {

    private Logger logger = Logger.getLogger(getClass());
    private By tablesLocator = By.cssSelector("div.resultsWrapper table");
    private By getAllValidTableContainersSelector = By
            .cssSelector("div.resultsWrapper div.resultsItem:not(.slds-hide)");
    private static final String getAllTableContainersSelector = "div.resultsWrapper div.resultsItem";
    private static final String getValidTableContainerSelector = "div.resultsWrapper "
            + "div.resultsItem:nth-child(%d):not(.slds-hide)";
    private static final String titleNameLocator = " h2 a";
    private List<Table> tables;

    /**
     * TableGroup constructor given a base locator for the table group container.
     *
     * @param webDriverManager used to pass the instance to the created tables
     */
    public TableGroup(final WebDriverManager webDriverManager) {
        super(webDriverManager);
        waitForPageLoaded();
        this.tables = new ArrayList<>();
        loadTables();
    }

    /**
     * Loads the table list.
     */
    public void loadTables() {
        waitForPageLoaded();
        webDriverManager.setTableWaitMode();
        boolean thereAreResults = thereAreResults();
        webDriverManager.setDefaultWaitMode();
        if (thereAreResults) {
            int totalTables = getTablesWithHidenOnes();
            for (int i = 1; i <= totalTables; i++) {
                webDriverManager.setTableWaitMode();
                boolean validElement = validElement(i);
                webDriverManager.setDefaultWaitMode();
                if (validElement) {
                    String baseLocator = getValidTableContainerSelector.replaceAll("%d", String.valueOf(i));
                    String featureName = webDriverActions.getElement(String.format(getValidTableContainerSelector, i)
                            .concat(titleNameLocator)).getText();
                    tables.add(new Table(webDriverManager, baseLocator, featureName));
                }
            }
        }
    }

    /**
     * Returns all records from all tables.
     */
    public List<Record> getEachTableRecords() {
        List<Record> records = new ArrayList<>();
        if (!tables.isEmpty()) {
            tables.stream().forEach(table -> records.addAll(table.getRecords()));
        }
        return records;
    }

    private int getTablesWithHidenOnes() {
        return webDriverActions.getElements(getAllTableContainersSelector).size();
    }

    private boolean validElement(final int i) {
        try {
            WebElement webElement = webDriverActions.getElement(String.format(getValidTableContainerSelector, i));
            if (webElement != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns a Table with title matching the name.
     *
     * @param name represents the  table title name
     * @return a Table
     */
    public Table getTableFromName(final String name) {
        return tables.stream().filter(c -> name.equals(c.getName())).findFirst().get();
    }

    /**
     * Returns a list with all the values for the specified column in the tables.
     *
     * @param columnName represents a column from the tables
     * @return a List
     */
    public List<String> getTableValuesByColumnName(final String columnName) {
        List<String> columnValues = new ArrayList<>();
        tables.stream().forEach(table -> columnValues.addAll(table.getColumnValuesByColumnName(columnName)));
        return columnValues;
    }

    /**
     * Checks if there are table results.
     *
     * @return a boolean
     */
    public boolean thereAreResults() {
        try {
            webDriverActions.getElements(getAllValidTableContainersSelector);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns the tables.
     *
     * @return a List
     */
    public List<Table> getTables() {
        return tables;
    }

    @Override
    protected void waitForPageLoaded() {
        try {
            webDriverManager.getWait().until(ExpectedConditions
                    .presenceOfAllElementsLocatedBy(getAllValidTableContainersSelector));
        } catch (Exception e) {
            throw new InvalidArgumentException(String.format("No valid results were found"));
        }
    }
}
