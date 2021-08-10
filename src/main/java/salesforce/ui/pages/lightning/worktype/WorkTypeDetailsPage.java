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
public class WorkTypeDetailsPage extends CreatedWorkTypePage implements FeatureDetails {
    protected By nameWorkTypeTxt = By.xpath("//*[@class='uiOutputText']");
    protected By descriptionTxt = By.xpath("//*[@class='uiOutputTextArea']");
    protected By dateCreateByTxt = By.xpath(String.format("//*[contains(text(),'Created By')]/../.."
            + "//*[@class='uiOutputDateTime forceOutputModStampWithPreview']", translate("Created By")));
    protected By nameCreatorTxt = By.xpath("//span[contains(text(),'Created By')]/../..//a[@rel='noreferrer']");
    protected String pathFieldTxt = "//*[contains(text(),'%s')]/../..//*[@class='uiOutputNumber']";


    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public WorkTypeDetailsPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }


    @Override
    public List<String> getValueField(final Map<String, String> table) {
        List<String> result = new ArrayList<>();
        HashMap<String, StringSupplier> actionsWorkTypeMap = getTxtFields();
        table.keySet().forEach(key -> result.add(actionsWorkTypeMap.get(key).getAsString()));
        return result;
    }

    /**
     * Gets a date when workType is created.
     *
     * @return a String to date
     */
    @Override
    public String getCreateDayTxt() {
        return webElementAction.getTextOfByFieldByLocator(dateCreateByTxt);
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
        mapValues.put("Estimated Duration", () -> getTxtField(translate("Estimated Duration")));
        mapValues.put("Block Time Before Appointment", () -> getTxtField(translate("Block Time Before Appointment")));
        mapValues.put("Block Time After Appointment", () -> getTxtField(translate("Block Time After Appointment")));
        mapValues.put("Timeframe Start", () -> getTxtField(translate("Timeframe Start")));
        mapValues.put("Timeframe End", () -> getTxtField(translate("Timeframe End")));
        return mapValues;
    }

    /**
     * Gets the name of work type.
     *
     * @return name of worktype.
     */
    public String getNameOfWorkType() {
        return webElementAction.getTextOfByFieldByLocator(nameWorkTypeTxt);
    }

    /**
     * Gets the description of work type.
     *
     * @return description of worktype.
     */
    public String getDescription() {
        return webElementAction.getTextOfByFieldByLocator(descriptionTxt);
    }

    /**
     * Sets value and select in txt of Estimated Duration, Block Time Before Appointment, Block Time After Appointment.
     * Timeframe Start and Timeframe End.
     *
     * @param nameTxtBox is name of textBox
     * @return value of nameTxtBox
     */
    public String getTxtField(final String nameTxtBox) {
        return webElementAction.getTextOfElementByField(String.format(pathFieldTxt, nameTxtBox));
    }

    /**
     * Gets a creator's name of workType.
     *
     * @return a String to date
     */
    public String getNameCreatorTxt() {
        return webElementAction.getTextOfByFieldByLocator(nameCreatorTxt);
    }

}
