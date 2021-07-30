/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.individuals;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * Page Object Model for the salesforce individual list page.
 */
public class IndividualListPage extends BasePage {

    private By recentlyViewedSpan = By.cssSelector("span.triggerLinkText");
    private By deletedSuccessMessage = By.xpath("//span[contains(.,\"was deleted.\")]");
    private By firstRowDropDownMenu = By.xpath("//tbody/tr[1]//span/span[contains"
            + "(.,\"Show Actions\")]/preceding-sibling::span");
    private By firstRowDropDownMenuUpdated = By.xpath("//tbody/tr[1]//a[@title="
            + "\"Show 2 more actions\"]/ancestor::div[@id and @data-interactive-uid]");
    private WebElement dropDownMenu;
    private By deleteButtonDropDownMenu = By.xpath("//span[contains(text(),\"Delete\")]");

    /**
     * Checks if the view list span is visible.
     *
     * @return boolean
     */
    public boolean recentlyViewedSpanVisible() {
        return webElementAction.isDisplayed(recentlyViewedSpan);
    }

    /**
     * Deletes the last created or modified record.
     */
    public void deleteLastModifiedRecord() {
        webElementAction.clickByLocator(firstRowDropDownMenu);
        dropDownMenu = webElementAction.getElement(firstRowDropDownMenuUpdated);
        clickOnArecordDropDownMenuDelete();
    }

    /**
     * Returns an alert message.
     *
     * @return String
     */
    public String getDeletedSuccessMessage() {
        return webElementAction.getTextOfByFieldByLocator(deletedSuccessMessage);
    }

    /**
     * Clicks on a record from the list of Individual records given the name.
     *
     * @param name represents a record name
     */
    public void clickOnRecordByName(final String name) {
        webElementAction.clickByLocator(By.cssSelector("[title=\"" + name + "\"]"));
    }

    /**
     * Search for a record given the name.
     *
     * @param name represents a record name
     * @return boolean
     */
    public boolean isThereRecordWithName(final String name) {
        return webElementAction.getElement(By.cssSelector("[title=\"" + name + "\"]")).equals(name);
    }

    /**
     * Clicks on options Drop down menu options given the name of record.
     *
     * @param name represent a record name
     */
    public void clickOnArecordDropDownMenuOption(final String name) {
        webElementAction.clickByLocator(By.xpath("//a[@title=\"" + name + "\"]/ancestor::tr//"
                + "span/span[contains(.,\"Show Actions\")]/preceding-sibling::span\""));
        webElementAction.clickByLocator(By.xpath("//a[@title=\"" + name + "\"]/ancestor::tr//a[@title="
                + "\"Show 2 more actions\"]/ancestor::div[@id and @data-interactive-uid]"));
    }

    /**
     * Click on a record Drop down menu Edit.
     */
    public void clickOnArecordDropDownMenuEdit() {
        webElementAction.clickByLocator(By.cssSelector("div[aria-labelledby=\""
                + dropDownMenu.getAttribute("id") + "\"] a[title=\"Edit\"]"));
    }

    /**
     * Click on a record Drop down menu Delete.
     */
    public void clickOnArecordDropDownMenuDelete() {
        webElementAction.clickByLocator(By.cssSelector("div[aria-labelledby="
                + "\"" + dropDownMenu.getAttribute("id") + "\"] a[title=\"Delete\"]"));
        webElementAction.clickByLocator(deleteButtonDropDownMenu);
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageLoaded() {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.presenceOfElementLocated(recentlyViewedSpan));
    }
}
