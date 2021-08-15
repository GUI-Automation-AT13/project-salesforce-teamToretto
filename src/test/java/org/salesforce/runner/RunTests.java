package org.salesforce.runner;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.api.ApiFacade;
import core.api.ApiResponse;
import core.utils.ReportGenerator;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import salesforce.api.ApiEndPoints;
import salesforce.api.Authentication;
import salesforce.api.entities.Account;
import salesforce.api.entities.Contact;
import salesforce.api.entities.PriceBook;
import salesforce.api.entities.Response;

/**
 * This class runs all scenarios on the feature folder.
 */
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"html:build/cucumber/cucumber-pretty.html", "json:build/cucumber/cucumber.json"},
        tags = "@RegressionTest",
        glue = {"org.salesforce"}
)
public class RunTests extends AbstractTestNGCucumberTests {
    public Logger logger = LogManager.getLogger(getClass());
    public Authentication authentication = new Authentication();
    public ApiResponse apiResponse;
    public Account account;
    public Contact contact;
    public PriceBook priceBook;
    public ApiFacade apiFacade;

    /**
     * This class defines if scenarios runs in parallel or not.
     */
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    /**
     * Logins via api to set the base environment.
     */
    @BeforeTest
    public void loginAndSetup() {
        logger.info("----------- Login And Setup -----------");
        Authentication.getAuth();
        apiFacade = new ApiFacade();
    }

    /**
     * Cleans the environment after the test.
     */
    @AfterTest(dependsOnMethods = {"deleteAccount", "deleteContact", "deletePriceBook"})
    public void afterExecution() {
        apiFacade = new ApiFacade();
    }

    /**
     * Deletes an account after the test via api.
     */
    @AfterTest
    public void deleteAccount() {
        logger.info("----------- Delete a Account feature -----------");
        apiFacade.deleteObject("ACCOUNT_ID", account.getId(), ApiEndPoints.ACCOUNT_ID);
    }

    /**
     * Deletes a contact after the test via api.
     */
    @AfterTest(dependsOnMethods = "deleteAccount")
    public void deleteContact() {
        logger.info("----------- Delete a Contact feature -----------");
        apiFacade.deleteObject("CONTACT_ID", contact.getId(), ApiEndPoints.CONTACT_ID);

    }

    /**
     * Deletes a price book after the test via api.
     */
    @AfterTest(dependsOnMethods = {"deleteAccount", "deleteContact"})
    public void deletePriceBook() {
        logger.info("----------- Delete a Contact feature -----------");
        apiFacade.deleteObject("PRICEBOOK_ID", priceBook.getId(), ApiEndPoints.PRICEBOOK_ID);
    }

    /**
     * Creates an account before the test via api.
     */
    @BeforeTest(dependsOnMethods = "loginAndSetup")
    public void createAccount() throws JsonProcessingException {
        logger.info("----------- Create a Account feature -----------");
        account = new Account();
        account.setName("TestAccount");
        apiResponse = apiFacade.createObject(account, ApiEndPoints.ACCOUNT);
        account.setId(apiResponse.getBody(Response.class).getId());
    }

    /**
     * Creates a contact before the test via api.
     */
    @BeforeTest(dependsOnMethods = "loginAndSetup")
    public void createContact() throws JsonProcessingException {
        logger.info("----------- Create a Contact feature -----------");
        contact = new Contact();
        contact.setLastName("TestContact");
        apiResponse = apiFacade.createObject(contact, ApiEndPoints.CONTACT);
        contact.setId(apiResponse.getBody(Response.class).getId());
    }

    /**
     * Creates a price book before the test via api.
     */
    @BeforeTest(dependsOnMethods = "loginAndSetup")
    public void createPriceBook() throws JsonProcessingException {
        logger.info("----------- Create a Price Book feature -----------");
        priceBook = new PriceBook();
        priceBook.setName("Standard");
        apiResponse = apiFacade.createObject(priceBook, ApiEndPoints.PRICEBOOK);
        priceBook.setId(apiResponse.getBody(Response.class).getId());
        apiResponse = apiFacade
                .patchObject("PRICEBOOK_ID", "{\"IsActive\": \"true\"}", priceBook.getId(), ApiEndPoints.PRICEBOOK_ID);
    }

    /**
     * Generates the cucumber report after the test suite.
     */
    @AfterSuite
    public void createReports() {
        ReportGenerator.generateReport();
    }
}
