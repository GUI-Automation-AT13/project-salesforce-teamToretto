package org.salesforce.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.api.ApiFacade;
import core.selenium.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;
import salesforce.api.ApiEndPoints;
import salesforce.api.Authentication;
import salesforce.utils.PageTransporter;

public class ObjectsSteps {

    private Logger log = LogManager.getLogger(getClass());
    private WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;
    private SoftAssert softAssert;
    Map<String, String> bodyMap;
    private ApiFacade apiFacade;

    public ObjectsSteps(final WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(this.webDriverManager);
        Authentication.getAuth();
        this.apiFacade = new ApiFacade();
        this.softAssert = new SoftAssert();
    }

    @When("^I have an object (.*?) created with the following values$")
    public void iHaveAnObjectCreatedWithTheFollowingValues(final String object, final DataTable jsonData) throws JsonProcessingException {
        Map<String, String> json = jsonData.asMap(String.class, String.class);
        bodyMap = new HashMap<>(json);
        ApiEndPoints endPoint = ApiEndPoints.valueOf(object.toUpperCase());
        apiFacade.createObject(bodyMap, endPoint);
    }
}
