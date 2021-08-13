/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.api;

import static salesforce.api.Authentication.token;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.config.EnvConfig;
import org.apache.http.HttpHeaders;
import salesforce.api.ApiEndPoints;
import salesforce.api.Authentication;

import java.util.Map;

/**
 * Performs create, delete, patch operations with the api library.
 */
public class ApiFacade {

    public ApiRequest apiRequest;
    public ApiResponse apiResponse;

    /**
     * ApiFacade constructor, initializes the apiRequest parameters.
     */
    public ApiFacade() {
        apiRequest = new ApiRequest();
        apiResponse = new ApiResponse();
        apiRequest.addHeader("Content-Type", "application/json")
                .addHeader(HttpHeaders.AUTHORIZATION, token.getTokenType() + " " + token.getAccessToken())
                .setBaseUri(token.getInstanceUrl() + EnvConfig.getInstance().getService()
                        + EnvConfig.getInstance().getVersion());
    }

    /**
     * Executes a request to get a token.
     */
    public void getAuth() {
        Authentication.getAuth();
    }

    /**
     * Creates an object for Salesforce.
     *
     * @param object represents the object to create
     * @param endPoint represents the objet's endpoint
     * @return an ApiResponse
     * @throws JsonProcessingException when the response is not a valid json
     */
    public ApiResponse createObject(final Object object, final ApiEndPoints endPoint) throws JsonProcessingException {
        apiRequest.method(ApiMethod.POST)
                .endpoint(endPoint)
                .body(new ObjectMapper().writeValueAsString(object));
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
        return apiResponse;
    }

    /**
     * Deletes an object of Salesforce.
     *
     * @param pathParam represents the object param.
     * @param id represents the object's id
     * @param endpoint is  the object's endpoint
     */
    public void deleteObject(final String pathParam, final String id, final ApiEndPoints endpoint) {
        apiRequest.clearPathParam();
        apiRequest.method(ApiMethod.DELETE)
                .endpoint(ApiEndPoints.ACCOUNT_ID)
                .addPathParam(pathParam, id);
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
    }

    /**
     * Patchs a Salesforce Object.
     *
     * @param pathParam represents the object param.
     * @param body represents the request's body
     * @param id represents the object's id
     * @param endPoint is  the object's endpoint
     * @return an ApiResponse
     */
    public ApiResponse patchObject(final String pathParam, final String body, final String id,
                                   final ApiEndPoints endPoint) {
        apiRequest.method(ApiMethod.PATCH)
                .endpoint(endPoint)
                .addPathParam(pathParam, id)
                .body(body);
        apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        return apiResponse;
    }
}
