package salesforce.ui.pages.lightning.contracts;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;
import salesforce.utlis.strategy.IFeatureNew;
import salesforce.utlis.strategy.IFeaturesPage;

/**
 * Page Object Model for the salesforce contracts page.
 */
public class ContractsPage extends BasePage implements IFeaturesPage {
    @FindBy(css = "a[title='New']")
    private WebElement newContractButton;

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(newContractButton));
    }

    /**
     * Logs in successfully.
     *
     * @return a ProductPage instance
     */
    public NewContractPage clickNewButton() {
        webElementAction.clickField(newContractButton);
        return new NewContractPage();
    }
}
