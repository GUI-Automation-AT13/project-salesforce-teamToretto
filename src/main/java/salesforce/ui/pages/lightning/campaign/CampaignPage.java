/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.campaign;

import core.selenium.WebDriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.ui.entities.PersonalInformation;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.FeaturesPage;

/**
 * This class is of Campaign Page.
 */
public class CampaignPage extends BasePage implements FeaturesPage {

    protected By createCampaignBtn = By.xpath("//a[@class='forceActionLink'][@role='button']");
    protected String xpathTable = "//a[text()='%s']/../../..//*[contains(.,'%s')][@role='gridcell']";
    protected String fieldWithUniqueName = "Campaign Name";

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public CampaignPage(WebDriverManager webDriverManager) {
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
        return webElementAction.getTextOfElementByField(String.format(xpathTable, fieldUniqueName, nameOfColumnHeader));
    }

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(createCampaignBtn);
    }

    /**
     * Returns a Campaing page form to create.
     *
     * @return a object CreateCampaignPage.
     */
    public CreateCampaignPage clickCreateCampaignBtn() {
        webElementAction.clickByLocator(createCampaignBtn);
        return new CreateCampaignPage(webDriverManager);
    }

    @Override
    public CreateCampaignPage clickNewButton() {
        webElementAction.clickByLocator(createCampaignBtn);
        return new CreateCampaignPage(webDriverManager);
    }

    @Override
    public List<String> getValueTables(Map<String, String> table) {
        return getValues(new ArrayList<String>(table.keySet()), table.get(fieldWithUniqueName));
    }

    @Override
    public List<String> getExpected(Map<String, String> tableFeature, PersonalInformation personalInformation) {
        tableFeature.put("Responses in Campaign", "0");
        return new ArrayList<String>(tableFeature.values());
    }

    /**
     * Gets values of table according the campaign name, this field is unique
     * only select field of table.
     *
     * @param valuesToGet is values to get
     * @param unitName    is value of work type name
     * @return a values of tables
     */
    public List<String> getValues(List<String> valuesToGet, String unitName) {
        Map<String, String> mapNew = new HashMap<>();
        mapNew.put(fieldWithUniqueName, unitName);
        valuesToGet.stream()
                .filter(v -> !v.equals(fieldWithUniqueName))
                .forEach(key -> mapNew.put(key, getValueInTable(unitName, key)));
        mapNew.put("Responses in Campaign", getValueInTable(unitName, "Responses in Campaign"));
        mapNew.put("Owner Alias", getValueInTable(unitName, "Owner Alias"));
        return new ArrayList<String>(mapNew.values());
    }
}
