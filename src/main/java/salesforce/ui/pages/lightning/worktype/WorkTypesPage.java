package salesforce.ui.pages.lightning.worktype;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.BasePage;

/**
 * This class has webElement for work types page.
 */
public class WorkTypesPage extends BasePage {
    @FindBy(xpath = "//a[@class='forceActionLink'][@role='button']")
    protected WebElement newBtn;

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisible(newBtn);
    }

    /**
     * Changes the page to create work type.
     *
     * @return workTypeForm initialize.
     */
    public NewWorkTypePage clickNewButton() {
        webElementAction.clickField(newBtn);
        return new NewWorkTypePage();
    }
}
