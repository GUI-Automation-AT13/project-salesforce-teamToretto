package org.salesforce.hooks;

import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiResponse;
import core.utils.PropertiesReader;
import core.utils.SelectFeature;
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

public class FeatureHooks {
    private Logger LOGGER = Logger.getLogger(getClass());
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private Response response;
    public Authentication authentication = new Authentication();

    public FeatureHooks(ApiRequest apiRequest, ApiResponse apiResponse, Response response) {
        LOGGER.info("------ Campaign hook constructor ------");
        this.apiRequest = apiRequest;
        this.apiResponse = apiResponse;
        this.response = response;
    }

    @After(value = "@DeleteCampaign")
    public void getIdFeatures() {
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
        String s2 = apiResponse.getResponse().asString();
        listOfIds(s2, "CAMPAIGN");
    }

    public void listOfIds(String s2, String nameFeature) {
        List<String> ids = extractIdsFromJson(s2);
        for ( String id : ids) {
            System.out.println(id);
            deleteCampaign(id);
        }
    }

    public void deleteCampaign(String id) {
        SelectFeature selectFeature = new SelectFeature();
        System.out.println("//////////////////////////////////////");
        System.out.println("//////////////////////////////////////");
        System.out.println("//////////////////////////////////////");
        System.out.println("//////////////////////////////////////");
        System.out.println(ApiEndPoints.CAMPAIGN_ID.getClass().toString());
        apiRequest.clearPathParam();
        apiRequest.method(ApiMethod.DELETE)
                .endpoint(selectFeature.selectNameFeature())
                .addPathParam("CAMPAIGN_ID", id);
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
    }

    public static List<String> extractIdsFromJson(String json) {
        List<String> list = new ArrayList<String>();
        Matcher matcher = Pattern.compile("\"Id\":\"(.*?)\"").matcher(json);
        while (matcher.find())
            list.add(String.valueOf(matcher.group(1)));
        return list;
    }
}

