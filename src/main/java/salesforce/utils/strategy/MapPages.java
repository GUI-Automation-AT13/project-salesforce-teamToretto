/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.utils.strategy;

import org.openqa.selenium.InvalidArgumentException;
import salesforce.ui.pages.lightning.contracts.ContractsPage;
import salesforce.ui.pages.lightning.individuals.IndividualFormPage;
import salesforce.ui.pages.lightning.individuals.IndividualListPage;
import salesforce.ui.pages.lightning.worktype.WorkTypesPage;

/**
 * Create new instances object.
 */
public class MapPages {

    /**
     * Creates a object to features page.
     *
     * @param featureName name of feature
     * @return object feature page
     */
    public FeaturesPage featuresPage(final String featureName) {
        switch (featureName) {
            case "workType":
                return new WorkTypesPage();
            case "contract":
                return new ContractsPage();
            case "individual":
                return new IndividualListPage();
            default:
                throw new InvalidArgumentException("Invalid feature");
        }
    }
}

