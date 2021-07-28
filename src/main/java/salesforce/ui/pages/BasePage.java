package salesforce.ui.pages;

import core.selenium.WebDriverManager;
import core.selenium.WebElementAction;
import org.openqa.selenium.support.PageFactory;

/**
 * Load home page.
 */
public abstract class BasePage {
    public WebElementAction webElementAction;

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
