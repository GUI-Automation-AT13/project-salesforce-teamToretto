package api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

/**
 * This manages the api requests.
 */
public class ApiManager {


    /**
     * Builds the response of the apiRequest.
     * @param apiRequest with the request´s especifications
     * @return the response.
     */
    private static RequestSpecification buildRequest(final ApiRequest apiRequest) {
        return given().baseUri(apiRequest.getBaseUri())
                .headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getQueryParams())
                .pathParams(apiRequest.getPathParams())
                .params(apiRequest.getParams())
                .log().all();
    }
    /**
     * Executes a request according to the apiRequest information.
     *
     * @param apiRequest with the api information to be requested.
     * @param apiResponse with the response of the execution
     */
    public static void execute(final ApiRequest apiRequest, final ApiResponse apiResponse) {
        Response response;
        if (apiRequest.getBody() != null) {
            response = buildRequest(apiRequest)
                    .body(apiRequest.getBody())
                    .request(apiRequest.getMethod().name(), apiRequest.getEndpoint());
        } else {
            response = buildRequest(apiRequest)
                    .request(apiRequest.getMethod().name(), apiRequest.getEndpoint());
        }
        apiResponse.setResponse(response);
    }
}
