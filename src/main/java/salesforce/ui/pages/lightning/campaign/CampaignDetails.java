package salesforce.ui.pages.lightning.campaign;

import core.selenium.WebDriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.utils.strategy.FeatureDetails;
import salesforce.utils.supplier.StringSupplier;

/**
 * This class for elements of Campaign details page created.
 */
public class CampaignDetails extends CampaignCreatedPage implements FeatureDetails {
    private static final String BASE_XPATH = "//div[./div[./span[text()='%s']]]";
    private static final HashMap<String, String> XPATH_COMPLEMENTS = new HashMap<>();

    static {
        XPATH_COMPLEMENTS.put("Campaign Name", "//span//span");
        XPATH_COMPLEMENTS.put("Start Date", "//span//span");
        XPATH_COMPLEMENTS.put("End Date", "//span//span");
        XPATH_COMPLEMENTS.put("Expected Revenue in Campaign", "//span//span");
        XPATH_COMPLEMENTS.put("Budgeted Cost in Campaign", "//span//span");
        XPATH_COMPLEMENTS.put("Actual Cost in Campaign", "//span//span");
        XPATH_COMPLEMENTS.put("Num Sent in Campaign", "//span//span");
        XPATH_COMPLEMENTS.put("Description", "//span//span");
    }

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public CampaignDetails(WebDriverManager webDriverManager) {
        super(webDriverManager);
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
        return webDriverActions.getTextOfByFieldByLocator(xpathLocator);
    }

    /**
     * Gets a date when workType is created.
     *
     * @return a String to date
     */
    @Override
    public String getCreateDayTxt() {
        return webDriverActions.getTextOfByFieldByLocator(dateCreateByTxt);
    }

    @Override
    public List<String> getValueField(Map<String, String> table) {
        List<String> result = new ArrayList<>();
        HashMap<String, StringSupplier> actionsCampaignMap = getTxtFields();
        table.keySet().forEach(key -> result.add(actionsCampaignMap.get(key).getAsString()));
        return result;
    }

    /**
     * Gets text fields of workType.
     *
     * @return a map with methods of CreatedWorkType
     */
    private HashMap<String, StringSupplier> getTxtFields() {
        HashMap<String, StringSupplier> mapValues = new HashMap<>();
        mapValues.put("Campaign Name", () -> getTextByFieldName("Campaign Name"));
        mapValues.put("Start Date", () -> getTextByFieldName("Start Date"));
        mapValues.put("End Date", () -> getTextByFieldName("End Date"));
        mapValues.put("Expected Revenue in Campaign", () -> getTextByFieldName("Expected Revenue in Campaign"));
        mapValues.put("Budgeted Cost in Campaign", () -> getTextByFieldName("Budgeted Cost in Campaign"));
        mapValues.put("Actual Cost in Campaign", () -> getTextByFieldName("Actual Cost in Campaign"));
        mapValues.put("Num Sent in Campaign", () -> getTextByFieldName("Num Sent in Campaign"));
        mapValues.put("Description", () -> getTextByFieldName("Description"));
        return mapValues;
    }

}
