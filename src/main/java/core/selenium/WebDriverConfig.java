/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package core.selenium;

import core.utils.PropertiesReader;
import java.util.Properties;

/**
 * This class specifies the web driver config.
 */
public class WebDriverConfig {
    private String browser;
    private int implicitWaitTime;
    private int explicitWaitTime;
    private int waitSleepTime;
    private static WebDriverConfig instance;

    /**
     * Initializes the configuration.
     */
    public WebDriverConfig() {
        initialize();
    }

    /**
     * Returns a new instance.
     *
     * @return a web driver config object.
     */
    public static WebDriverConfig getInstance() {
        if (instance == null) {
            instance = new WebDriverConfig();
        }
        return instance;
    }
    /**
     * Sets all the values to be configured.
     */
    public void initialize() {
        Properties properties = PropertiesReader.getProperties("config.properties");
        browser = properties.getProperty("browser");
        implicitWaitTime = Integer.parseInt(properties.getProperty("implicitTime"));
        explicitWaitTime = Integer.parseInt(properties.getProperty("explicitTime"));
        waitSleepTime = Integer.parseInt(properties.getProperty("sleepTime"));
    }

    /**
     * Returns the type of browser.
     *
     * @return the browser.
     */
    public String getBrowser() {
        return browser;
    }
    /**
     * Returns the implicitWaitTime.
     *
     * @return the implicitWaitTime.
     */
    public int getImplicitWaitTime() {
        return implicitWaitTime;
    }
    /**
     * Returns the explicitWaitTime.
     *
     * @return the explicitWaitTime.
     */
    public int getExplicitWaitTime() {
        return explicitWaitTime;
    }
    /**
     * Returns the waitSleepTime.
     *
     * @return the waitSleepTime.
     */
    public int getWaitSleepTime() {
        return waitSleepTime;
    }

}
