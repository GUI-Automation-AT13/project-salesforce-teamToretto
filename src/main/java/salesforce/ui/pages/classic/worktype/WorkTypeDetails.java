package salesforce.ui.pages.classic.worktype;

import core.selenium.WebDriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.FeatureDetails;
import salesforce.utils.supplier.StringSupplier;

/**
 * This class has webElement for work types details.
 */
public class WorkTypeDetails extends BasePage implements FeatureDetails {
    protected By nameWorkTypeTxt = By.id("Name_ilecell");
    protected By estimatedDurationTxt = By.id("EstimatedDuration_ileinner");
    protected By dateCreateByTxt = By.id("CreatedBy_ileinner");

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public WorkTypeDetails(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets the name of work type.
     *
     * @return name of worktype.
     */
    public String getNameOfWorkType() {
        return webDriverActions.getTextOfByFieldByLocator(nameWorkTypeTxt);
    }

    /**
     * Gets the Estimated Duration of work type.
     *
     * @return description of estimated duration.
     */
    public String getEstimatedDuration() {
        return webDriverActions.getTextOfByFieldByLocator(estimatedDurationTxt);
    }

    /**
     * Gets a date when workType is created.
     *
     * @return a String to date
     */
    @Override
    public String getCreateDayTxt() {
        int numberToDivide = 3;
        String[] divideWord = webDriverActions.getTextOfByFieldByLocator(dateCreateByTxt)
                .split(" ", numberToDivide);
        return divideWord[divideWord.length - 1];
    }

    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(nameWorkTypeTxt);
    }

    @Override
    public List<String> getValuesFromFields(Map<String, String> table) {
        List<String> result = new ArrayList<>();
        HashMap<String, StringSupplier> actionsWorkTypeMap = getTxtFields();
        table.keySet().forEach(key -> result.add(actionsWorkTypeMap.get(key).getAsString()));
        return result;
    }

    /**
     * Gets text fields of workType.
     *
     * @return a map with methods of CreatedWorkType
     */
    private HashMap<String, StringSupplier> getTxtFields() {
        HashMap<String, StringSupplier> mapValues = new HashMap<>();
        mapValues.put("Work Type Name", this::getNameOfWorkType);
        mapValues.put("Estimated Duration", this::getEstimatedDuration);
        return mapValues;
    }
}
