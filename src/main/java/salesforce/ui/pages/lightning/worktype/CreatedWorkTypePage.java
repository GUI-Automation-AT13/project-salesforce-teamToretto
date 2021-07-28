package salesforce.ui.pages.lightning.worktype;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.BasePage;

/**
 * This class has webElement for work type created.
 */
public class CreatedWorkTypePage extends BasePage {
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
}
