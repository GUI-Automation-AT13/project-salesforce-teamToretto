/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.utils;

import static core.utils.Converter.converterStringToEnum;

import core.config.EnvConfig;
import core.selenium.WebDriverManager;
import salesforce.ui.pages.classic.contracts.ClassicContractsPage;
import salesforce.ui.pages.lightning.LoginPage;
import salesforce.ui.pages.lightning.campaign.CampaignPage;
import salesforce.ui.pages.lightning.contracts.ContractsPage;
import salesforce.ui.pages.lightning.individuals.IndividualFormPage;
import salesforce.ui.pages.lightning.individuals.IndividualListPage;
import salesforce.ui.pages.lightning.search.SearchResultsPage;
import salesforce.ui.pages.lightning.worktype.WorkTypesPage;

/**
 * Navigates to a page's url.
 */
public class PageTransporter {

    private String baseUrl = EnvConfig.getInstance().getBaseUrl();
    private String featureUrl = Urls.FEATURE_URL_LIGHTNING.getValue();
    private PageUrl pageUrl;
    private WebDriverManager webDriverManager;

    public PageTransporter(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
    }

    public LoginPage navigateToLoginPage() {
        goToUrl(baseUrl);
        return new LoginPage(webDriverManager);
    }

    /**
     * Goes directly to a page by an url.
     *
     * @param url to go.
     */
    public void goToUrl(final String url) {
        webDriverManager.getWebDriver().navigate().to(url);
    }

    /**
     * Navigates to Contracts page.
     *
     * @return Contracts' instance.
     */
    public ClassicContractsPage navigateToContractsPage() {
        goToUrl(baseUrl.concat("800/o"));
        return new ClassicContractsPage(webDriverManager);
    }

    /**
     * Navigates to Contracts page on lightning version.
     *
     * @return Contracts' instance.
     */
    public ContractsPage navigateToContractsPageLightning() {
        goToUrl(baseUrl.concat("lightning/o/Contract/list?filterName=Recent"));
        return new ContractsPage(webDriverManager);
    }

    /**
     * Navigates to the individual form page.
     *
     * @return IndividualFormPage
     */
    public IndividualFormPage navigateToIndividualFormPage() {
        goToUrl(baseUrl.concat("lightning/o/Individual/new?count=1"));
        return new IndividualFormPage(webDriverManager);
    }

    /**
     * Navigates to the individual list page.
     *
     * @return IndividualListPage
     */
    public IndividualListPage navigateToIndividualListPage() {
        goToUrl(baseUrl.concat("lightning/o/Individual/list?filterName=Recent"));
        return new IndividualListPage(webDriverManager);
    }

    /**
     * Navigates to the Legal entities page.
     *
     * @return a CampaignPage.
     */
    public CampaignPage navigateToCampaignPage() {
        goToUrl(baseUrl.concat("lightning/o/Campaign/list?filterName=Recent"));
        return new CampaignPage(webDriverManager);
    }

    /**
     * Navigates to the Legal entities page.
     *
     * @return a CampaignPage.
     */
    public CampaignPage navigateTofeaturePage(String nameFeature) {
        goToUrl(pageUrl.getFeaturePage(nameFeature));
        if (nameFeature.equals("Campaign")) {
            return new CampaignPage(webDriverManager);
        }
        return null;
    }

    /**
     * Navigates to WorkType page on lightning version.
     *
     * @return Contracts' instance.
     */
    public WorkTypesPage navigateToWorkTypePageLightning() {
        goToUrl(baseUrl.concat("lightning/o/WorkType/list?filterName=00B5e00000CELgSEAX"));
        return new WorkTypesPage(webDriverManager);
    }

    /**
     * Navigates to WorkType page on lightning version.
     */
    public void navigateToWorkTypePageLightningDirect() {
        goToUrl(baseUrl.concat("lightning/o/WorkType/list?filterName=00B5e00000CELgSEAX"));
    }

    /**
     * Navigates to feature page on lightning version.
     */
    public void navigateToFeaturePage(String featureName) {
        if ("CLASSIC".equals(EnvConfig.getInstance().getSkin())) {
            goToUrl(converterStringToEnum(featureName, EnvConfig.getInstance().getSkin()).getValue());
        } else {
            goToUrl(baseUrl.concat(String.format(featureUrl, featureName)));
        }
    }

    public SearchResultsPage getSearchResultPage() {
        return new SearchResultsPage(webDriverManager);
    }

    /**
     * Navigates to personal information page on lightning version.
     */
    public void navigatePersonalInformation() {
        goToUrl(baseUrl.concat("lightning/settings/personal/PersonalInformation/home"));
    }
}
