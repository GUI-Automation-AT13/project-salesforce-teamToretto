package base;

import api.ApiManager;
import api.ApiMethod;
import api.ApiRequest;
import api.ApiResponse;
import api.salesforce.ApiEndPoints;
import api.salesforce.Authentication;
import api.salesforce.entities.Account;
import api.salesforce.entities.Contact;
import api.salesforce.entities.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.utils.PropertiesReader;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.util.Properties;

import static api.salesforce.Authentication.token;

public class ContractBaseTest extends BaseTests {
    public ApiRequest apiRequest;
    public ApiResponse apiResponse;
    public Authentication authentication = new Authentication();
    public Account account;
    public Contact contact;

    @BeforeClass
    public void loginAndSetup() {
        apiRequest = new ApiRequest();
        Properties properties = PropertiesReader.getProperties("config.properties");
        authentication.getAuth();
        apiRequest.addHeader("Content-Type", "application/json")
                .addHeader(HttpHeaders.AUTHORIZATION, token.getTokenType() + " " + token.getAccessToken())
                .setBaseUri(token.getInstanceUrl() + properties.getProperty("SERVICE")
                        + properties.getProperty("VERSION"));
    }
    @BeforeMethod(onlyForGroups = {"CreateContractWithFullValues", "CreateContractWithMinimumValues"})
    public void beforeCreateAccount() throws JsonProcessingException {
        account = new Account();
        account.setName("TestAccount");
        apiRequest.method(ApiMethod.POST)
                .endpoint(ApiEndPoints.ACCOUNT)
                .body(new ObjectMapper().writeValueAsString(account));

        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
        apiResponse.getResponse().then().log().body();
        account.setId(apiResponse.getBody(Response.class).getId());
    }
    @BeforeMethod(onlyForGroups = {"CreateContractWithFullValues"})
    public void beforeCreateContact() throws JsonProcessingException {
        contact = new Contact();
        contact.setLastName("TestContact");
        contact.setEmail("jala@mail.com");
        apiRequest.method(ApiMethod.POST)
                .endpoint(ApiEndPoints.CONTACT)
                .body(new ObjectMapper().writeValueAsString(contact));

        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED);
        apiResponse.getResponse().then().log().body();
        contact.setId(apiResponse.getBody(Response.class).getId());
    }

    @AfterMethod(onlyForGroups = {"CreateContractWithFullValues","CreateContractWithMinimumValues"})
    public void afterDeleteAccount() {
        apiRequest.clearPathParam();
        apiRequest.method(ApiMethod.DELETE)
                .endpoint(ApiEndPoints.ACCOUNT_ID)
                .addPathParam("ACCOUNT_ID", account.getId());

        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
        apiResponse.getResponse().then().log().body();
    }
    @AfterMethod(onlyForGroups = {"CreateContractWithFullValues"})
    public void afterDeleteContact() {
        apiRequest.clearPathParam();
        apiRequest.method(ApiMethod.DELETE)
                .endpoint(ApiEndPoints.CONTACT_ID)
                .addPathParam("CONTACT_ID", contact.getId());

        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
        apiResponse.getResponse().then().log().body();
    }
    @AfterClass
    public void AfterRequest() {
        apiRequest = new ApiRequest();
    }
}
