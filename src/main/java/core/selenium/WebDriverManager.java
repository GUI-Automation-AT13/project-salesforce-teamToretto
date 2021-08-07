/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.selenium;

import core.selenium.drivermanager.DriverFactory;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class Manages a Web driver.
 */
public class WebDriverManager {
    private WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();
    private WebDriver webDriver;
    private WebDriverWait wait;

    /**
     * Initializes the web driver configuration configuration.
     */
    public WebDriverManager() {
        initialize();
    }

    /**
     * Returns a webDriver instance.
     *
     * @return a webDriver.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Returns a webDriver wait.
     *
     * @return a web driver wait.
     */
    public WebDriverWait getWait() {
        return wait;
    }

    /**
     * Quit the web driver.
     */
    public void quitWebDriver() {
        webDriver.quit();
    }

    /**
     * Closes the web driver.
     */
    public void closeWebDriver() {
        webDriver.close();
    }

    /**
     * Initializes the webDriverManager configuration.
     */
    private void initialize() {
        this.webDriver = DriverFactory.getDriver(webDriverConfig.getBrowser());
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().deleteAllCookies();
        this.webDriver.manage().timeouts()
                .implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, webDriverConfig.getExplicitWaitTime(),
                webDriverConfig.getWaitSleepTime());
    }

    /**
     * Sets the web driver waits to the minimum to handle datatable elements.
     */
    public void setTableWaitMode() {
        this.webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, 0, 0);
    }

    /**
     * Sets the web driver waits to the property values.
     */
    public void setDefaultWaitMode() {
        this.webDriver.manage().timeouts()
                .implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, webDriverConfig.getExplicitWaitTime(),
                webDriverConfig.getWaitSleepTime());
    }
}
