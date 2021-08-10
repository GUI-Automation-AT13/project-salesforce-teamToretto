package org.salesforce.runner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiResponse;
import core.utils.PropertiesReader;
import core.utils.ReportGenerator;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.http.HttpHeaders;
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
import static salesforce.api.Authentication.token;
import java.util.Properties;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"html:target/site/cucumber-pretty.html", "json:target/cucumber.json"},
        glue = {"org.salesforce"}
)
public class RunTests extends AbstractTestNGCucumberTests {
    public Logger LOGGER = LogManager.getLogger(getClass());
    public ApiRequest apiRequest;
    public Authentication authentication = new Authentication();
    public ApiResponse apiResponse;
    public Account account;
    public Contact contact;
    public PriceBook priceBook;

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios(){
        return super.scenarios();
    }

    @BeforeTest
    public void loginAndSetup() throws JsonProcessingException {
        LOGGER.info("----------- Login And Setup -----------");
        apiRequest = new ApiRequest();
        Properties properties = PropertiesReader.getProperties("config.properties");
        authentication.getAuth();
        apiRequest.addHeader("Content-Type", "application/json")
                .addHeader(HttpHeaders.AUTHORIZATION, token.getTokenType() + " " + token.getAccessToken())
                .setBaseUri(token.getInstanceUrl() + properties.getProperty("SERVICE")
                        + properties.getProperty("VERSION"));
    }

    @AfterTest(dependsOnMethods = {"deleteAccount", "deleteContact", "deletePriceBook"})
    public void afterExecution() {
        apiRequest = new ApiRequest();
    }

    @AfterTest
    public void deleteAccount() {
        LOGGER.info("----------- Delete a Account feature -----------");
        apiRequest.clearPathParam();
        apiRequest.method(ApiMethod.DELETE)
                .endpoint(ApiEndPoints.ACCOUNT_ID)
                .addPathParam("ACCOUNT_ID", account.getId());
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
    }
    
    @AfterTest(dependsOnMethods = "deleteAccount")
    public void deleteContact() {
        LOGGER.info("----------- Delete a Contact feature -----------");
        apiRequest.clearPathParam();
        apiRequest.method(ApiMethod.DELETE)
                .endpoint(ApiEndPoints.CONTACT_ID)
                .addPathParam("CONTACT_ID", contact.getId());
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
    }

    @AfterTest(dependsOnMethods = {"deleteAccount", "deleteContact"})
    public void deletePriceBook() {
        LOGGER.info("----------- Delete a Contact feature -----------");
        apiRequest.clearPathParam();
        apiRequest.method(ApiMethod.DELETE)
                .endpoint(ApiEndPoints.PRICEBOOK_ID)
                .addPathParam("PRICEBOOK_ID", priceBook.getId());
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
    }

    @BeforeTest(dependsOnMethods = "loginAndSetup")
    public void createAccount() throws JsonProcessingException {
        LOGGER.info("----------- Create a Account feature -----------");
        account = new Account();
        account.setName("TestAccount");
        apiRequest.method(ApiMethod.POST)
                .endpoint(ApiEndPoints.ACCOUNT)
                .body(new ObjectMapper().writeValueAsString(account));
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
        account.setId(apiResponse.getBody(Response.class).getId());
    }

    @BeforeTest(dependsOnMethods = "loginAndSetup")
    public void createContact() throws JsonProcessingException {
        LOGGER.info("----------- Create a Contact feature -----------");
        contact = new Contact();
        contact.setLastName("TestContact");
        apiRequest.method(ApiMethod.POST)
                .endpoint(ApiEndPoints.CONTACT)
                .body(new ObjectMapper().writeValueAsString(contact));
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
        contact.setId(apiResponse.getBody(Response.class).getId());
    }

    @BeforeTest(dependsOnMethods = "loginAndSetup")
    public void createPriceBook() throws JsonProcessingException {
        LOGGER.info("----------- Create a Price Book feature -----------");
        priceBook = new PriceBook();
        priceBook.setName("Standard");
        apiRequest.method(ApiMethod.POST)
                .endpoint(ApiEndPoints.PRICEBOOK)
                .body(new ObjectMapper().writeValueAsString(priceBook));
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
        priceBook.setId(apiResponse.getBody(Response.class).getId());
        apiRequest.method(ApiMethod.PATCH)
                .endpoint(ApiEndPoints.PRICEBOOK_ID)
                .addPathParam("PRICEBOOK_ID", priceBook.getId())
                .body("{\"IsActive\": \"true\"}");
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
    }
    @AfterSuite
    public void createReports(){
        ReportGenerator.generateReport();
    }
}
