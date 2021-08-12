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
import salesforce.utils.strategy.CreatedFeature;

/**
 * Page Object Model for the salesforce created contract page.
 */
public class CreatedContractPage extends BasePage implements CreatedFeature {

    private By details = By.xpath("(//span[text()='"
            + translate("Details") + "'])[last()]");
    private By accountNameTitle = By
            .xpath("(//ul//li//div//span[@title=\""
                    + translate("Account Name") + "\"] /following-sibling::div)[last()]");
    private By contractStartDateTitle = By
            .xpath("(//ul//li//div//span[@title=\""
                    + translate("Contract Start Date") + "\"] /following-sibling::div)[last()]");
    private By contractEndDateTitle = By
            .xpath("(//ul//li//div//span[@title=\"Contract End Date\"] /following-sibling::div)[last()]");
    private By statusTitle = By
            .xpath("(//ul//li//div//span[@title=\""
                    + translate("Status") + "\"] /following-sibling::div)[last()]");

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public CreatedContractPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets the text on the Status Tittle.
     */
    public String getStatusTxt() {
        return webDriverActions.getTextOfByFieldByLocator(statusTitle);
    }

    /**
     * Gets the text inside the element.
     *
     * @return the text set on the account name assigned to a contract.
     */
    @Override
    public ContractsDetails clickDetails() {
        webDriverActions.clickByLocator(details);
        webDriverActions.scrollToBottom();
        return new ContractsDetails(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(accountNameTitle);
    }

}
