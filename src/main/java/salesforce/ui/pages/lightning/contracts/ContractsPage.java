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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.FeaturesPage;

/**
 * Page Object Model for the salesforce contracts page.
 */
public class ContractsPage extends BasePage implements FeaturesPage {

    private By newContractButton = By.xpath("//a[@class='forceActionLink'][@role='button']");
    private String xpathTable = "(//span[@class='slds-grid slds-grid--align-spread'])[1]/../.."
            + "//*[contains(.,'%s')][@role='gridcell']";

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public ContractsPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets value of cell in table according the name of column header (Account Name,  Contract Term (months),
     * Contract Start Date, Status and Contract End Date).
     *
     * @param nameOfColumnHeader a name of column header on table
     * @return a value of one element of table
     */
    public String getValueInTable(final String nameOfColumnHeader) {
        return webDriverActions.getTextByXpathLocator(String.format(xpathTable, nameOfColumnHeader));
    }

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(newContractButton);
    }

    /**
     * Logs in successfully.
     *
     * @return a ProductPage instance
     */
    @Override
    public ContractPageForm clickNewButton() {
        webDriverActions.clickByLocator(newContractButton);
        return new ContractPageForm(webDriverManager);
    }

    /**
     * Gets values of tables.
     *
     * @param table is values to get
     * @return a values of tables
     */
    @Override
    public List<String> getTablesValues(Map<String, String> table) {
        return getValues(new ArrayList<String>(table.keySet()));
    }

    /**
     * Gets values of table according the first element on the table,
     * only select field of table.
     *
     * @param valuesToGet is values to get
     * @return a values of tables
     */
    public List<String> getValues(List<String> valuesToGet) {
        Map<String, String> mapNew = new HashMap<>();
        valuesToGet.stream()
                .forEach(key -> mapNew.put(key, getValueInTable(translate(key))));
        mapNew.put("Contract End Date", getValueInTable(translate("Contract End Date")));
        return new ArrayList<String>(mapNew.values());
    }
}
