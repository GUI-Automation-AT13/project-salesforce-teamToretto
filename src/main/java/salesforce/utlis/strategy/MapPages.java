package salesforce.utlis.strategy;

import salesforce.ui.pages.lightning.contracts.ContractsPage;
import salesforce.ui.pages.lightning.worktype.WorkTypesPage;

public class MapPages {

    /**
     * Creates a object to features page.
     *
     * @param featureName name of feature
     * @return object feature page
     */
    public IFeaturesPage featuresPage(final String featureName) {
        switch (featureName) {
            case "workType":
                return new WorkTypesPage();
            case "contract":
                return new ContractsPage();
            default:
                return new WorkTypesPage();
        }
    }
}

