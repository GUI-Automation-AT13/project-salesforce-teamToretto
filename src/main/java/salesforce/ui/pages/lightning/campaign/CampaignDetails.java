package salesforce.ui.pages.lightning.campaign;

import static salesforce.utils.Internalization.translate;

import core.selenium.WebDriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.utils.strategy.FeatureDetails;
import salesforce.utils.supplier.StringSupplier;

/**
 * This class for elements of Campaign details page.
 */
public class CampaignDetails extends CampaignPageCreated implements FeatureDetails {
    private static final String BASE_XPATH = "//div[./div[./span[text()='%s']]]";
    private static final HashMap<String, String> XPATH_COMPLEMENTS = new HashMap<>();
    private By createBy = By.xpath(String.format("//span[text()='%s']/../../div/span/span",
            translate("Created By")));
    protected By dateCreateByTxt = By.xpath(String.format("//*[contains(text(),'%s')]/../.."
            + "//*[@class='uiOutputDateTime forceOutputModStampWithPreview']", translate("Created By")));

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
     * Gets the text inside the element of Campaign Name, Start Date, End Date, Expected Revenue in Campaign,
     * Budgeted Cost in Campaign, Actual Cost in Campaign, Num Sent in Campaign and Description.
     *
     * @param field represents the text to be introduced
     * @return the text set on the field requested contract
     */
    public String getTextByFieldName(final String field) {
        String xpathComplement = XPATH_COMPLEMENTS.get(field);
        String xpath = String.format(BASE_XPATH, translate(field)).concat(xpathComplement);
        return webDriverActions.getTextOfByFieldByLocator(By.xpath(xpath));
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

    /**
     * Returns created by.
     *
     * @return text of elements created by.
     */
    public String getCreatedByText() {
        return webDriverActions.getTextOfByFieldByLocator(createBy);
    }

    /**
     * Gets a list with values of campaign.
     *
     * @param table a table with values which decide which text select
     * @return a list with some data of campaign
     */
    @Override
    public List<String> getValueField(Map<String, String> table) {
        List<String> result = new ArrayList<>();
        HashMap<String, StringSupplier> actionsCampaignMap = getTxtFields();
        table.keySet().forEach(key -> result.add(actionsCampaignMap.get(key).getAsString()));
        return result;
    }

    /**
     * Gets text fields of campaign.
     *
     * @return a map with methods of campaign to get text
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
