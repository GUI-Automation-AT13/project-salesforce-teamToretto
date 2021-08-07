/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce.steps;

import core.selenium.WebDriverManager;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.lightning.search.SearchResultsPage;
import salesforce.utils.Internalization;
import salesforce.utils.strategy.MapPages;

public class SearchBarSteps {

    private Logger log = Logger.getLogger(getClass());
    private WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;
    private SoftAssert softAssert;
    private Internalization internalization;
    private MapPages mapPages;

    public SearchBarSteps(final WebDriverManager webDriverManager) {
        log.info("GeneralHooks featureSteps");
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(this.webDriverManager);
        this.mapPages = new MapPages(this.webDriverManager);
        this.softAssert = new SoftAssert();
    }

    @Given("I get table fields")
    public void iGetTableFields() {
        log.info("Navigate pages");
        SearchResultsPage searchResultsPage = pageTransporter.navigateToSearchResultPage();

        searchResultsPage.getTableRecords();

    }
}
