/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.selenium.driverfactory;

import core.config.EnvConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Configures a Fire fox webDriver.
 */
public class FirefoxBrowser implements Browser {

    FirefoxOptions firefoxOptions;

    /**
     * Configures Chrome browser's options.
     */
    public void setFirefoxOptions() {
        firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-web-security");
        firefoxOptions.addArguments("--allow-running-insecure-content");
        if (EnvConfig.getInstance().getHeadless().equals("true")) {
            firefoxOptions.addArguments("--headless");
        }
    }

    /**
     * Gets the browser's driver.
     *
     * @return the web driver
     */
    @Override
    public WebDriver getWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        setFirefoxOptions();
        return new FirefoxDriver(firefoxOptions);
    }
}
