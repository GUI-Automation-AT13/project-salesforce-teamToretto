package api;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import api.salesforce.ApiEndPoints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class builds an api request.
 */
public class ApiRequest {
    private String baseUri;
    private String endpoint;
    private String body;
    private String token;
    private Enum<ApiMethod> method;
    private List<Header> headers;
    private Map<String, String> queryParams;
    private Map<String, String> pathParams;
    private Map<String, String> params;

    /**
     * Constructor for build an api request.
     */
    public ApiRequest() {
        headers = new ArrayList<>();
        queryParams = new HashMap<>();
        pathParams = new HashMap<>();
        params = new HashMap<>();
    }

    /**
     * Gets the base uri.
     *
     * @return the baseUri.
     */
    public String getBaseUri() {
        return baseUri;
    }

    /**
     * Sets the base uri.
     *
     * @param newBaseUri to be set.
     */
    public void setBaseUri(final String newBaseUri) {
        this.baseUri = newBaseUri;
    }

    /**
     * Gets the end point.
     *
     * @return the endpoint.
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Sets the end point.
     *
     * @param newEndpoint to be set.
     */
    public void setEndpoint(final ApiEndPoints newEndpoint) {
        this.endpoint = newEndpoint.toEndpoint();
    }

    /**
     * Gets the body.
     *
     * @return the body.
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the body.
     *
     * @param newBody to be set.
     */
    public void setBody(final String newBody) {
        this.body = newBody;
    }

    /**
     * Gets the token.
     *
     * @return the token.
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token.
     *
     * @param newToken to be set.
     */
    public void setToken(final String newToken) {
        this.token = newToken;
    }

    /**
     * Gets the method.
     *
     * @return the method.
     */
    public Enum<ApiMethod> getMethod() {
        return method;
    }

    /**
     * Sets the method.
     *
     * @param newMethod to be set.
     */
    public void setMethod(final Enum<ApiMethod> newMethod) {
        this.method = newMethod;
    }

    /**
     * Sets the header values.
     *
     * @param header to be set.
     * @param value  to be set.
     */
    public void setHeader(final String header, final String value) {
        headers.add(new Header(header, value));
    }

    /**
     * Clear the query params map.
     */
    public void clearQueryParam() {
        queryParams.clear();
    }

    /**
     * Sets the query values.
     *
     * @param param to be set.
     * @param value to be set.
     */
    public void setQueryParam(final String param, final String value) {
        queryParams.put(param, value);
    }

    /**
     * Clear the path params map.
     */
    public void clearPathParam() {
        pathParams.clear();
    }

    /**
     * Sets the path param values.
     *
     * @param param to be set.
     * @param value to be set.
     */
    public void setPathParam(final String param, final String value) {
        pathParams.put(param, value);
    }

    /**
     * Clear the params map.
     */
    public void clearParam() {
        params.clear();
    }

    /**
     * Sets the param values.
     *
     * @param param to be set.
     * @param value to be set.
     */
    public void setParam(final String param, final String value) {
        params.put(param, value);
    }

    /**
     * Gets the headers.
     *
     * @return the headers.
     */
    public Headers getHeaders() {
        return new Headers(headers);
    }

    /**
     * Gets the queryParams.
     *
     * @return the queryParams.
     */
    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    /**
     * Gets the pathParams.
     *
     * @return the pathParams.
     */
    public Map<String, String> getPathParams() {
        return pathParams;
    }

    /**
     * Gets the params.
     *
     * @return the params.
     */
    public Map<String, String> getParams() {
        return params;
    }

    /**
     * Gets the apiRequest.
     *
     * @param newBaseUri to be set.
     * @return tha apiRequest with base uri.
     */
    public ApiRequest baseUri(final String newBaseUri) {
        this.setBaseUri(baseUri);
        return this;
    }

    /**
     * Gets the apiRequest.
     *
     * @param newEndpoint to be set.
     * @return tha apiRequest end point.
     */
    public ApiRequest endpoint(final ApiEndPoints newEndpoint) {
        this.setEndpoint(newEndpoint);
        return this;
    }

    /**
     * Gets the apiRequest.
     *
     * @param newBody to be set.
     * @return tha apiRequest body.
     */
    public ApiRequest body(final String newBody) {
        this.setBody(newBody);
        return this;
    }

    /**
     * Gets the apiRequest.
     *
     * @param newToken to be set.
     * @return tha apiRequest token.
     */
    public ApiRequest token(final String newToken) {
        this.setToken(newToken);
        return this;
    }

    /**
     * Gets the apiRequest.
     *
     * @param newMethod to be set.
     * @return tha apiRequest method.
     */
    public ApiRequest method(final Enum<ApiMethod> newMethod) {
        this.setMethod(newMethod);
        return this;
    }

    /**
     * Gets the apiRequest.
     *
     * @param header to be set.
     * @param value  to be set.
     * @return tha apiRequest header.
     */
    public ApiRequest addHeader(final String header, final String value) {
        this.setHeader(header, value);
        return this;
    }

    /**
     * Gets the apiRequest.
     *
     * @param param to be set.
     * @param value to be set.
     * @return tha apiRequest Query param.
     */
    public ApiRequest addQueryParam(final String param, final String value) {
        this.setQueryParam(param, value);
        return this;
    }

    /**
     * Gets the apiRequest.
     *
     * @param param to be set.
     * @param value to be set.
     * @return tha apiRequest Path param.
     */
    public ApiRequest addPathParam(final String param, final String value) {
        this.setPathParam(param, value);
        return this;
    }

    /**
     * Gets the apiRequest.
     *
     * @param param to be set.
     * @param value to be set.
     * @return tha apiRequest param.
     */
    public ApiRequest addParam(final String param, final String value) {
        this.setParam(param, value);
        return this;
    }
}
