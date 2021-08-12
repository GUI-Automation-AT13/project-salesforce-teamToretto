/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */


package core.selenium.driverfactory;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;

/**
 * This class selects the type of driver.
 */
public final class DriverFactory {

    private DriverFactory() {
    }

    /**
     * Gets the type of driver.
     *
     * @param type to define which type will be returned.
     * @return the driver type.
     */
    public static WebDriver getDriver(final String type) {

        switch (type) {
            case "CHROME":
                return new ChromeBrowser().getWebDriver();
            case "EDGE":
                return new EdgeBrowser().getWebDriver();
            case "FIREFOX":
                return new FirefoxBrowser().getWebDriver();
            default:
                throw new InvalidArgumentException("Unsupported WebDriver");
        }
    }

}