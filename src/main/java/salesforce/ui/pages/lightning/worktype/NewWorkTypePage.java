/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.worktype;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.IFeatureNew;
import salesforce.utils.supplier.VoidSupplier;

import java.util.HashMap;
import java.util.Map;

/**
 * This class has webElement for work type page form.
 */
public class NewWorkTypePage extends BasePage implements IFeatureNew {

    protected By estimatedDurationComboBox = By.cssSelector(".select[aria-required='true']");
    protected By saveBtn = By.xpath("//button[@data-aura-class='uiButton forceActionButton'][3]");
    private String xpathComboBox;
    private static int countComboBox = 0;

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(estimatedDurationComboBox);
    }

    /**
     * Sets on text of all field of workType.
     *
     * @param fieldName  name of textBox
     * @param fieldValue is value to set on textBox
     */
    public void setInputField(final String fieldName, final String fieldValue) {
        if ("Description".equals(fieldName)) {
            webElementAction.setInputField((By.cssSelector(".textarea")), fieldValue);
        } else {
            String xpath = String.format("//*[contains(text(),'%s')]/../..//*[@type='text']", fieldName);
            webElementAction.setInputField(By.xpath(xpath), fieldValue);
        }
        webElementAction.clickByXpath("//div[@class='actionsContainer']");
    }

    /**
     * Sets value and select estimated duration comboBox.
     *
     * @param selectValue is value in comboBox
     */
    public void setEstimatedDurationComboBox(final String selectValue) {
        //webElementAction.selectByAction(estimatedDurationComboBox);
        String xpathValue = String.format("//a[normalize-space()='%s']", selectValue);
        webElementAction.getTextOfElementByField(xpathValue);
    }

    /**
     * Sets value and select in comboBox.
     *
     * @param nameComboBox is name of comboBox
     * @param selectValue  is a value in comboBox
     */
    public void setComboBoxField(final String nameComboBox, final String selectValue) {
        countComboBox++;
        xpathComboBox = String.format("//*[contains(text(),'%s')]/../..//a[@class='select']", nameComboBox);
        webElementAction.selectByAction(WebDriverManager.getInstance().getWebDriver()
                .findElement(By.xpath(xpathComboBox)));
        String xpathValue = String.format("(//a[normalize-space()='%s'])[%d]", selectValue, countComboBox);
        webElementAction.clickByLocator(By.xpath(xpathValue));
        webElementAction.clickByLocator(By.xpath("//div[@class='actionsContainer']"));
    }

    /**
     * Actions to click save button.
     *
     * @return WorkTypeInfo which is to pass other page.
     */
    public CreatedWorkTypePage clickSaveButton() {
        webElementAction.clickByLocator(saveBtn);
        return new CreatedWorkTypePage();
    }

    @Override
    public void fillUpField(final Map<String, String> table) {
        HashMap<String, VoidSupplier> actionsWorkTypeMap = mapActionsWorkType(table);
        table.keySet().forEach(key -> actionsWorkTypeMap.get(key).run());
    }

    /**
     * Saves actions in New work type page in map
     *
     * @param workTypeMap is map
     * @return a map with action of fields
     */
    private HashMap<String, VoidSupplier> mapActionsWorkType(final Map<String, String> workTypeMap) {
        HashMap<String, VoidSupplier> mapActions = new HashMap<>();
        mapActions.put("Work Type Name", () -> setInputField("Work Type Name",workTypeMap.get("Work Type Name")));
        mapActions.put("Description", () -> setInputField("Description",workTypeMap.get("Description")));
        mapActions.put("Estimated Duration", () -> setInputField("Estimated Duration",
                workTypeMap.get("Estimated Duration")));
        mapActions.put("Duration Type",  () -> setEstimatedDurationComboBox(workTypeMap.get("Duration Type")));
        mapActions.put("Block Time Before Appointment", () -> setInputField("Block Time Before Appointment",
                workTypeMap.get("Block Time Before Appointment")));
        mapActions.put("Block Time Before Unit", () -> setComboBoxField("Block Time Before Unit",
                workTypeMap.get("Block Time Before Unit")));
        mapActions.put("Block Time After Appointment", () -> setInputField("Block Time After Appointment",
                workTypeMap.get("Block Time After Appointment")));
        mapActions.put("Block Time After Unit", () -> setComboBoxField("Block Time After Unit",
                workTypeMap.get("Block Time After Unit")));
        mapActions.put("Timeframe Start", () -> setInputField("Timeframe Start",
                workTypeMap.get("Timeframe Start")));
        mapActions.put("Time Frame Start Unit", () -> setComboBoxField("Time Frame Start Unit",
                workTypeMap.get("Description")));
        mapActions.put("Timeframe End", () -> setInputField("Timeframe End",workTypeMap.get("Timeframe End")));
        mapActions.put("Time Frame End Unit", () -> setComboBoxField("Time Frame End Unit",
                workTypeMap.get("Time Frame End Unit")));
        return mapActions;
    }
}
