package api;

import io.restassured.response.Response;
import java.util.List;

/**
 * This class builds an api response.
 */
public class ApiResponse {
    private Response response;

    /**
     * Constructor for a Api response with a response param.
     *
     * @param newResponse .
     */
    public ApiResponse(final Response newResponse) {
        this.response = newResponse;
    }

    /**
     * Constructor for a Api response.
     */
    public ApiResponse() {
    }

    /**
     * Gets the api response.
     *
     * @return the response.
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the response.
     *
     * @param newResponse to be set.
     */
    public void setResponse(final Response newResponse) {
        this.response = newResponse;
    }

    /**
     * Gets the api Status Code.
     *
     * @return the Status Code.
     */
    public int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * Gets the api body.
     *
     * @param cls to ge the body.
     * @param <T> class type to get the body.
     * @return the body.
     */
    public <T> T getBody(final Class<T> cls) {
        return response.getBody().as(cls);
    }

    /**
     * Gets the api body list.
     *
     * @param cls to ge the body list.
     * @param <T> class type to get the body list.
     * @return the body list.
     */
    public <T> List getBodyList(final Class<T> cls) {
        return response.getBody().jsonPath().getList("", cls);
    }

    /**
     * Gets the api path.
     *
     * @param path of the value to be get.
     * @return the path.
     */
    public String getPath(final String path) {
        return response.getBody().jsonPath().getJsonObject(path);
    }
}
