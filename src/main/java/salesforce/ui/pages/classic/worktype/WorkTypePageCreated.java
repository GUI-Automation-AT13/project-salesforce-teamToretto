package salesforce.ui.pages.classic.worktype;

import core.selenium.WebDriverManager;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.FeatureCreated;
import salesforce.utils.strategy.FeatureDetails;

/**
 * This class has webElement for work types Created.
 */
public class WorkTypeCreated extends BasePage implements FeatureCreated {
    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public WorkTypeCreated(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {

    }

    @Override
    public FeatureDetails clickDetails() {
        return new WorkTypeDetails(webDriverManager);
    }
}
