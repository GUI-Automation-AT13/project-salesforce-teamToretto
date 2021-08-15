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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import salesforce.ui.pages.lightning.search.SearchResultsPage;
import salesforce.utils.PageTransporter;
import salesforce.utils.strategy.MapPages;

/**
 * This defines the search's feature steps.
 */
public class SearchSteps {

    private Logger log = LogManager.getLogger(getClass());
    private WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;
    private SoftAssert softAssert;
    private MapPages mapPages;
    private SearchResultsPage searchResultsPage;

    /**
     * This defines the search's feature steps.
     */
    public SearchSteps(final WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(this.webDriverManager);
        this.mapPages = new MapPages(this.webDriverManager);
        this.softAssert = new SoftAssert();
        searchResultsPage = pageTransporter.getSearchResultPage();
    }

    /**
     * Types a text on a search box.
     *
     * @param text to be searched.
     */
    @Given("^I enter the text (.*?) on the header's search box$")
    public void searchByText(final String text) {
        log.info("Given Get Table Fields");
        searchResultsPage.setTextToSearch(text);
    }

    /**
     * Types a text on a search box.
     */
    @When("I press the Enter key")
    public void pressTheEnterKey() {
        log.info("When I press the Enter Key");
        searchResultsPage.pressEnter();
    }

    /**
     * Verifies the results on a search.
     *
     * @param text to be verified with.
     */
    @Then("^All the result record's names should contain the text (.*?)$")
    public void verifyTheResultsContent(final String text) {
        log.info("Then all the result record's names should contain the text: ".concat(text));
        boolean recordsContainText = searchResultsPage.doAllRecordsContainTheText(text);
        Assert.assertTrue(recordsContainText);
    }

    /**
     * Verifies that there are no values with an invalid search.
     *
     * @param text to be verified with.
     */
    @Then("^No results should be displayed for the (.*?) text$")
    public void verifyResultsOnInvalidSearch(final String text) {
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
