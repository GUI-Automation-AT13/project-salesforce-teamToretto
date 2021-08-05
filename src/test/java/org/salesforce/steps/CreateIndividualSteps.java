/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

import core.selenium.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import salesforce.ui.PageTransporter;
import salesforce.ui.entities.IndividualEntity;
import salesforce.ui.pages.lightning.individuals.IndividualFormPage;
import salesforce.ui.pages.lightning.individuals.IndividualListPage;
import salesforce.ui.pages.lightning.individuals.IndividualRecordPage;
public class CreateIndividualSteps {

    private WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;
    private SoftAssert softAssert;
    private IndividualFormPage individualFormPage;
    private IndividualEntity individualEntity;

    public CreateIndividualSteps(final WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(webDriverManager);
        this.softAssert = new SoftAssert();
    }
    @Given("^I go to the new Individual formular$")
    public void iGoToTheNewIndividualFormular() {
        System.out.println("==================GO TO NEW INDIVIDUAL PAGE====================");
        individualFormPage = pageTransporter.navigateToIndividualFormPage();
    }

    @When("^I create an Individual with the following values$")
    public void iCreateAnIndividualWithTheFollowingValues(final Map<String, String> table) {
        System.out.println("==================CREATE INDIVIDUAL ENTITY====================");
        ObjectMapper objectMapper = new ObjectMapper();
        individualEntity = objectMapper.convertValue(table, IndividualEntity.class);
        individualFormPage.createIndividual(table.keySet(), individualEntity);
    }

    @When("^I set the lastname \"(.*?)\"$")
    public void iSetTheEntityValues(String name) {
        individualFormPage.setLastnameTextbox(name);
        individualFormPage.clickOnsave();
    }

    @When("^I create an individual$")
    public void iCreateAnIndividual(final Map<String, String> table) {
        ObjectMapper objectMapper = new ObjectMapper();
        individualEntity = objectMapper.convertValue(table, IndividualEntity.class);
        individualFormPage.createIndividual(table.keySet(), individualEntity);
    }

    @Then("^The Individual's name is displayed in the header$")
    public void theIndividualsNameIsDisplayedInTheHeader() {
        String resultMessage = individualFormPage.getCreatedSuccessMessage();
        Assert.assertTrue(resultMessage.contains("was created."));
    }

    @Then("^The name displayed should contain (.*) (.*) and (.*)$")
    public void theNameDisplayedShouldContain(final String salutation, final String firstname, final String lastname) {
        IndividualRecordPage individualRecordPage = new IndividualRecordPage(webDriverManager);
        String headerNameText = individualRecordPage.getNameHeaderText();
        String fullnameWithSalutation = String.format("%s %s %s", salutation, firstname, lastname);
        Assert.assertEquals(headerNameText, fullnameWithSalutation);
    }

    @Then("^The created individual details should match the given values$")
    public void theCreatedIndividualDetailsShouldMatchTheGivenValues() {
        IndividualRecordPage individualRecordPage = new IndividualRecordPage(webDriverManager);
        individualRecordPage.clickonDetailsTab();
        String nameDetail = individualRecordPage.getNameDetail();
        Assert.assertEquals(nameDetail, individualEntity.getFullnameWithSalutation());
    }

    @Then("^The Individual List Page should contain a record with (.*) and (.*)$")
    public void theIndividualListPageShouldContainArecordWith(final String firstname, final String lastname) {
        IndividualListPage individualListPage = pageTransporter.navigateToIndividualListPage();
        Assert.assertTrue(individualListPage.isThereRecordWithName(firstname.concat(" ").concat(lastname)));
    }

    @Then("^The Individual Records Page should contain a record with (.*) and (.*)$")
    public void theIndividualRecordsPageShouldContainArecordWith(final String firstname, final String lastname) {
        IndividualListPage individualListPage = pageTransporter.navigateToIndividualListPage();
        Assert.assertTrue(individualListPage.isThereRecordWithName(firstname.concat(" ").concat(lastname)));
    }
}
