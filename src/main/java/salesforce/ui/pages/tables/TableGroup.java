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
import org.testng.log4testng.Logger;
import salesforce.ui.pages.BasePage;

/**
 * Represents a table group result from a Search operation in the Salesforce header.
 */
public class TableGroup extends BasePage {

    private Logger logger = Logger.getLogger(getClass());
    private String getAllTableContainersSelector = "div.resultsWrapper div.resultsItem";
    private String getValidTableContainerSelector = "div.resultsWrapper div.resultsItem:nth-child(%d):not(.slds-hide)";
    private String titleNameLocator = " h2 a";
    private String tableLocator = " table";
    private List<Table> tables;

    /**
     * TableGroup constructor given a base locator for the table group container.
     *
     * @param webDriverManager used to pass the instance to the created tables
     */
    public TableGroup(final WebDriverManager webDriverManager) {
        super(webDriverManager);
        this.tables = new ArrayList<>();
        loadTables();
    }

    /**
     * Loads the table list.
     */
    public void loadTables() {
        int totalTables = getTablesWithHidenOnes();
        for (int i = 0; i < totalTables; i++) {
            if (validElement(i)) {
                String baseLocator = getValidTableContainerSelector.replaceAll("%d", String.valueOf(i));
                tables.add(new Table(webDriverManager, baseLocator, titleNameLocator));
            }
        }
    }

    private int getTablesWithHidenOnes() {
        return webElementAction.getElements(getAllTableContainersSelector).size();
    }

    private boolean validElement(final int i) {
        try {
            if (webElementAction.getElement(String.format(getValidTableContainerSelector, i)) != null) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Element not found: " + e);
        }
        return false;
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

    @Override
    protected void waitForPageLoaded() {

    }
}
