/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.worktype;

import static salesforce.utils.Internalization.translate;

import core.selenium.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.FeatureNew;
import salesforce.utils.supplier.VoidSupplier;


/**
 * This class has webElement for work type page form.
 */
public class NewWorkTypePage extends BasePage implements FeatureNew {

    private By estimatedDurationComboBox = By.cssSelector(".select[aria-required='true']");
    private By saveBtn = By.xpath("//button[@data-aura-class='uiButton forceActionButton'][3]");
    private By descriptionTxtBox = By.cssSelector(".textarea");
    private String selectFieldTxtBox = "//*[contains(text(),'%s')]/../..//*[@type='text']";
    private String valueEstimatedDurationComboBox = "//a[normalize-space()='%s']";
    private String xpathComboBoxSomeFields = "//*[contains(text(),'%s')]/../..//a[@class='select']";
    private String xpathValueComboBoxSomeFields = "//div[@aria-labelledby][@id][%d]//*[contains(text(),'%s')]";
    private int countComboBox = 0;

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public NewWorkTypePage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(estimatedDurationComboBox);
    }

    /**
     * Sets on text of descriptions field of workType.
     *
     * @param fieldValue is value to set on textBox
     */
    public void setDescription(final String fieldValue) {
        webElementAction.setInputField((descriptionTxtBox), fieldValue);
    }

    /**
     * Sets on text of field Estimated Duration, Block Time Before Appointment, Block Time After Appointment, Timeframe
     * Start  of workType and Timeframe End.
     *
     * @param fieldName  name of textBox
     * @param fieldValue is value to set on textBox
     */
    public void setInputField(final String fieldName, final String fieldValue) {
        webElementAction.dropDownTillTheEnd();
        webElementAction.setInputField(By.xpath(String.format(selectFieldTxtBox, fieldName)), fieldValue);
    }

    /**
     * Sets value and select estimated duration comboBox.
     *
     * @param selectValue is value in comboBox
     */
    public void setDurationTypeComboBox(final String selectValue) {
        webElementAction.selectByAction(estimatedDurationComboBox);
        webElementAction.clickByXpath(String.format(valueEstimatedDurationComboBox, selectValue));
        countComboBox++;
    }

    /**
     * Sets value and select  Block Time Before Unit, Block Time After Unit, Time Frame Start Unit
     * and Time Frame End Unit in comboBox.
     *
     * @param nameComboBox is name of comboBox
     * @param selectValue  is a value in comboBox
     */
    public void setComboBoxField(final String nameComboBox, final String selectValue) {
        webElementAction.selectByAction(By.xpath(String.format(xpathComboBoxSomeFields, nameComboBox)));
        countComboBox++;
        webElementAction.clickByXpath(String.format(xpathValueComboBoxSomeFields, countComboBox, selectValue));
    }

    /**
     * Actions to click save button.
     *
     * @return WorkTypeInfo which is to pass other page.
     */
    public CreatedWorkTypePage clickSaveButton() {
        webElementAction.clickByLocator(saveBtn);
        return new CreatedWorkTypePage(webDriverManager);
    }

    @Override
    public void fillUpField(final Map<String, String> table) {
        HashMap<String, VoidSupplier> actionsWorkTypeMap = mapActionsWorkType(table);
        table.keySet().forEach(key -> actionsWorkTypeMap.get(key).run());
    }

    /**
     * Saves actions in New work type page in map.
     *
     * @param workTypeMap is map
     * @return a map with action of fields
     */
    private HashMap<String, VoidSupplier> mapActionsWorkType(final Map<String, String> workTypeMap) {
        HashMap<String, VoidSupplier> mapActions = new HashMap<>();
        mapActions.put("Work Type Name", () -> setInputField(translate("Work Type Name"),
                workTypeMap.get("Work Type Name")));
        mapActions.put("Description", () -> setDescription(workTypeMap.get("Description")));
        mapActions.put("Estimated Duration", () -> setInputField(translate("Estimated Duration"),
                workTypeMap.get("Estimated Duration")));
        mapActions.put("Duration Type", () -> setDurationTypeComboBox(workTypeMap.get("Duration Type")));
        mapActions.put("Block Time Before Appointment",
                () -> setInputField(translate("Block Time Before Appointment"),
                workTypeMap.get("Block Time Before Appointment")));
        mapActions.put("Block Time Before Unit", () -> setComboBoxField(translate("Block Time Before Unit"),
                workTypeMap.get("Block Time Before Unit")));
        mapActions.put("Block Time After Appointment", () -> setInputField(translate("Block Time After Appointment"),
                workTypeMap.get("Block Time After Appointment")));
        mapActions.put("Block Time After Unit", () -> setComboBoxField(translate("Block Time After Unit"),
                workTypeMap.get("Block Time After Unit")));
        mapActions.put("Timeframe Start", () -> setInputField(translate("Timeframe Start"),
                workTypeMap.get("Timeframe Start")));
        mapActions.put("Time Frame Start Unit", () -> setComboBoxField(translate("Time Frame Start Unit"),
                workTypeMap.get("Time Frame Start Unit")));
        mapActions.put("Timeframe End", () -> setInputField(translate("Timeframe End"),
                workTypeMap.get("Timeframe End")));
        mapActions.put("Time Frame End Unit", () -> setComboBoxField(translate("Time Frame End Unit"),
                workTypeMap.get("Time Frame End Unit")));
        return mapActions;
    }
}
