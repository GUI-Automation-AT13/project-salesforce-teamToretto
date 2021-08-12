/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.campaign;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;

/**
 * This class is for menu page.
 */
public class MenuPage extends BasePage {

    private By deleteBtn = By.xpath("//div[@role=\'menu\']//a[./div[@title=\'Delete\']]");

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public MenuPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(deleteBtn);
    }
}
