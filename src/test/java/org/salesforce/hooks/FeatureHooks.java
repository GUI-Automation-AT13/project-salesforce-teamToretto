package org.salesforce.hooks;

import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiResponse;
import core.utils.ExtractIds;
import core.utils.PropertiesReader;
import core.utils.SelectFeature;
import io.cucumber.java.After;
import salesforce.api.ApiEndPoints;
import salesforce.api.Authentication;
import salesforce.api.entities.Response;
import com.google.common.net.HttpHeaders;
import java.util.List;
import java.util.Properties;
import static salesforce.api.Authentication.token;

public class FeatureHooks {
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private Response response;
    public Authentication authentication = new Authentication();

    public FeatureHooks(ApiRequest apiRequest, ApiResponse apiResponse, Response response) {
        this.apiRequest = apiRequest;
        this.apiResponse = apiResponse;
        this.response = response;
    }

    @After(value = "@DeleteCampaign")
    public void deleteCampaigns() {
        apiRequest = new ApiRequest();
        Properties properties = PropertiesReader.getProperties("config.properties");
        authentication.getAuth();
        apiRequest.addHeader("Content-Type", "application/json")
                .addHeader(HttpHeaders.AUTHORIZATION, token.getTokenType() + " " + token.getAccessToken())
                .setBaseUri(token.getInstanceUrl() + properties.getProperty("SERVICE")
                        + properties.getProperty("VERSION"));
        apiRequest.clearPathParam();
        apiRequest.method(ApiMethod.GET)
                .endpoint(ApiEndPoints.LIST_CAMPAIGN_ID);
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        String resultAsSting = apiResponse.getResponse().asString();
        listOfIds(resultAsSting, "CAMPAIGN_ID");
    }

    @After(value = "@DeleteContract")
    public void deleteContracts() {
        apiRequest = new ApiRequest();
        Properties properties = PropertiesReader.getProperties("config.properties");
        authentication.getAuth();
        apiRequest.addHeader("Content-Type", "application/json")
                .addHeader(HttpHeaders.AUTHORIZATION, token.getTokenType() + " " + token.getAccessToken())
                .setBaseUri(token.getInstanceUrl() + properties.getProperty("SERVICE")
                        + properties.getProperty("VERSION"));
        apiRequest.clearPathParam();
        apiRequest.method(ApiMethod.GET)
                .endpoint(ApiEndPoints.LIST_CONTRACT_ID);
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        String resultAsSting = apiResponse.getResponse().asString();
        listOfIds(resultAsSting, "CONTRACT_ID");
    }

    @After(value = "@DeleteWorkType")
    public void deleteWorkType() {
        apiRequest = new ApiRequest();
        Properties properties = PropertiesReader.getProperties("config.properties");
        authentication.getAuth();
        apiRequest.addHeader("Content-Type", "application/json")
                .addHeader(HttpHeaders.AUTHORIZATION, token.getTokenType() + " " + token.getAccessToken())
                .setBaseUri(token.getInstanceUrl() + properties.getProperty("SERVICE")
                        + properties.getProperty("VERSION"));
        apiRequest.clearPathParam();
        apiRequest.method(ApiMethod.GET)
                .endpoint(ApiEndPoints.LIST_WORKTYPE_ID);
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        String resultAsSting = apiResponse.getResponse().asString();
        listOfIds(resultAsSting, "WORKTYPE_ID");
    }

    @After(value = "@DeleteIndividual")
    public void deleteIndividual() {
        apiRequest = new ApiRequest();
        Properties properties = PropertiesReader.getProperties("config.properties");
        authentication.getAuth();
        apiRequest.addHeader("Content-Type", "application/json")
                .addHeader(HttpHeaders.AUTHORIZATION, token.getTokenType() + " " + token.getAccessToken())
                .setBaseUri(token.getInstanceUrl() + properties.getProperty("SERVICE")
                        + properties.getProperty("VERSION"));
        apiRequest.clearPathParam();
        apiRequest.method(ApiMethod.GET)
                .endpoint(ApiEndPoints.LIST_INDIVIDUAL_ID);
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        String resultAsSting = apiResponse.getResponse().asString();
        listOfIds(resultAsSting, "INDIVIDUAL_ID");
    }

    public void listOfIds(String resultAsSting, String nameFeature) {
        List<String> ids = ExtractIds.extractIdsFromJson(resultAsSting);
        for ( String id : ids) {
            deleteListFeature(id, nameFeature);
        }
    }

    public void deleteListFeature(String id, String nameFeature) {
        SelectFeature selectFeature = new SelectFeature();
        apiRequest.clearPathParam();
        apiRequest.method(ApiMethod.DELETE)
                .endpoint(selectFeature.selectNameFeature(nameFeature))
                .addPathParam(nameFeature, id);
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
    }
}

