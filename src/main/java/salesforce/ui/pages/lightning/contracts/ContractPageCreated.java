/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.contracts;

import static salesforce.utils.Internalization.translate;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.FeatureCreated;

/**
 * Page Object Model for the salesforce created contract page.
 */
public class ContractPageCreated extends BasePage implements FeatureCreated {

    private By details = By.xpath(String.format("(//span[text()='%s'])[last()]", translate("Details")));
    private By accountNameTitle = By.xpath(String.format("(//ul//li//div//span[@title='%s'] "
            + "/following-sibling::div)[last()]", translate("Account Name")));
    private By contractStartDateTitle = By.xpath(String.format("(//ul//li//div//span[@title='%s'] "
            + "/following-sibling::div)[last()]", translate("Contract Start Date")));
    private By contractEndDateTitle = By.xpath(String.format("(//ul//li//div//span[@title='%s'] "
            + "/following-sibling::div)[last()]", translate("Contract Start Date")));
    private By statusTitle = By.xpath(String.format("(//ul//li//div//span[@title='%s'] "
            + "/following-sibling::div)[last()]", translate("Status")));

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public ContractPageCreated(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets the text on the Status Tittle.
     */
    public String getStatusTxt() {
        return webDriverActions.getTextOfByFieldByLocator(statusTitle);
    }

    /**
     * Clicks details menu tabs.
     *
     * @return a ContractDetails object.
     */
    @Override
    public ContractDetails clickDetails() {
        webDriverActions.clickByLocator(details);
        webDriverActions.scrollToBottom();
        return new ContractDetails(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(accountNameTitle);
    }

}
