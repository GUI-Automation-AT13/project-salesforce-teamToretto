package salesforce.ui.pages.lightning.individuals;

import core.selenium.WebDriverManager;
import java.util.List;
import java.util.Map;
import salesforce.utils.strategy.FeatureDetails;

/**
 * Page Object Model for the salesforce individual details record page.
 */
public class IndividualsDetailsPage extends  IndividualRecordPage implements FeatureDetails {
    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public IndividualsDetailsPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    @Override
    public List<String> getValueField(Map<String, String> table) {
        return null;
    }

    @Override
    public String getCreateDayTxt() {
        return null;
    }
}
