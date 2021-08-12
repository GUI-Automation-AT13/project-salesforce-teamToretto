/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.worktype;

import static salesforce.utils.Internalization.translate;

import core.selenium.WebDriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.ui.entities.PersonalInformation;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.FeaturesPage;

/**
 * This class has webElement for work types page.
 */
public class WorkTypesPage extends BasePage implements FeaturesPage {
    protected By newBtn = By.xpath("//a[@class='forceActionLink'][@role='button']");
    protected String xpathTable = "//a[text()='%s']/../../..//*[contains(.,'%s')][@role='gridcell']";
    protected String fieldWithUniqueName = "Work Type Name";

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public WorkTypesPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets value of cell in table according the name of column header (Estimated Duration and Duration Type)
     * and the unique Work Type Name.
     *
     * @param fieldUniqueName is field in arrow with is unique
     * @param nameOfColumnHeader a name of column header on table
     * @return a value of one element of table
     */
    public String getValueInTable(final String fieldUniqueName, final String nameOfColumnHeader) {
        return webDriverActions.getTextByXpathLocator(String.format(xpathTable, fieldUniqueName, nameOfColumnHeader));
    }

    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(newBtn);
    }

    /**
     * Changes the page to create work type.
     *
     * @return workTypeForm initialize.
     */
    public NewWorkTypePage clickNewButton() {
        webDriverActions.clickByLocator(newBtn);
        return new NewWorkTypePage(webDriverManager);
    }

    @Override
    public List<String> getValueTables(Map<String, String> table) {
        return getValues(new ArrayList<String>(table.keySet()), table.get(fieldWithUniqueName));
    }

    @Override
    public List<String> getExpected(Map<String, String> tableFeature, PersonalInformation personalInformation) {
        return new ArrayList<String>(tableFeature.values());
    }

    /**
     * Gets values of table according the work type name, this field is unique
     * only select field of table.
     *
     * @param valuesToGet is values to get
     * @param unitName    is value of work type name
     * @return a values of tables
     */
    public List<String> getValues(List<String> valuesToGet, String unitName) {
        Map<String, String> mapNew = new HashMap<>();
        mapNew.put(fieldWithUniqueName, unitName);
        valuesToGet.stream()
                .filter(v -> !v.equals(fieldWithUniqueName))
                .forEach(key -> mapNew.put(key, getValueInTable(unitName, translate(key))));
        return new ArrayList<String>(mapNew.values());
    }
}
