/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.individuals;

import static salesforce.utils.Internalization.translate;

import core.selenium.WebDriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import salesforce.ui.entities.PersonalInformation;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.FeatureNew;
import salesforce.utils.strategy.FeaturesPage;

/**
 * Page Object Model for the salesforce individual list page.
 */
public class IndividualListPage extends BasePage implements FeaturesPage {

    private By recentlyViewedSpan = By.cssSelector("span.triggerLinkText");
    private By deletedSuccessMessage = By.xpath("//span[contains(.,\"was deleted.\")]");
    private By firstRowDropDownMenu = By.xpath(String.format("//tbody/tr[1]//span/span[contains"
            + "(.,'%s')]/preceding-sibling::span", translate("Show Actions")));
    private By firstRowDropDownMenuUpdated = By.xpath(String.format("//tbody/tr[1]//a[@title="
            + "'%s']/ancestor::div[@id and @data-interactive-uid]", translate("Show 2 more actions")));
    private WebElement dropDownMenu;
    private By deleteButtonDropDownMenu = By.xpath(String.format("//span[contains(text(),'%s')]",
            translate("Delete")));
    private By newButton = By.xpath(String.format("//div[@title='%s']", translate("New")));
    private String fieldWithUniqueName = "lastname";
    private String xpathTable = "//*[contains(text(),'%s')]/../../..//*[contains(.,'%s')][@role='gridcell']";

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public IndividualListPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Checks if the view list span is visible.
     *
     * @return boolean
     */
    public boolean recentlyViewedSpanVisible() {
        return webDriverActions.isDisplayed(recentlyViewedSpan);
    }

    /**
     * Deletes the last created or modified record.
     */
    public void deleteLastModifiedRecord() {
        webDriverActions.clickByLocator(firstRowDropDownMenu);
        dropDownMenu = webDriverActions.getElement(firstRowDropDownMenuUpdated);
        clickOnArecordDropDownMenuDelete();
    }

    /**
     * Returns an alert message.
     *
     * @return String
     */
    public String getDeletedSuccessMessage() {
        return webDriverActions.getTextOfByFieldByLocator(deletedSuccessMessage);
    }

    /**
     * Clicks on a record from the list of Individual records given the name.
     *
     * @param name represents a record name
     */
    public void clickOnRecordByName(final String name) {
        webDriverActions.clickByLocator(By.cssSelector("[title=\"" + name + "\"]"));
    }

    /**
     * Search for a record given the name.
     *
     * @param name represents a record name
     * @return boolean
     */
    public boolean isThereRecordWithName(final String name) {
        return webDriverActions.getElement(By.cssSelector("[title=\"" + name + "\"]")).getText().equals(name);
    }

    /**
     * Clicks on options Drop down menu options given the name of record.
     *
     * @param name represent a record name
     */
    public void clickOnArecordDropDownMenuOption(final String name) {
        webDriverActions.clickByLocator(By.xpath("//a[@title=\"" + name + "\"]/ancestor::tr//"
                + "span/span[contains(.,\"Show Actions\")]/preceding-sibling::span\""));
        webDriverActions.clickByLocator(By.xpath("//a[@title=\"" + name + "\"]/ancestor::tr//a[@title="
                + "\"Show 2 more actions\"]/ancestor::div[@id and @data-interactive-uid]"));
    }

    /**
     * Click on a record Drop down menu Edit.
     */
    public void clickOnArecordDropDownMenuEdit() {
        webDriverActions.clickByLocator(By.cssSelector("div[aria-labelledby=\""
                + dropDownMenu.getAttribute("id") + "\"] a[title=\"Edit\"]"));
    }

    /**
     * Click on a record Drop down menu Delete.
     */
    public void clickOnArecordDropDownMenuDelete() {
        webDriverActions.clickByLocator(By.cssSelector(String.format("div[aria-labelledby="
                + "\"" + dropDownMenu.getAttribute("id") + "\"] a[title='%s']", translate("Delete"))));
        webDriverActions.clickByLocator(deleteButtonDropDownMenu);
    }

    /**
     * Gets value of cell in table according the name of column header.
     *
     * @param fieldUniqueName is field in arrow with is unique
     * @param nameOfColumnHeader a name of column header on table
     * @return a value of one element of table
     */
    public String getValueInTable(final String fieldUniqueName, final String nameOfColumnHeader) {
        return webElementAction.getTextOfElementByField(String.format(xpathTable, fieldUniqueName, nameOfColumnHeader));
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(recentlyViewedSpan);
    }

    /**
     * Changes the page to create individual.
     *
     * @return individual initialize.
     */
    @Override
    public FeatureNew clickNewButton() {
        webDriverActions.clickByLocator(newButton);
        return new IndividualFormPage(webDriverManager);
    }

    @Override
    public List<String> getValueTables(Map<String, String> table) {
        return getValues(new ArrayList<String>(table.keySet()), table.get(fieldWithUniqueName));
    }

    /**
     * Gets values of table according the name, this field is unique
     * only select field of table.
     *
     * @param valuesToGet is values to get
     * @param unitName    is value of work type name
     * @return a values of tables
     */
    public List<String> getValues(List<String> valuesToGet, String unitName) {
        Map<String, String> mapNew = new HashMap<>();
        mapNew.put(fieldWithUniqueName, unitName);
        mapNew.put("Alias", getValueInTable(unitName, "Alias"));
        mapNew.put("Created By Alias", getValueInTable(unitName, "Created By Alias"));
        mapNew.put("Last Modified By Alias", getValueInTable(unitName, "Last Modified By Alias"));
        mapNew.put("Last Modified Date", getValueInTable(unitName, "Last Modified Date"));
        return new ArrayList<String>(mapNew.values());
    }

    @Override
    public List<String> getExpected(Map<String, String> tableFeature, PersonalInformation personalInformation) {
        return null;
    }
}
