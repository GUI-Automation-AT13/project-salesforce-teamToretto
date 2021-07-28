package salesforce.ui.pages;

import core.selenium.WebDriverManager;
import core.selenium.WebElementAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Load home page.
 */
public abstract class BasePage {
    public WebElementAction webElementAction;
    public WebDriverWait wait;
    public WebDriver driver;

    /**
     * Initializes the elements and wait for page to be loaded.
     */
    public BasePage() {
        webElementAction = new WebElementAction();
        PageFactory.initElements(WebDriverManager.getInstance().getWebDriver(), this);
        waitForPageLoaded();
    }
    /**
     * Waits for the page to be loaded.
     */
    protected abstract void waitForPageLoaded();


}
