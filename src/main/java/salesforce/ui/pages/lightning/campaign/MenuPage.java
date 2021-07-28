package salesforce.ui.pages.lightning.campaign;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * This class is for menu page.
 */
public class MenuPage extends BasePage {

    @FindBy(xpath = "//div[@role=\'menu\']//a[./div[@title=\'Delete\']]")
    private WebElement deleteBtn;

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(deleteBtn));
    }
}