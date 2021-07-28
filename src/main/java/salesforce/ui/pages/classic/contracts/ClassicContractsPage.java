package salesforce.ui.pages.classic.contracts;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

public class ClassicContractsPage extends BasePage {

    @FindBy(css = "input[title='New']")
    private WebElement newContractButton;

    @FindBy(id = "tryLexDialogX")
    private WebElement popup;

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisible(newContractButton);
    }

    /**
     * Closes a popup.
     */
    public void clickPopUP() {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(By.id("tryLexDialogX")));
        popup.click();
    }
    /**
     * Clicks on a new contract button.
     *
     * @return a new NewContractPage.
     */
    public ClassicNewContractPage clickNew() {
        newContractButton.click();
        return new ClassicNewContractPage();
    }

}
