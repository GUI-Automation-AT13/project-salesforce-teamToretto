/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.classic.contracts;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.ui.pages.classic.ClassicHomePageObjects;

/**
 * Page object model for the salesforce classic contract page.
 */
public class ClassicCreatedContractPage extends BasePage {

    private By accountName = By.cssSelector("div[id*=\"ctrc7_ileinner\"]");
    private By addObjects = By.cssSelector(".allTabsArrow");

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager .
     */
    public ClassicCreatedContractPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(addObjects);
    }

    /**
     * Clicks on the add object button.
     *
     * @return a HomePageObjects.
     */
    public ClassicHomePageObjects clickAddObjects() {
        webElementAction.clickByLocator(addObjects);
        return new ClassicHomePageObjects(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     *
     * @return the text set on the account name assigned to a contract.
     */
    public String getAccountName() {
        return webElementAction.getTextOfByFieldByLocator(accountName);
    }
}
