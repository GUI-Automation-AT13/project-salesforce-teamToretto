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
import salesforce.ui.pages.classic.contracts.ClassicContractsPage;

/**
 * Page object model for the classic salesforce home page.
 */
public class ClassicHomePageObjects extends BasePage {

    @FindBy(css = ".listRelatedObject.contractBlock.title")
    private WebElement contractBtn;

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public ClassicHomePageObjects(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisible(contractBtn);
    }

    /**
     * Clicks on the add object button.
     *
     * @return a new ContractsPage
     */
    public ClassicContractsPage clickAddObject() {
        contractBtn.click();
        return new ClassicContractsPage(webDriverManager);
    }
}
