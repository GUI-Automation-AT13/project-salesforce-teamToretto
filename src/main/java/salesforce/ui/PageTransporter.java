/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui;

import core.selenium.WebDriverManager;
import salesforce.config.EnvConfig;
import salesforce.ui.pages.classic.contracts.ClassicContractsPage;
import salesforce.ui.pages.lightning.LoginPage;
import salesforce.ui.pages.lightning.contracts.ContractsPage;
import salesforce.ui.pages.lightning.individuals.IndividualFormPage;
import salesforce.ui.pages.lightning.individuals.IndividualListPage;

/**
 * Navigates to a page's url.
 */
public class PageTransporter {

    private String baseUrl = EnvConfig.getInstance().getBaseUrl();

    public LoginPage navigateToLoginPage() {
        goToUrl(baseUrl);
        return new LoginPage();
    }

    /**
     * Goes directly to a page by an url.
     *
     * @param url to go.
     */
    public void goToUrl(final String url) {
        WebDriverManager.getInstance().getWebDriver().navigate().to(url);
    }

    /**
     * Navigates to Contracts page.
     *
     * @return Contracts' instance.
     */
    public ClassicContractsPage navigateToContractsPage() {
        goToUrl(baseUrl.concat("800/o"));
        return new ClassicContractsPage();
    }

    /**
     * Navigates to Contracts page on lightning version.
     *
     * @return Contracts' instance.
     */
    public ContractsPage navigateToContractsPageLightning() {
        goToUrl(baseUrl.concat("lightning/o/Contract/list?filterName=Recent"));
        return new ContractsPage();
    }

    /**
     * Navigates to the individual form page.
     *
     * @return IndividualFormPage
     */
    public IndividualFormPage navigateToIndividualFormPage() {
        goToUrl(baseUrl.concat("lightning/o/Individual/new?count=1"));
        return new IndividualFormPage();
    }

    /**
     * Navigates to the individual list page.
     *
     * @return IndividualListPage
     */
    public IndividualListPage navigateToIndividualListPage() {
        goToUrl(baseUrl.concat("lightning/o/Individual/list?filterName=Recent"));
        return new IndividualListPage();
    }
}
