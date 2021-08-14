package salesforce.ui.pages.lightning.worktype;

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
 * This class has webElement for work type created.
 */
public class WorkTypeDetails extends WorkTypePageCreated implements FeatureDetails {
    private By nameWorkTypeTxt = By.xpath("//span[@class='uiOutputText']");
    private By descriptionTxt = By.xpath("//span[@class='uiOutputTextArea']");
    private By dateCreateByTxt = By.xpath(String.format("//span[contains(text(),'%s')]/../.."
            + "//*[@class='uiOutputDateTime forceOutputModStampWithPreview']", translate("Created By")));
    private By nameCreatorTxt = By.xpath(String.format("//span[contains(text(),'%s')]/../..//a[@rel='noreferrer']",
            translate("Created By")));
    private String pathFieldTxt = "//span[contains(text(),'%s')]/../..//span[@class='uiOutputNumber']";
    private By estimatedDurationTxt = By.xpath(String.format("//span[contains(text(),'%s')]"
                    + "[@class='test-id__field-label']/../..//span[@class='uiOutputNumber']",
            translate("Estimated Duration")));
    private String unitTxt = "//span[contains(text(),'%s')]/../..//span[@class='test-id__field-value "
            + "slds-form-element__static slds-grow ']";
    private String operatingHoursTxt = "//span[contains(text(),'%s')]/../..//a[@target='_blank'][@href]";

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public WorkTypeDetails(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets the name of work type.
     *
     * @return name of worktype.
     */
    public String getNameOfWorkType() {
        return webDriverActions.getTextOfByFieldByLocator(nameWorkTypeTxt);
    }

    /**
     * Gets the Estimated Duration of work type.
     *
     * @return description of estimated duration.
     */
    public String getEstimatedDuration() {
        return webDriverActions.getTextOfByFieldByLocator(estimatedDurationTxt);
    }

    /**
     * Gets the description of work type.
     *
     * @return description of worktype.
     */
    public String getDescription() {
        return webDriverActions.getTextOfByFieldByLocator(descriptionTxt);
    }

    /**
     * Sets value and select in txt of Block Time Before Appointment, Block Time After Appointment.
     * Timeframe Start and Timeframe End.
     *
     * @param nameTxtBox is name of textBox
     * @return value of nameTxtBox
     */
    public String getTxtField(final String nameTxtBox) {
        return webDriverActions.getTextByXpathLocator(String.format(pathFieldTxt, nameTxtBox));
    }

    /**
     * Sets value and select in txt of Duration Type, Block Time Before Unit, Block Time After Unit,
     * Time Frame Start Unit and Time Frame End Unit.
     *
     * @param nameTxtBox is name of textBox
     * @return value of nameTxtBox
     */
    public String getUnitsOfTxtField(final String nameTxtBox) {
        return webDriverActions.getTextByXpathLocator(String.format(unitTxt, nameTxtBox));
    }

    /**
     * Gets values of Operating Hours txt box.
     *
     * @return value of TxtBox
     */
    public String getOperatingHoursTxtBox() {
        return webDriverActions.getTextByXpathLocator(String.format(operatingHoursTxt,
                translate("Operating Hours")));
    }

    /**
     * Gets a creator's name of workType.
     *
     * @return a String to date
     */
    public String getNameCreatorTxt() {
        return webDriverActions.getTextOfByFieldByLocator(nameCreatorTxt);
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
     * Gets a list with values of work type.
     *
     * @param table a table with values which decide which text select
     * @return a list with some data of campaign
     */
    @Override
    public List<String> getValuesFromFields(final Map<String, String> table) {
        List<String> result = new ArrayList<>();
        HashMap<String, StringSupplier> actionsWorkTypeMap = getTxtFields();
        table.keySet().forEach(key -> result.add(actionsWorkTypeMap.get(key).getAsString()));
        return result;
    }

    /**
     * Gets text fields of workType.
     *
     * @return a map with methods of CreatedWorkType
     */
    private HashMap<String, StringSupplier> getTxtFields() {
        HashMap<String, StringSupplier> mapValues = new HashMap<>();
        mapValues.put("Work Type Name", this::getNameOfWorkType);
        mapValues.put("Description", this::getDescription);
        mapValues.put("Estimated Duration", this::getEstimatedDuration);
        mapValues.put("Operating Hours", this::getOperatingHoursTxtBox);
        mapValues.put("Block Time Before Appointment", () -> getTxtField(translate("Block Time Before Appointment")));
        mapValues.put("Block Time After Appointment", () -> getTxtField(translate("Block Time After Appointment")));
        mapValues.put("Timeframe Start", () -> getTxtField(translate("Timeframe Start")));
        mapValues.put("Timeframe End", () -> getTxtField(translate("Timeframe End")));
        mapValues.put("Duration Type", () -> getUnitsOfTxtField(translate("Duration Type")));
        mapValues.put("Block Time Before Unit", () -> getUnitsOfTxtField(translate("Block Time Before Unit")));
        mapValues.put("Block Time After Unit", () -> getUnitsOfTxtField(translate("Block Time After Unit")));
        mapValues.put("Time Frame Start Unit", () -> getUnitsOfTxtField(translate("Time Frame Start Unit")));
        mapValues.put("Time Frame End Unit", () -> getUnitsOfTxtField(translate("Time Frame End Unit")));
        return mapValues;
    }
}
