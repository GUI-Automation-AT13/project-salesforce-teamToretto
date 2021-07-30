package salesforce.ui.pages.lightning.worktype;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.BasePage;
import salesforce.utlis.strategy.ICreatedFeature;
import salesforce.utlis.supplier.StringSupplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;

/**
 * This class has webElement for work type created.
 */
public class CreatedWorkTypePage extends BasePage implements ICreatedFeature {
    @FindBy(xpath = "//*[@class='uiOutputText']")
    protected WebElement nameWorkTypeTxt;

    @FindBy(xpath = "//*[@class='uiOutputTextArea']")
    protected WebElement descriptionTxt;

    @FindBy(xpath = "//*[contains(text(),'Created By')]/../..//*[@class='uiOutputDateTime"
            + "forceOutputModStampWithPreview']")
    protected WebElement dateCreateByTxt;

    @FindBy(xpath = "//span[contains(text(),'Created By')]/../..//a[@rel='noreferrer']")
    protected WebElement nameCreatorTxt;

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisible(nameWorkTypeTxt);
    }

    /**
     * Gets the name of work type.
     *
     * @return name of worktype.
     */
    public String getNameOfWorkType() {
        return nameWorkTypeTxt.getText();
    }

    /**
     * Gets the description of work type.
     *
     * @return description of worktype.
     */
    public String getDescription() {
        return descriptionTxt.getText();
    }

    /**
     * Sets value and select in txt of Estimated Duration, Block Time Before Appointment, Block Time After Appointment.
     * Timeframe Start and Timeframe End.
     *
     * @param nameTxtBox is name of textBox
     * @return value of nameTxtBox
     */
    public String getTxtField(final String nameTxtBox) {
        String xpath = String.format("//*[contains(text(),'%s')]/../..//*[@class='uiOutputNumber']", nameTxtBox);
        return webElementAction.getTextOfElementByField(xpath);
    }

    /**
     * Gets a date when workType is created.
     *
     * @return a String to date
     */
    public String getCreatedByTxt() {
        return webElementAction.getTextOfElement(dateCreateByTxt);
    }

    /**
     * Gets a creator's name of workType.
     *
     * @return a String to date
     */
    public String getNameCreatorTxt() {
        return webElementAction.getTextOfElement(nameCreatorTxt);
    }


    @Override
    public List<String> getValueField(final Map<String, String> table) {
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
        mapValues.put("Estimated Duration", () -> getTxtField("Estimated Duration"));
        mapValues.put("Block Time Before Appointment", () -> getTxtField("Block Time Before Appointment"));
        mapValues.put("Block Time After Appointment", () -> getTxtField("Block Time After Appointment"));
        mapValues.put("Timeframe Start", () -> getTxtField("Estimated Duration"));
        mapValues.put("Timeframe End", () -> getTxtField("Timeframe End"));
        return mapValues;
    }
}
