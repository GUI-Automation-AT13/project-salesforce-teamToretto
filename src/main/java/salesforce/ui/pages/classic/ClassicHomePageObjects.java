package salesforce.ui.pages.classic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.BasePage;
import salesforce.ui.pages.classic.contracts.ClassicContractsPage;

public class ClassicHomePageObjects extends BasePage {

    @FindBy(css = ".listRelatedObject.contractBlock.title")
    private WebElement contractBtn;

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisible(contractBtn);
    }
    /**
     * Clicks on the add object button.
     *
     * @return a new ContractsPage
     */
    public ClassicContractsPage clickAddObject() {
        contractBtn.click();
        return new ClassicContractsPage();
    }
}
