package salesforce.ui.pages.classic.worktype;

import core.selenium.WebDriverManager;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.ui.entities.PersonalInformation;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.FeatureNew;
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
    public FeatureNew clickNewButton() {
        webDriverActions.clickByLocator(closeAnnouncement);
        webDriverActions.clickByLocator(newBtn);
        return new WorkTypeNew(webDriverManager);
    }

    @Override
    public List<String> getValueTables(Map<String, String> table) {
        return null;
    }


    @Override
    public List<String> getExpected(Map<String, String> tableFeature, PersonalInformation personalInformation) {
        return null;
    }
}
