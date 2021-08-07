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
import java.util.Map;
import org.openqa.selenium.WebElement;
import salesforce.ui.pages.BasePage;

/**
 * Represents a UI table, contains the header name of the table and the table.
 */
public class Table extends BasePage {

    private String featureName;
    private String baseLocator;
    private static final String columnTitleLocator = " thead th[aria-label]";
    private static final String columnNameAttributePartialSelector = " aria-label";
    private static final String titleAttribute = "title";
    private final String rowsSelector = baseLocator.concat(" tbody tr");
    private final String rowSelector = baseLocator.concat(" tbody tr:nth-child(%d)");
    private final String columnSelector = rowSelector.concat(">*:nth-child(%d)");
    private final String nameContainingElementAselector = " a";
    private final String nameContainingElementSpanSelector = " span";
    private final String nameContainingElementSpanInSpanSelector = " span>span:nth-child(1)";
    private int recordNumber;
    private Map<String, Integer> columnTitlesIndex;
    private Map<Integer, String> columnTitles;
    private Map<String, String> record;
    private List<Map<String, String>> records = new ArrayList<>();

    /**
     * BaseElement constructor requires a base CSS locator for the table element and the name of the table.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public Table(final WebDriverManager webDriverManager, final String baseLocator, final String featureName) {
        super(webDriverManager);
        this.baseLocator = baseLocator;
        this.featureName = featureName;
        fillColumnTitles();
        getRecordsNumber();
    }

    /**
     * Gets the titles from the table and maps them with their index for the XML document.
     */
    public void fillColumnTitles() {
        List<WebElement> titleElements = webElementAction.getElements(baseLocator.concat(columnTitleLocator));
        for (int i = 0; i < titleElements.size(); i++) {
            System.out.println("title element : " + titleElements.get(i));
            columnTitlesIndex.put(titleElements.get(i).getAttribute(columnNameAttributePartialSelector), i + 1);
            columnTitles.put(i + 1, titleElements.get(i).getAttribute(columnNameAttributePartialSelector));
        }
    }

    private void getRecordsNumber() {
        this.recordNumber = webElementAction.getElements(baseLocator.concat(rowsSelector)).size();
    }

    /**
     * Gets a record containing the given value.
     *
     * @param columnValue represents the column value
     * @return a Map
     */
    public Map<String, String> getRecordFromGivenColumnValue(final String columnValue) {
        for (int row = 0; row < recordNumber; row++) {
            if (getFieldValue(String.format(columnSelector, row, columnTitlesIndex.get(columnValue))) != null) {
                record = getRecordFromId(row);
            }
        }
        return record;
    }

    /**
     * Returns a record given the row index.
     *
     * @param row represents the row index
     * @return a Map
     */
    public Map<String, String> getRecordFromId(final int row) {
        for (int column = 0; column < columnTitlesIndex.size(); column++) {
            String fieldValue = getFieldValue(String.format(columnSelector, row, column));
            System.out.println(fieldValue);
            if (fieldValue != null) {
                record.put(columnTitles.get(column), fieldValue);
            }
        }
        return record;
    }

    private String getFieldValue(final String locator) {
        String fieldValue = getFieldValueFromText(String.format(locator.concat(nameContainingElementAselector)));
        if (fieldValue != null) {
            return fieldValue;
        }
        fieldValue = getFieldValueFromText(String.format(locator.concat(nameContainingElementSpanInSpanSelector)));
        if (fieldValue != null) {
            return fieldValue;
        }
        fieldValue = getFieldValueFromText(String.format(locator.concat(nameContainingElementSpanSelector)));
        if (fieldValue != null) {
            return fieldValue;
        }
        fieldValue = getFieldValueFromAttribute(locator.concat(nameContainingElementAselector));
        if (fieldValue != null) {
            return fieldValue;
        }
        return null;
    }

    private String getFieldValueFromText(final String locator) {
        return webElementAction.getElement(locator).getText();
    }

    private String getFieldValueFromAttribute(final String locator) {
        return webElementAction.getElement(locator).getAttribute(titleAttribute);
    }

    /**
     * Returns the feature name.
     *
     * @return a String
     */
    public String getName() {
        return featureName;
    }

    @Override
    protected void waitForPageLoaded() {

    }
}
