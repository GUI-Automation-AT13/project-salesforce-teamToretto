/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.contracts;

import static salesforce.utils.Internalization.translate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.CreatedFeature;
import salesforce.utils.supplier.StringSupplier;

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
    private By contractStartDate = By.xpath("(//div[./div[./span[text()='"
            + translate("Contract Start Date") + "']]]//span//span)[last()]");
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
        String xpath = String.format(BASE_XPATH, translate(field)).concat(xpathComplement);
        By xpathLocator = By.xpath(xpath);
        return webElementAction.getTextOfByFieldByLocator(xpathLocator);
    }

    /**
     * Gets the text inside the element.
     *
     * @return the text set on the field requested contract.
     */
    public String getContractStartDateText() {
        return webElementAction.getTextOfByFieldByLocator(contractStartDate);
    }

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(accountNameTitle);
    }

    @Override
    public List<String> getValueField(Map<String, String> table) {
        List<String> result = new ArrayList<>();
        HashMap<String, StringSupplier> actionsCreatedMap = getTxtFields();
        table.keySet().forEach(key -> result.add(actionsCreatedMap.get(key).getAsString()));
        return result;
    }

    /**
     * Gets text fields of workType.
     *
     * @return a map with methods of CreatedWorkType
     */
    private HashMap<String, StringSupplier> getTxtFields() {
        webElementAction.clickByLocator(details);
        webElementAction.dropDownTillTheEnd();
        HashMap<String, StringSupplier> mapValues = new HashMap<>();
        mapValues.put("Account Name", () -> getTextByFieldName("Account Name"));
        mapValues.put("Contract Term (months)", () -> getTextByFieldName("Contract Term (months)"));
        mapValues.put("Contract Start Date", this::getContractStartDateText);
        mapValues.put("Customer Signed By", () -> getTextByFieldName("Customer Signed By"));
        mapValues.put("Customer Signed Title", () -> getTextByFieldName("Customer Signed Title"));
        mapValues.put("Customer Signed Date", () -> getTextByFieldName("Customer Signed Date"));
        mapValues.put("Price Book", () -> getTextByFieldName("Price Book"));
        mapValues.put("Owner Expiration Notice", () -> getTextByFieldName("Owner Expiration Notice"));
        mapValues.put("Company Signed Date", () -> getTextByFieldName("Company Signed Date"));
        mapValues.put("Special Terms", () -> getTextByFieldName("Special Terms"));
        mapValues.put("Description", () -> getTextByFieldName("Description"));
        return mapValues;
    }
}
