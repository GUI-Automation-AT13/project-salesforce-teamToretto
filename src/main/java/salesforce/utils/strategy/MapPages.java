/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.utils.strategy;

import core.config.EnvConfig;
import core.selenium.WebDriverManager;
import org.openqa.selenium.InvalidArgumentException;
import salesforce.ui.pages.classic.worktype.WorkTypePage;
import salesforce.ui.pages.lightning.campaign.CampaignsPage;
import salesforce.ui.pages.lightning.contracts.ContractsPage;
import salesforce.ui.pages.lightning.individuals.IndividualsPage;
import salesforce.ui.pages.lightning.worktype.WorkTypesPage;

/**
 * Create new instances object.
 */
public class MapPages {
    private WebDriverManager webDriverManager;

    public MapPages(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
    }

    /**
     * Creates a object to features page.
     *
     * @param featureName name of feature
     * @return object feature page
     */
    public FeaturesPage featuresPage(final String featureName) {
        if ("CLASSIC".equals(EnvConfig.getInstance().getSkin())) {
            return featuresClassic(featureName);
        } else {
            return featuresLightning(featureName);
        }
    }

    /**
     * Creates a object to features page in mode Lightning.
     *
     * @param featureName name of feature
     * @return object feature page
     */
    private FeaturesPage featuresLightning(final String featureName) {
        switch (featureName) {
            case "WorkType":
                return new WorkTypesPage(webDriverManager);
            case "Contract":
                return new ContractsPage(webDriverManager);
            case "Individual":
                return new IndividualsPage(webDriverManager);
            case "Campaign":
                return new CampaignsPage(webDriverManager);
            default:
                throw new InvalidArgumentException("Invalid feature");
        }
    }

    /**
     * Creates a object to features page in mode Classic.
     *
     * @param featureName name of feature
     * @return object feature page
     */
    private FeaturesPage featuresClassic(final String featureName) {
        switch (featureName) {
            case "workType":
                return new WorkTypePage(webDriverManager);
            default:
                throw new InvalidArgumentException("Invalid feature");
        }
    }
}
