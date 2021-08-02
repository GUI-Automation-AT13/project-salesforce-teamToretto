/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.worktype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.CreatedFeature;
import salesforce.utils.supplier.StringSupplier;

/**
 * This class has webElement for work type created.
 */
public class CreatedWorkTypePage extends BasePage implements CreatedFeature {

    protected By nameWorkTypeTxt = By.xpath("//*[@class='uiOutputText']");
    protected By descriptionTxt = By.xpath("//*[@class='uiOutputTextArea']");
    protected By dateCreateByTxt = By
            .xpath("//*[contains(text(),'Created By')]/../..//*[@class='uiOutputDateTime"
                    + "forceOutputModStampWithPreview']");
    protected By nameCreatorTxt = By.xpath("//span[contains(text(),'Created By')]/../..//a[@rel='noreferrer']");
    protected String pathFieldTxt = "//*[contains(text(),'%s')]/../..//*[@class='uiOutputNumber']";

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(nameWorkTypeTxt);
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
     * Gets a date when workType is created.
     *
     * @return a String to date
     */
    public String getCreatedByTxt() {
        return webElementAction.getTextOfByFieldByLocator(dateCreateByTxt);
    }

    /**
     * Gets a creator's name of workType.
     *
     * @return a String to date
     */
    public String getNameCreatorTxt() {
        return webElementAction.getTextOfByFieldByLocator(nameCreatorTxt);
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
        mapValues.put("Timeframe Start", () -> getTxtField("Timeframe Start"));
        mapValues.put("Timeframe End", () -> getTxtField("Timeframe End"));
        return mapValues;
    }
}
