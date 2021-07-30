package salesforce.ui.pages.lightning;

import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;

/**
 * Page object model for a base page.
 */
public class HomePage extends BasePage {

    public static final String URL = "/lightning/page/home";
    private By labelObjectManager = By.cssSelector(".hasActions .title");

    /**
     * Checks if the ObjectManager label is visible.
     *
     * @return boolean.
     */
    public boolean labelObjectManageriIsVisible() {
        return webElementAction.isDisplayed(labelObjectManager);
    }

    @Override
    protected void waitForPageLoaded() {
    }
}
