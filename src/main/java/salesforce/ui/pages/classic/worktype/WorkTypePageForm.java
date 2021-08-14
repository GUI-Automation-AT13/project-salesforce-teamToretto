package salesforce.ui.pages.classic.worktype;

import core.selenium.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.FeatureCreated;
import salesforce.utils.strategy.FeatureForm;
import salesforce.utils.supplier.VoidSupplier;

/**
 * This class has webElement for work types details.
 */
public class WorkTypePageForm extends BasePage implements FeatureForm {

    protected By nameTxtBox = By.id("Name");
    protected By estimatedDurationTxtBox = By.id("EstimatedDuration");
    protected By saveBtn = By.name("save");

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public WorkTypePageForm(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Sets on text of name field of workType.
     *
     * @param fieldValue is value to set on textBox
     */
    public void setNameTxtBox(final String fieldValue) {
        webDriverActions.setInputField(nameTxtBox, fieldValue);
    }

    /**
     * Sets on text of estimated duration field of workType.
     *
     * @param fieldValue is value to set on textBox
     */
    public void setEstimatedDurationTxtBox(final String fieldValue) {
        webDriverActions.setInputField(estimatedDurationTxtBox, fieldValue);
    }

    @Override
    public FeatureCreated clickSaveButton() {
        webDriverActions.clickByLocator(saveBtn);
        return new WorkTypeCreated(webDriverManager);
    }

    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(nameTxtBox);
    }

    @Override
    public void fillUpField(Map<String, String> table) {
        HashMap<String, VoidSupplier> actionsWorkTypeMap = mapActionsWorkType(table);
        table.keySet().forEach(key -> actionsWorkTypeMap.get(key).run());
    }

    /**
     * Saves actions in New work type page in map.
     *
     * @param workTypeMap is map
     * @return a map with action of fields
     */
    private HashMap<String, VoidSupplier> mapActionsWorkType(final Map<String, String> workTypeMap) {
        HashMap<String, VoidSupplier> mapActions = new HashMap<>();
        mapActions.put("Work Type Name", () -> setNameTxtBox(workTypeMap.get("Work Type Name")));
        mapActions.put("Estimated Duration", () -> setEstimatedDurationTxtBox(workTypeMap.get("Estimated Duration")));
        return mapActions;
    }
}
