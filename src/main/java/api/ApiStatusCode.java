package api;

/**
 * This enum defines Invalid IDs for salesforce Endopints.
 */
public enum ApiStatusCode {

    OK(200),
    CREATED(201),
    NO_CONTENT(204),
    BAD_REQUEST(400),
    NOT_FOUND(404),
    SERVER_ERROR(500),
    NOT_ALLOWED(405);

    private int responseCode;

    ApiStatusCode(final int newResponseCode) {
        this.responseCode = newResponseCode;
    }
    /**
     * Gets the responseCode response.
     *
     * @return the responseCode.
     */
    public int value() {
        return responseCode;
    }
}
