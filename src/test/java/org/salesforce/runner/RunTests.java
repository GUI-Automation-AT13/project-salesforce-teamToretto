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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import salesforce.api.ApiEndPoints;
import salesforce.api.Authentication;
import salesforce.api.entities.Account;
import salesforce.api.entities.Contact;
import salesforce.api.entities.PriceBook;
import salesforce.api.entities.Response;

@CucumberOptions(
        features = {"src/test/resources/features/"},
        plugin = {"html:build/cucumber/cucumber-pretty.html", "json:build/cucumber/cucumber.json"},
        tags = "@RegressionTest",
        glue = {"org.salesforce"}
)
public class RunTests extends AbstractTestNGCucumberTests {

    public Logger LOGGER = LogManager.getLogger(getClass());
    public Authentication authentication = new Authentication();
    public ApiResponse apiResponse;
    public Account account;
    public Contact contact;
    public PriceBook priceBook;
    public ApiFacade apiFacade;

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios(){
        return super.scenarios();
    }

    @BeforeTest
    public void loginAndSetup() throws JsonProcessingException {
        LOGGER.info("----------- Login And Setup -----------");
        Authentication.getAuth();
        apiFacade = new ApiFacade();
    }

    @AfterTest(dependsOnMethods = {"deleteAccount", "deleteContact", "deletePriceBook"})
    public void afterExecution() {
        apiFacade = new ApiFacade();
    }

    @AfterTest
    public void deleteAccount() {
        LOGGER.info("----------- Delete a Account feature -----------");
        apiFacade.deleteObject("ACCOUNT_ID", account.getId(), ApiEndPoints.ACCOUNT_ID);
    }
    
    @AfterTest(dependsOnMethods = "deleteAccount")
    public void deleteContact() {
        LOGGER.info("----------- Delete a Contact feature -----------");
        apiFacade.deleteObject("CONTACT_ID", contact.getId(), ApiEndPoints.CONTACT_ID);

    }

    @AfterTest(dependsOnMethods = {"deleteAccount", "deleteContact"})
    public void deletePriceBook() {
        LOGGER.info("----------- Delete a Contact feature -----------");
        apiFacade.deleteObject("PRICEBOOK_ID", priceBook.getId(), ApiEndPoints.PRICEBOOK_ID);
    }

    @BeforeTest(dependsOnMethods = "loginAndSetup")
    public void createAccount() throws JsonProcessingException {
        LOGGER.info("----------- Create a Account feature -----------");
        account = new Account();
        account.setName("TestAccount");
        apiResponse = apiFacade.createObject(account, ApiEndPoints.ACCOUNT);
        account.setId(apiResponse.getBody(Response.class).getId());
    }

    @BeforeTest(dependsOnMethods = "loginAndSetup")
    public void createContact() throws JsonProcessingException {
        LOGGER.info("----------- Create a Contact feature -----------");
        contact = new Contact();
        contact.setLastName("TestContact");
        apiResponse = apiFacade.createObject(contact, ApiEndPoints.CONTACT);
        contact.setId(apiResponse.getBody(Response.class).getId());
    }

    @BeforeTest(dependsOnMethods = "loginAndSetup")
    public void createPriceBook() throws JsonProcessingException {
        LOGGER.info("----------- Create a Price Book feature -----------");
        priceBook = new PriceBook();
        priceBook.setName("Standard");
        apiResponse = apiFacade.createObject(priceBook, ApiEndPoints.PRICEBOOK);
        priceBook.setId(apiResponse.getBody(Response.class).getId());
        apiResponse = apiFacade.patchObject("PRICEBOOK_ID", "{\"IsActive\": \"true\"}", priceBook.getId(), ApiEndPoints.PRICEBOOK_ID);
    }

    @AfterSuite
    public void createReports(){
        ReportGenerator.generateReport();
    }
}
