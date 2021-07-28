/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package core.selenium;

import core.drivermanager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

/**
 * This class Manages a Web driver.
 */
public class WebDriverManager {
    private WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();
    private WebDriver webDriver;
    private WebDriverWait wait;
    private static WebDriverManager instance = null;

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
     * Returns a webDriverManager instance.
     *
     * @return a webDriverManager.
     */
    public static WebDriverManager getInstance() {
        if (instance == null || instance.webDriver == null) {
            instance = new WebDriverManager();
        }
        return instance;
    }
    /**
     * Initializes the webDriverManager configuration.
     */
    private void initialize() {
        this.webDriver = DriverFactory.getDriver(webDriverConfig.getBrowser());
        this.webDriver.manage().timeouts()
                .implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, webDriverConfig.getExplicitWaitTime(),
                webDriverConfig.getWaitSleepTime());
    }
}
