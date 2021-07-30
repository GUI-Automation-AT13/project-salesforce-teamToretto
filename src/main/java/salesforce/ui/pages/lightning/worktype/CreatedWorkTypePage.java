package salesforce.ui.pages.lightning.worktype;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.BasePage;

/**
 * This class has webElement for work type created.
 */
public class CreatedWorkTypePage extends BasePage {

    protected By nameWorkTypeTxt = By.xpath("//*[@class='uiOutputText']");
    protected By descriptionTxt = By.xpath("//*[@class='uiOutputTextArea']");
    protected By dateCreateByTxt = By
            .xpath("//*[contains(text(),'Created By')]/../..//*[@class='uiOutputDateTime"
            + "forceOutputModStampWithPreview']");
    protected By nameCreatorTxt = By.xpath("//span[contains(text(),'Created By')]/../..//a[@rel='noreferrer']");

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
        String xpath = String.format("//*[contains(text(),'%s')]/../..//*[@class='uiOutputNumber']", nameTxtBox);
        return webElementAction.getTextOfElementByField(xpath);
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
}
