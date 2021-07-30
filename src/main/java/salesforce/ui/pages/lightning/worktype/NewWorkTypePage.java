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

/**
 * This class has webElement for work type page form.
 */
public class NewWorkTypePage extends BasePage {

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
     * @param fieldName name of textBox
     * @param fieldValue is value to set on textBox
     */
    public void setInputField(final String fieldName, final String fieldValue) {
        if ("Description".equals(fieldName)) {
            webElementAction.setInputField((By.cssSelector(".textarea")), fieldValue);
        } else {
            String xpath = String.format("//*[contains(text(),'%s')]/../..//*[@type='text']", fieldName);
            webElementAction.setInputField(By.xpath(xpath), fieldValue);
        }
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
     * @param selectValue is a value in comboBox
     */
    public void setComboBoxField(final String nameComboBox, final String selectValue) {
        countComboBox++;
        xpathComboBox = String.format("//*[contains(text(),'%s')]/../..//a[@class='select']", nameComboBox);
        webElementAction.selectByAction(WebDriverManager.getInstance().getWebDriver()
                .findElement(By.xpath(xpathComboBox)));
        String xpathValue = String.format("(//a[normalize-space()='%s'])[%d]", selectValue, countComboBox);
        webElementAction.getTextOfElementByField(xpathValue);
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
}
