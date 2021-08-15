/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce.steps;

import core.api.ApiFacade;
import core.selenium.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import salesforce.utils.PageTransporter;
import salesforce.ui.pages.lightning.search.SearchResultsPage;
import salesforce.utils.Internalization;
import salesforce.utils.strategy.MapPages;

public class SearchSteps {

    private Logger log = LogManager.getLogger(getClass());
    private WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;
    private SoftAssert softAssert;
    private Internalization internalization;
    private MapPages mapPages;
    private SearchResultsPage searchResultsPage;
    private ApiFacade apiFacade;

    public SearchSteps(final WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(this.webDriverManager);
        this.mapPages = new MapPages(this.webDriverManager);
        this.softAssert = new SoftAssert();
        searchResultsPage = pageTransporter.getSearchResultPage();
    }

    @Given("^I search the text \"(.*?)\" on the header's search box$")
    public void iSearchTheTextOnTheHeadersSearchBox(final String text) {
        log.info("Given Get Table Fields");
        searchResultsPage.search(text);
    }

    @Then("^The results should be displayed$")
    public void theResultsShouldBeDisplayed() {
        log.info("Then The results should be displayed");
        Assert.assertTrue(searchResultsPage.isThereResults());
    }

    @Then("^A message notifying that the search term is too short should be displayed$")
    public void aMessageNotifyingThatTheSearchTermIsTooShortShouldBeDisplayed() {
        log.info("Then a message notifying that the search term is too short should be displayed");
        String resultMessage = searchResultsPage.getNoSearchResultMessage();
        Assert.assertEquals(resultMessage, "Your search term must have 2 or more characters.");
    }

    @Then("^All the result record's names should contain the text \"(.*?)\"$")
    public void allTheResultRecordsNamesShouldContainTheText(final String text) {
        log.info("Then all the result record's names should contain the text: ".concat(text));
        boolean recordsContainText = searchResultsPage.doAllRecordsContainTheText(text);
        Assert.assertTrue(recordsContainText);
    }
}
