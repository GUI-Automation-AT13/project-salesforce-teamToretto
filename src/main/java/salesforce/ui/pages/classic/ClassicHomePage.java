/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.classic;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.BasePage;

/**
 * Initializes the Web elements.
 */
public class ClassicHomePage extends BasePage {

    @FindBy(css = ".allTabsArrow")
    private WebElement addObject;

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager .
     */
    public ClassicHomePage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisible(addObject);
    }

    /**
     * Clicks the addObject button.
     *
     * @return a HomePageObjects.
     */
    public ClassicHomePageObjects clickAddObject() {
        addObject.click();
        return new ClassicHomePageObjects(webDriverManager);
    }
}
