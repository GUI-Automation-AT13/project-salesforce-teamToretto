/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.campaign;

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
 * This class is of Campaign Page.
 */
public class CampaignsPage extends BasePage implements FeaturesPage {

    protected By createCampaignBtn = By.xpath("//a[@class='forceActionLink'][@role='button']");
    protected String xpathTable = "//a[text()='%s']/../../..//*[contains(.,'%s')][@role='gridcell']";
    protected String fieldWithUniqueName = "Campaign Name";

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public CampaignsPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets value of cell in table according the name of column header.
     *
     * @param fieldUniqueName is field in arrow with is unique
     * @param nameOfColumnHeader a name of column header on table
     * @return a value of one element of table
     */
    public String getValueInTable(final String fieldUniqueName, final String nameOfColumnHeader) {
        return webDriverActions.getTextByXpathLocator(String.format(xpathTable, fieldUniqueName, nameOfColumnHeader));
    }

    /**
     * Returns a Campaign page form to create.
     *
     * @return a object CreateCampaignPage.
     */
    @Override
    public CampaignPageForm clickNewButton() {
        webDriverActions.clickByLocator(createCampaignBtn);
        return new CampaignPageForm(webDriverManager);
    }

    /**
     * Waits to load new button to create campaign appear.
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(createCampaignBtn);
    }

    /**
     * Gets values of tables.
     *
     * @param table is values to get
     * @return a values of tables
     */
    @Override
    public List<String> getTablesValues(Map<String, String> table) {
        return getValues(new ArrayList<String>(table.keySet()), table.get(fieldWithUniqueName));
    }

    /**
     * Gets values of table according the campaign name, this field is unique
     * only select field of table.
     *
     * @param valuesToGet is values to get
     * @param unitName is value of work type name
     * @return a values of tables
     */
    public List<String> getValues(List<String> valuesToGet, String unitName) {
        Map<String, String> mapNew = new HashMap<>();
        mapNew.put(fieldWithUniqueName, unitName);
        valuesToGet.stream()
                .filter(v -> !v.equals(fieldWithUniqueName))
                .forEach(key -> mapNew.put(key, getValueInTable(unitName, translate(key))));
        mapNew.put("Responses in Campaign", getValueInTable(unitName, translate("Responses in Campaign")));
        mapNew.put("Owner Alias", getValueInTable(unitName, translate("Owner Alias")));
        return new ArrayList<String>(mapNew.values());
    }
}
