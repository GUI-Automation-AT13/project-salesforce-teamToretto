package salesforce.ui.pages.classic.contracts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.BasePage;
import salesforce.ui.pages.classic.ClassicHomePageObjects;

public class ClassicCreatedContractPage extends BasePage {

    @FindBy(css = "div[id*=\"ctrc7_ileinner\"]")
    private WebElement accountName;

    @FindBy(css = ".allTabsArrow")
    private WebElement addObjects;

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisible(addObjects);
    }

    /**
     * Clicks on the add object button.
     *
     * @return a HomePageObjects.
     */
    public ClassicHomePageObjects clickAddObjects() {
        webElementAction.clickField(addObjects);
        return new ClassicHomePageObjects();
    }

    /**
     * Waits for the page to be loaded.
     *
     * @return the text set on the account name assigned to a contract.
     */
    public String getAccountName() {
        return webElementAction.getTextOfElement(accountName);
    }
}
