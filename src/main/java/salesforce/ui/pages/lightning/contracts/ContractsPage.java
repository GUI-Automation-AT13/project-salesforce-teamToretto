package salesforce.ui.pages.lightning.contracts;

import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;

/**
 * Page Object Model for the salesforce contracts page.
 */
public class ContractsPage extends BasePage {

    private By newContractButton = By.cssSelector("a[title='New']");

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(newContractButton);
    }

    /**
     * Logs in successfully.
     *
     * @return a ProductPage instance
     */
    public NewContractPage clickNewContractButton() {
        webElementAction.clickByLocator(newContractButton);
        return new NewContractPage();
    }
}
