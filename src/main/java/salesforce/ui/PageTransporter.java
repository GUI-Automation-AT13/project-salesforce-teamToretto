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
import salesforce.ui.pages.lightning.contracts.ContractsPage;
import salesforce.ui.pages.lightning.worktype.WorkTypesPage;

/**
 * Navigates to a page's url.
 */
public class PageTransporter {

    private String baseUrl = EnvConfig.getInstance().getBaseUrl();

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
     * Navigates to WorkType page on lightning version.
     *
     * @return Contracts' instance.
     */
    public WorkTypesPage navigateToWorkTypePageLightning() {
        goToUrl(baseUrl.concat("lightning/o/WorkType/list?filterName=00B5e00000CELgSEAX"));
        return new WorkTypesPage();
    }

    /**
     * Navigates to WorkType page on lightning version.
     *
     */
    public void navigateToWorkTypePageLightningDirect() {
        goToUrl(baseUrl.concat("lightning/o/WorkType/list?filterName=00B5e00000CELgSEAX"));
    }
}
