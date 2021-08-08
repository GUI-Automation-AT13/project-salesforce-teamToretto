/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class the common web element actions.
 */
public class WebElementAction {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverManager webDriverManager;

    /**
     * Selects initializes a wev element action.
     *
     * @param webDriverManager type WebElement object.
     */
    public WebElementAction(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        this.driver = this.webDriverManager.getWebDriver();
        this.wait = this.webDriverManager.getWait();
    }

    /**
     * Waits until a text box is visible and writes a text.
     *
     * @param webElement the web element to be waited.
     */

    public void waitForVisible(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Sends keys to the given WebElement.
     *
     * @param selector represents a selector
     * @param input    is the data to introduce
     */
    public void setInputField(final By selector, final String input) {
        driver.findElement(selector).clear();
        driver.findElement(selector).sendKeys(input);
    }

    /**
     * Clicks a webElement.
     *
     * @param locator is what we want to click.
     */
    public void clickFieldByLocator(final String locator) {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(locator)));
        driver.findElement(By.linkText(locator)).click();
    }

    /**
     * Scrolls to the end of the page.
     */
    public void dropDownTillTheEnd() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
    }

    /**
     * Gets the text of a web element.
     *
     * @param field web element to get text.
     * @return web element's text
     */
    public String getTextOfElementByField(final String field) {
        return driver.findElement(By.xpath(field)).getText();
    }

    /**
     * Clicks on the given WebElement.
     *
     * @param parametrizedSelector selector represents a parametrized selector
     * @param value                represents the custom value for the parametrized selector
     */
    public void clickOnElement(final String parametrizedSelector, final String value) {
        driver.findElement(withParameter(parametrizedSelector, value)).click();
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
     * Returns a By selector given a String.
     *
     * @param locator represents a locator
     * @return By
     */
    public By getByLocatorFromString(final String locator) {
        if (locator.startsWith("//")) {
            return By.xpath(locator);
        } else {
            return By.cssSelector(locator);
        }
    }

    /**
     * Checks if the element is displayed.
     *
     * @param locator represents a selector
     * @return boolean
     */
    public boolean isDisplayed(final By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    /**
     * Checks if the element is selected given a parametrized Selector.
     *
     * @param parametrizedSelector selector represents a parametrized selector
     * @param value                represents the custom value for the parametrized selector
     * @return boolean
     */
    public boolean isSelected(final String parametrizedSelector, final String value) {
        return driver.findElement(withParameter(parametrizedSelector, value)).isSelected();
    }

    /**
     * Returns a Web Element out of a By selector.
     *
     * @param locator represents a selector
     * @return WebElement
     */
    public WebElement getElement(final By locator) {
        return driver.findElement(locator);
    }

    /**
     * Returns a Web Element out of a String selector.
     *
     * @param locator represents a selector
     * @return WebElement
     */
    public WebElement getElement(final String locator) {
        return driver.findElement(getByLocatorFromString(locator));
    }

    /**
     * Selects a webElement isn't able to click.
     *
     * @param locator type WebElement object.
     */
    public void selectByAction(final By locator) {
        Actions builder = new Actions(driver);
        Action action = builder.click(driver.findElement(locator)).build();
        action.perform();
    }

    /**
     * Selects a webElement isn't able to click.
     *
     * @param locator type WebElement object.
     */
    public void waitForVisibilityOfLocator(final By locator) {
        wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
    }

    /**
     * Selects a webElement isn't able to click.
     *
     * @param locator type WebElement object.
     */
    public void clickByLocator(final By locator) {
        waitForVisibilityOfLocator(locator);
        driver.findElement(locator).click();
    }

    /**
     * Gets the text of a web element.
     *
     * @param locator web element to get text.
     * @return web element's text
     */
    public String getTextOfByFieldByLocator(final By locator) {
        waitForVisibilityOfLocator(locator);
        return driver.findElement(locator).getText();
    }

    /**
     * Returns a text if the element from the locator contains a text, otherwise returns null.
     *
     * @param locator represents the locator with the row and column locators
     * @return a String as the text retrieved from the web element.
     */
    public String getTextIfElementExists(final String locator) {
        try {
            return driver.findElement(getByLocatorFromString(locator)).getText();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Returns the text for the passed attribute name in a web element.
     *
     * @param locator represents the locator to the web element
     * @return a String
     */
    public String getAttributeIfElementExists(final String locator, final String attribute) {
        try {
            return getElement(locator).getAttribute(attribute);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Gets the text of a web element.
     *
     * @param field web element to get text.
     */
    public void clickByXpath(final String field) {
        driver.findElement(By.xpath(field)).click();
    }

    /**
     * Gets the text of a web element.
     *
     * @param locator web element to get text
     * @param key     represents the key to press
     */
    public void pressKey(final By locator, Keys key) {
        driver.findElement(locator).sendKeys(key);
    }

    /**
     * Returns a list of elements found from the given locator.
     *
     * @param locator represents the locator
     * @return a List of web elements
     */
    public List<WebElement> getElements(final By locator) {
        return driver.findElements(locator);
    }

    /**
     * Returns a list of elements found from the given locator.
     *
     * @param locator represents the locator
     * @return a List of web elements
     */
    public List<WebElement> getElements(final String locator) {
        return driver.findElements(getByLocatorFromString(locator));
    }
}
