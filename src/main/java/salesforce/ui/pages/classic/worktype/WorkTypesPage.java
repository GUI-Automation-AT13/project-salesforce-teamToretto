package salesforce.ui.pages.classic.worktype;

import core.selenium.WebDriverManager;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.FeatureForm;
import salesforce.utils.strategy.FeaturesPage;

/**
 * This class has webElement for work types pages.
 */
public class WorkTypePage extends BasePage implements FeaturesPage {
    protected By newBtn = By.name("new");
    protected By closeAnnouncement = By.cssSelector("#tryLexDialogX");

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public WorkTypePage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(newBtn);
    }

    @Override
    public FeatureForm clickNewButton() {
        webDriverActions.clickByLocator(closeAnnouncement);
        webDriverActions.clickByLocator(newBtn);
        return new WorkTypePageForm(webDriverManager);
    }

    @Override
    public List<String> getTablesValues(Map<String, String> table) {
        return null;
    }

}
