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
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import salesforce.utils.PageTransporter;
import salesforce.ui.pages.lightning.search.SearchResultsPage;
import salesforce.utils.GeneratorUniqueString;
import salesforce.utils.Internalization;
import salesforce.utils.strategy.MapPages;

import java.util.Map;

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

    @Given("^I enter the text (.*?) on the header's search box$")
    public void iEnterTheTextOnTheHeadersSearchBox(final String text) {
        log.info("Given Get Table Fields");
        searchResultsPage.setTextToSearch(text);
    }

    @When("I press the Enter key")
    public void iPressTheEnterKey() {
        log.info("When I press the Enter Key");
        searchResultsPage.pressEnter();
    }

    @Then("^All the result record's names should contain the text (.*?)$")
    public void allTheResultRecordsNamesShouldContainTheText(final String text) {
        log.info("Then all the result record's names should contain the text: ".concat(text));
        boolean recordsContainText = searchResultsPage.doAllRecordsContainTheText(text);
        Assert.assertTrue(recordsContainText);
    }

    @Then("^No results should be displayed for the (.*?) text$")
    public void noResultsShouldBeDisplayed(final String text) {
        log.info("Then no results should be displayed");
        boolean isThereResults;
        try {
            searchResultsPage.doAllRecordsContainTheText(text);
            isThereResults = true;
        } catch (Exception e) {
            isThereResults = false;
        }
        Assert.assertEquals(isThereResults, false);
    }
}
