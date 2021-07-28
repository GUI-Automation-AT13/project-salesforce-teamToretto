package salesforce.ui.pages.classic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.BasePage;

/**
 * Initializes the Web elements.
 */
public class ClassicHomePage extends BasePage {

    @FindBy(css = ".allTabsArrow")
    private WebElement addObject;

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisible(addObject);
    }

    /**
     * Clicks the addObject button.
     *
     * @return a HomePageObjects.
     */
    public ClassicHomePageObjects clickAddObject() {
        addObject.click();
        return new ClassicHomePageObjects();
    }
}
