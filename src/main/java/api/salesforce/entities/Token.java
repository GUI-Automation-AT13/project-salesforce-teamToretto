package api.salesforce.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class defines an authentication token schema.
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Token {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public String accessToken;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String instanceUrl;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String tokenType;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String issuedAt;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String signature;

    /**
     * Gets the accessToken.
     *
     * @return the accessToken.
     */
    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }
    /**
     * Sets the accessToken.
     *
     * @param newAccessToken to be set.
     */
    @JsonProperty("access_token")
    public void setAccessToken(final String newAccessToken) {
        this.accessToken = newAccessToken;
    }
    /**
     * Gets the instanceUrl.
     *
     * @return the instanceUrl.
     */
    @JsonProperty("instance_url")
    public String getInstanceUrl() {
        return instanceUrl;
    }
    /**
     * Sets the instanceUrl.
     *
     * @param newInstanceUrl to be set.
     */
    @JsonProperty("instance_url")
    public void setInstanceUrl(final String newInstanceUrl) {
        this.instanceUrl = newInstanceUrl;
    }
    /**
     * Gets the id.
     *
     * @return the id.
     */
    public String getId() {
        return id;
    }
    /**
     * Sets the id.
     *
     * @param newId to be set.
     */
    public void setId(final String newId) {
        this.id = newId;
    }
    /**
     * Gets the tokenType.
     *
     * @return the tokenType.
     */
    @JsonProperty("token_type")
    public String getTokenType() {
        return tokenType;
    }
    /**
     * Sets the tokenType.
     *
     * @param newTokenType to be set.
     */
    @JsonProperty("token_type")
    public void setTokenType(final String newTokenType) {
        this.tokenType = newTokenType;
    }
    /**
     * Gets the issuedAt.
     *
     * @return the issuedAt.
     */
    @JsonProperty("issued_at")
    public String getIssuedAt() {
        return issuedAt;
    }
    /**
     * Sets the issuedAt.
     *
     * @param newIssuedAt to be set.
     */
    @JsonProperty("issued_at")
    public void setIssuedAt(final String newIssuedAt) {
        this.issuedAt = newIssuedAt;
    }
    /**
     * Gets the signature.
     *
     * @return the signature.
     */
    public String getSignature() {
        return signature;
    }
    /**
     * Sets the signature.
     *
     * @param newSignature to be set.
     */
    public void setSignature(final String newSignature) {
        this.signature = newSignature;
    }
}
