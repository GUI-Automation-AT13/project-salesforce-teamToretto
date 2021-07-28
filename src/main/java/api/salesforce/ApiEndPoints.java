package api.salesforce;

/**
 * This enum defines possible SalesForce Endpoints.
 */
public enum ApiEndPoints {

    CONTACT("/sobjects/Contact"),
    CONTACT_ID("/sobjects/Contact/{CONTACT_ID}"),
    ACCOUNT("/sobjects/Account"),
    ACCOUNT_ID("/sobjects/Account/{ACCOUNT_ID}");

    private String endpoint;

    ApiEndPoints(final String newEndpoint) {
        this.endpoint = newEndpoint;
    }

    /**
     * Gets the api end point command according to the Sales force feature.
     *
     * @return the end point.
     */
    public String toEndpoint() {
        return endpoint;
    }
}
