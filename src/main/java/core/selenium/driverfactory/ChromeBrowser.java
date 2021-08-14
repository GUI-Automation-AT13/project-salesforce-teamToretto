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
import org.apache.groovy.json.internal.Chr;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Configures a Chrome webDriver.
 */
public class ChromeBrowser implements Browser {

    private ChromeOptions chromeOptions;

    /**
     * Configures Chrome browser's options.
     */
    public void setChromeOptions() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications", "--ignore-certificate-errors",
                "--disable-extensions", "--no-sandbox");
        if (EnvConfig.getInstance().getHeadless().equals("true")) {
            chromeOptions.addArguments("--headless", "--disable-gpu");
        }
    }

    /**
     * Gets the browser's driver.
     *
     * @return the web driver
     */
    @Override
    public WebDriver getWebDriver() {
        WebDriverManager.chromedriver().setup();
        setChromeOptions();
        return new ChromeDriver(chromeOptions);
    }
}
