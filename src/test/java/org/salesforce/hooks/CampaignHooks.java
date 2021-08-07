package org.salesforce.hooks;

import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiResponse;
import core.utils.PropertiesReader;
import io.cucumber.java.After;
import org.apache.log4j.Logger;
import salesforce.api.ApiEndPoints;
import salesforce.api.Authentication;
import salesforce.api.entities.Response;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static salesforce.api.Authentication.token;

import static io.restassured.RestAssured.authentication;

public class CampaignHooks {
    private Logger LOGGER = Logger.getLogger(getClass());
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private Response response;
    public Authentication authentication = new Authentication();

    public CampaignHooks(ApiRequest apiRequest, ApiResponse apiResponse, Response response) {
        LOGGER.info("------ Campaign hook constructor ------");
        this.apiRequest = apiRequest;
        this.apiResponse = apiResponse;
        this.response = response;
    }

//    @Before(value = "@UseCreatedCampaign or @CreateCampaign")
//    public void createCampaign() throws JsonProcessingException {
//        LOGGER.info("------ Create a campaign ------");
//        Campaign newCampaign = new Campaign();
//        newCampaign.setName("New Campaign");
//        apiRequest.method(ApiMethod.POST)
//                .endpoint(ApiEndPoints.CAMPAIGN)
//                .body(new ObjectMapper().writeValueAsString(newCampaign));
//        ApiManager.execute(apiRequest, apiResponse);
//        response.setId(apiResponse.getBody(Response.class).getId());
//    }

    @After(value = "@DeleteCampaign")
    public void deleteCampaign() {
        apiRequest = new ApiRequest();
        Properties properties = PropertiesReader.getProperties("config.properties");
        authentication.getAuth();
        apiRequest.addHeader("Content-Type", "application/json")
                .addHeader(HttpHeaders.AUTHORIZATION, token.getTokenType() + " " + token.getAccessToken())
                .setBaseUri(token.getInstanceUrl() + properties.getProperty("SERVICE")
                        + properties.getProperty("VERSION"));
        apiRequest.clearPathParam();
        apiRequest.method(ApiMethod.DELETE)
                .endpoint(ApiEndPoints.CAMPAIGN_ID)
                .addPathParam("CAMPAIGN_ID", "7015e0000001O96AAE");
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        System.out.println("*****************************************");
        System.out.println("*****************************************");
        System.out.println("*****************************************");
        System.out.println("*****************************************");
//        System.out.println(getIdFeatures().getResponse().then().log().body());
//        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
//        apiResponse.getResponse().then().log().body();
        System.out.println(getIdFeatures().getResponse().then().log().body());
    }

    public ApiResponse getIdFeatures() {
        apiRequest = new ApiRequest();
        Properties properties = PropertiesReader.getProperties("config.properties");
        authentication.getAuth();
        apiRequest.addHeader("Content-Type", "application/json")
                .addHeader(HttpHeaders.AUTHORIZATION, token.getTokenType() + " " + token.getAccessToken())
                .setBaseUri(token.getInstanceUrl() + properties.getProperty("SERVICE")
                        + properties.getProperty("VERSION"));
        apiRequest.clearPathParam();
        apiRequest.method(ApiMethod.GET)
                .endpoint(ApiEndPoints.FEATURE_ID);
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
//        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
//        apiResponse.getResponse().then().log().body();
        System.out.println("//////////////////////////////////////");
        System.out.println("//////////////////////////////////////");
        System.out.println("//////////////////////////////////////");
        System.out.println(apiResponse.getResponse().then().log().toString().getClass().getSimpleName());
//        System.out.println(apiResponse.getResponse().then().log().toString().getClass().getSimpleName());
//        System.out.println(apiResponse.getResponse().then().log().toString().charAt(0));
//        System.out.println(apiResponse.getResponse().then().log().toString().charAt(apiResponse.getResponse().then().log().toString().length()-1));

//        JSONObject obj = new JSONObject(apiResponse.getResponse().then().log().toString());
//        JSONParser parser = new JSONParser();
//        JSONObject json = (JSONObject) parser.parse(apiResponse.getResponse().then().log().toString());
//
//        List exampeList = extractIdsFromJson(json.toString());

//        System.out.println("+++++++++++++++++++++++++++++++++");
//        System.out.println(exampeList.get(0));
        return apiResponse;
    }


    public List<Long> extractIdsFromJson(String json) {
        List<Long> list = new ArrayList<Long>();
        Matcher matcher = Pattern.compile("\"Id\":\"?(\\d+)\"?").matcher(json);
        while (matcher.find())
            list.add(Long.valueOf(matcher.group(1)));
        return list;
    }
}

