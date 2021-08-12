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

/**
 * Page object model for the salesforce classic contracts page.
 */
public class ClassicContractsPage extends BasePage {

    private By newContractButton = By.cssSelector("input[title='New']");
    private By popup = By.id("tryLexDialogX");

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager .
     */
    public ClassicContractsPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(newContractButton);
    }

    /**
     * Closes a popup.
     */
    public void clickPopUp() {
        webDriverActions.waitForVisibilityOfLocator(popup);
        webDriverActions.clickByLocator(popup);
    }

    /**
     * Clicks on a new contract button.
     *
     * @return a new NewContractPage
     */
    public ClassicNewContractPage clickNew() {
        webDriverActions.clickByLocator(newContractButton);
        return new ClassicNewContractPage(webDriverManager);
    }

}
