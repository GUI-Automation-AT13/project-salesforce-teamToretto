package salesforce.ui.pages.lightning.individuals;

import static salesforce.utils.Internalization.translate;

import core.selenium.WebDriverManager;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.utils.strategy.FeatureDetails;

/**
 * Page Object Model for the salesforce individual details record page.
 */
public class IndividualDetails extends IndividualPageCreated implements FeatureDetails {
    private By dateCreateByTxt = By.xpath(String.format("//*[contains(text(),'%s')]/../.."
            + "//*[@class='uiOutputDateTime forceOutputModStampWithPreview']", translate("Created By")));

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public IndividualDetails(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets a date when contract is created.
     *
     * @return a String to date.
     */
    @Override
    public String getCreateDayTxt() {
        return webDriverActions.getTextOfByFieldByLocator(dateCreateByTxt);
    }

    /**
     * Gets a list with values of individual.
     *
     * @param table a table with values which decide which text select
     * @return a list with some data of contract
     */
    @Override
    public List<String> getValuesFromFields(Map<String, String> table) {
        return null;
    }

}
