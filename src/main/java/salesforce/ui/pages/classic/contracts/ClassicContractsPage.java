package salesforce.ui.pages.classic.contracts;

import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;

/**
 * Page object model for the salesforce classic contracts page.
 */
public class ClassicContractsPage extends BasePage {

    private By newContractButton = By.cssSelector("input[title='New']");
    private By popup = By.id("tryLexDialogX");

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(newContractButton);
    }

    /**
     * Closes a popup.
     */
    public void clickPopUp() {
        webElementAction.waitForVisibilityOfLocator(popup);
        webElementAction.clickByLocator(popup);
    }

    /**
     * Clicks on a new contract button.
     *
     * @return a new NewContractPage
     */
    public ClassicNewContractPage clickNew() {
        webElementAction.clickByLocator(newContractButton);
        return new ClassicNewContractPage();
    }

}
