package salesforce.ui.pages.lightning.worktype;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.BasePage;

/**
 * This class has webElement for work types page.
 */
public class WorkTypesPage extends BasePage {
    protected By newBtn = By.xpath("//a[@class='forceActionLink'][@role='button']");

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(newBtn);
    }

    /**
     * Changes the page to create work type.
     *
     * @return workTypeForm initialize.
     */
    public NewWorkTypePage clickNewButton() {
        webElementAction.clickByLocator(newBtn);
        return new NewWorkTypePage();
    }
}
