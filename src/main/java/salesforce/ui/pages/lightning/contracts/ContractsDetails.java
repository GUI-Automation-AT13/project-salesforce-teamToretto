package salesforce.ui.pages.lightning.contracts;

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
 * Class to compose the details section inside a CreatedContractPage.
 */
public class ContractsDetails extends CreatedContractPage implements FeatureDetails {
    private By contractStartDate = By.xpath("(//div[./div[./span[text()='"
            + translate("Contract Start Date") + "']]]//span//span)[last()]");
    private static final String BASE_XPATH = "//div[./div[./span[text()='%s']]]";
    private static final HashMap<String, String> XPATH_COMPLEMENTS = new HashMap<>();
    protected By dateCreateByTxt = By.xpath(String.format("//*[contains(text(),'Created By')]/../.."
            + "//*[@class='uiOutputDateTime forceOutputModStampWithPreview']", translate("Created By")));

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
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public ContractsDetails(WebDriverManager webDriverManager) {
        super(webDriverManager);
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
     * Gets a date when contract is created.
     *
     * @return a String to date.
     */
    @Override
    public String getCreateDayTxt() {
        return webElementAction.getTextOfByFieldByLocator(dateCreateByTxt);
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
