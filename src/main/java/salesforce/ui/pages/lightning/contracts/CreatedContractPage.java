/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.contracts;

import java.util.HashMap;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;

/**
 * Page Object Model for the salesforce created contract page.
 */
public class CreatedContractPage extends BasePage {

    private By details = By.xpath("(//span[text()='Details'])[last()]");
    private By accountNameTitle = By
            .xpath("(//ul//li//div//span[@title=\"Account Name\"] /following-sibling::div)[last()]");
    private By contractStartDateTitle = By
            .xpath("(//ul//li//div//span[@title=\"Contract Start Date\"] /following-sibling::div)[last()]");
    private By contractEndDateTitle = By
            .xpath("(//ul//li//div//span[@title=\"Contract End Date\"] /following-sibling::div)[last()]");
    private By contractStartDate = By.xpath("(//div[./div[./span[text()='Contract Start Date']]]//span//span)[last()]");
    private static final String BASE_XPATH = "//div[./div[./span[text()='%s']]]";
    private static final HashMap<String, String> XPATH_COMPLEMENTS = new HashMap<>();

    static {
        XPATH_COMPLEMENTS.put("Contract Owner", "//a");
        XPATH_COMPLEMENTS.put("Status", "//span//span");
        XPATH_COMPLEMENTS.put("Account Name", "//a");
        XPATH_COMPLEMENTS.put("Contract End Date", "//span//span");
        XPATH_COMPLEMENTS.put("Customer Signed By", "//a");
        XPATH_COMPLEMENTS.put("Contract Term (months)", "//span//span");
        XPATH_COMPLEMENTS.put("Customer Signed Title", "//span//span");
        XPATH_COMPLEMENTS.put("Owner Expiration Notice", "//span//span");
        XPATH_COMPLEMENTS.put("Customer Signed Date", "//span//span");
        XPATH_COMPLEMENTS.put("Company Signed By", "//button/preceding-sibling::span");
        XPATH_COMPLEMENTS.put("Price Book", "//a");
        XPATH_COMPLEMENTS.put("Company Signed Date", "//button/preceding-sibling::span");
        XPATH_COMPLEMENTS.put("Special Terms", "//span//span");
        XPATH_COMPLEMENTS.put("Description", "//span//span");
    }

    /**
     * Gets the text inside the element.
     *
     * @return the text set on the account name assigned to a contract.
     */
    public CreatedContractPage clickDetails() {
        webElementAction.clickByLocator(details);
        webElementAction.dropDownTillTheEnd();
        return this;
    }

    /**
     * Gets the text inside the element.
     *
     * @param field represents the text to be introduced
     * @return the text set on the field requested contract
     */
    public String getTextByFieldName(final String field) {
        String xpathComplement = XPATH_COMPLEMENTS.get(field);
        String xpath = String.format(BASE_XPATH, field).concat(xpathComplement);
        By xpathLocator = By.xpath(xpath);
        return webElementAction.getTextOfByFieldByLocator(xpathLocator);
    }

    /**
     * Gets the text inside the element.
     *
     * @return the text set on the field requested contract.
     */
    public String contractStartDateText() {
        return webElementAction.getTextOfByFieldByLocator(contractStartDate);
    }

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(accountNameTitle);
    }
}
