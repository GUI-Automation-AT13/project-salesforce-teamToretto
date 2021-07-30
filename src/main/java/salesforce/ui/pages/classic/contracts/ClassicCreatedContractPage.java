package salesforce.ui.pages.classic.contracts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.BasePage;
import salesforce.ui.pages.classic.ClassicHomePageObjects;

/**
 * Page object model for the salesforce classic contract page.
 */
public class ClassicCreatedContractPage extends BasePage {

    private By accountName = By.cssSelector("div[id*=\"ctrc7_ileinner\"]");
    private By addObjects = By.cssSelector(".allTabsArrow");

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(addObjects);
    }

    /**
     * Clicks on the add object button.
     *
     * @return a HomePageObjects.
     */
    public ClassicHomePageObjects clickAddObjects() {
        webElementAction.clickByLocator(addObjects);
        return new ClassicHomePageObjects();
    }

    /**
     * Waits for the page to be loaded.
     *
     * @return the text set on the account name assigned to a contract.
     */
    public String getAccountName() {
        return webElementAction.getTextOfByFieldByLocator(accountName);
    }
}
