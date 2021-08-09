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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import salesforce.ui.pages.BasePage;

/**
 * Represents a UI table, contains the header name of the table and the table.
 */
public class Table extends BasePage {

    private String featureName;
    private String baseLocator;
    private static final int nameColumnIndex = 2;
    private static final String columnTitleLocator = " thead th[aria-label]";
    private static final String columnNameAttributePartialSelector = "aria-label";
    private static final String titleAttribute = "title";
    private final String rowsSelector;
    private final String rowSelector;
    private final String columnSelector;
    private final String nameContainingElementAselector = " a";
    private final String nameContainingElementSpanSelector = " span";
    private final String nameContainingElementSpanInSpanSelector = " span>span:nth-child(1)";
    private int recordNumber;
    private Map<String, Integer> columnTitlesIndex;
    private Map<Integer, String> columnTitles;
    private Record record;
    private List<Record> records;

    /**
     * BaseElement constructor requires a base CSS locator for the table element and the name of the table.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public Table(final WebDriverManager webDriverManager, final String baseLocator, final String featureName) {
        super(webDriverManager);
        this.baseLocator = baseLocator;
        this.featureName = featureName;
        columnTitlesIndex = new HashMap<String, Integer>();
        columnTitles = new HashMap<Integer, String>();
        records = new ArrayList<>();
        rowsSelector = baseLocator.concat(" tbody tr");
        rowSelector = baseLocator.concat(" tbody tr:nth-child(%d)");
        columnSelector = rowSelector.concat(">*:nth-child(%d)");
        refreshTable();
    }

    /**
     * Loads column titles and records count.
     */
    public void refreshTable() {
        fillColumnTitles();
        getRecordsNumber();
        records = new ArrayList<>();
    }

    /**
     * Gets the titles from the table and maps them with their index for the XML document.
     */
    private void fillColumnTitles() {
        List<WebElement> titleElements = webElementAction.getElements(baseLocator.concat(columnTitleLocator));
        for (int i = 0; i < titleElements.size(); i++) {
            columnTitlesIndex.put(titleElements.get(i).getAttribute(columnNameAttributePartialSelector), i + 1);
            columnTitles.put(i + 1, titleElements.get(i).getAttribute(columnNameAttributePartialSelector));
        }
        System.out.print("\n");
    }

    /**
     * Sets the number of record results.
     */
    private void getRecordsNumber() {
        this.recordNumber = webElementAction.getElements(rowsSelector).size();
    }

    /**
     * Gets a record containing the given value.
     *
     * @param fieldValue represents the column value
     * @return a Record
     */
    public Record getRecordByValueForColumn(final String fieldValue, final String columnName) {
        return getRecordByValue(fieldValue, columnTitlesIndex.get(columnName));
    }

    /**
     * Gets a record containing the given value.
     *
     * @return a Record
     */
    public Record getRecordByName(final String nameValue) {
        return getRecordByValue(nameValue, nameColumnIndex);
    }

    /**
     * Gets a record containing the given value.
     *
     * @return a Record
     */
    private Record getRecordByValue(final String fieldValue, final int columnIndex) {
        for (int row = 1; row <= recordNumber; row++) {
            String fieldValueFound = getFieldValue(String.format(columnSelector, row, columnIndex));
            if (fieldValueFound != null && fieldValueFound.equals(fieldValue)) {
                return getRecordById(row);
            }
        }
        throw new NoSuchElementException(String.format("Element for value:s%s, not found", fieldValue));
    }

    /**
     * Retrns a list with all records in the table.
     *
     * @return a List
     */
    public List<Record> getRecords() {
        if (records.isEmpty()) {
            for (int i = 1; i <= recordNumber; i++) {
                records.add(getRecordById(i));
            }
        }
        return records;
    }

    /**
     * Gets the given column name values.
     *
     * @param columnName represents a column name
     * @return a List
     */
    public List<String> getColumnValuesByColumnName(final String columnName) {
        List<String> columnValues = new ArrayList<>();
        for (int row = 1; row <= recordNumber; row++) {
            webDriverManager.setTableWaitMode();
            String fieldValue = getFieldValue(String.format(columnSelector, row, columnTitles.get(columnName)));
            webDriverManager.setDefaultWaitMode();
            if (fieldValue != null) {
                columnValues.add(fieldValue);
            }
        }
        return columnValues;
    }

    /**
     * Returns a record given the row index.
     *
     * @param row represents the row index
     * @return a Map
     */
    private Record getRecordById(final int row) {
        record = new Record();
        for (int column = 1; column <= columnTitlesIndex.size(); column++) {
            webDriverManager.setTableWaitMode();
            String fieldValue = getFieldValue(String.format(columnSelector, row, column));
            webDriverManager.setDefaultWaitMode();
            if (fieldValue != null) {
                record.set(columnTitles.get(column), fieldValue);
            }
        }
        return record;
    }

    /**
     * Returns the text from an element if the element contains a text.
     *
     * @param locator represents the locator for the row and column
     * @return a String representing the table field value
     */
    private String getFieldValue(final String locator) {
        String fieldValue = webElementAction.getTextIfElementExists(String.format(locator
                .concat(nameContainingElementAselector)));
        if (fieldValue != null) {
            return fieldValue;
        }
        fieldValue = webElementAction.getTextIfElementExists(String.format(locator
                .concat(nameContainingElementSpanInSpanSelector)));
        if (fieldValue != null) {
            return fieldValue;
        }
        fieldValue = webElementAction.getTextIfElementExists(String.format(locator
                .concat(nameContainingElementSpanSelector)));
        if (fieldValue != null) {
            return fieldValue;
        }
        fieldValue = webElementAction.getAttributeIfElementExists(locator
                .concat(nameContainingElementAselector), titleAttribute);
        if (fieldValue != null) {
            return fieldValue;
        }
        return null;
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
