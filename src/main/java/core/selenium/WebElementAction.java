/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class the common web element actions.
 */
public class WebElementAction {

    /**
     * Waits until a text box is visible and writes a text.
     *
     * @param webElement the web element to be waited.
     */
    public void waitForVisible(final WebElement webElement) {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Sends keys to the given WebElement.
     *
     * @param selector represents a selector
     * @param input    is the data to introduce
     */
    public void setInputField(final By selector, final String input) {
        WebDriverManager.getInstance().getWebDriver().findElement(selector).clear();
        WebDriverManager.getInstance().getWebDriver().findElement(selector).sendKeys(input);
    }

    /**
     * Clicks a webElement.
     *
     * @param webElement is what we want to click.
     */
    public void clickField(final WebElement webElement) {
        waitForVisible(webElement);
        webElement.click();
    }

    /**
     * Clicks a webElement.
     *
     * @param locator is what we want to click.
     */
    public void clickFieldByLocator(final String locator) {
        WebDriverManager.getInstance().getWait()
                .until(ExpectedConditions.elementToBeClickable(By.linkText(locator)));
        WebDriverManager.getInstance().getWebDriver().findElement(By.linkText(locator)).click();
    }

    /**
     * Scrolls to the end of the page.
     */
    public void dropDownTillTheEnd() {
        JavascriptExecutor jse = (JavascriptExecutor) WebDriverManager.getInstance().getWebDriver();
        jse.executeScript("window.scrollBy(0,250)");
    }

    /**
     * Gets the text of a web element.
     *
     * @param field web element to get text.
     * @return web element's text
     */

    public String getTextOfElementByField(final String field) {
        return WebDriverManager.getInstance().getWebDriver().findElement(By.xpath(field)).getText();
    }

    /**
     * Clicks on the given WebElement.
     *
     * @param parametrizedSelector selector represents a parametrized selector
     * @param value                represents the custom value for the parametrized selector
     */
    public void clickOnElement(final String parametrizedSelector, final String value) {
        WebDriverManager.getInstance().getWebDriver().findElement(withParameter(parametrizedSelector, value)).click();
    }

    /**
     * Returns a By selector given a parametrized selector and its value.
     * Distinguishes xpath from css and accepts both.
     *
     * @param parametrizedSelector selector represents a parametrized selector
     * @param value                represents the custom value for the parametrized selector
     * @return By
     */
    private static By withParameter(final String parametrizedSelector, final String value) {
        if (parametrizedSelector.startsWith("//")) {
            return By.xpath(String.format(parametrizedSelector, value));
        } else {
            return By.cssSelector(String.format(parametrizedSelector, value));
        }
    }

    /**
     * Checks if the element is displayed.
     *
     * @param locator represents a selector
     * @return boolean
     */
    public boolean isDisplayed(final By locator) {
        return WebDriverManager.getInstance().getWebDriver().findElement(locator).isDisplayed();
    }

    /**
     * Checks if the element is selected given a parametrized Selector.
     *
     * @param parametrizedSelector selector represents a parametrized selector
     * @param value                represents the custom value for the parametrized selector
     * @return boolean
     */
    public boolean isSelected(final String parametrizedSelector, final String value) {
        return WebDriverManager.getInstance().getWebDriver()
                .findElement(withParameter(parametrizedSelector, value)).isSelected();
    }

    /**
     * Returns a Web Element out of a By selector.
     *
     * @param locator represents a selector
     * @return WebElement
     */
    public WebElement getElement(final By locator) {
        return WebDriverManager.getInstance().getWebDriver().findElement(locator);
    }

    /**
     * Selects a webElement isn't able to click.
     *
     * @param webElement type WebElement object.
     */
    public void selectByAction(final WebElement webElement) {
        Actions builder = new Actions(WebDriverManager.getInstance().getWebDriver());
        Action action = builder.click(webElement).build();
        action.perform();
    }
    //---------------------Methods for By locator--------------------

    /**
     * Selects a webElement isn't able to click.
     *
     * @param locator type WebElement object.
     */
    public void waitForVisibilityOfLocator(final By locator) {
        WebDriverManager.getInstance()
                .getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Selects a webElement isn't able to click.
     *
     * @param locator type WebElement object.
     */
    public void clickByLocator(final By locator) {
        waitForVisibilityOfLocator(locator);
        WebDriverManager.getInstance()
                .getWebDriver().findElement(locator).click();
    }

    /**
     * Gets the text of a web element.
     *
     * @param locator web element to get text.
     * @return web element's text
     */
    public String getTextOfByFieldByLocator(final By locator) {
        waitForVisibilityOfLocator(locator);
        return WebDriverManager.getInstance().getWebDriver().findElement(locator).getText();
    }
}
