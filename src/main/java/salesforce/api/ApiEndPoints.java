/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.api;

/**
 * This enum defines possible SalesForce Endpoints.
 */
public enum ApiEndPoints {

    CONTACT("/sobjects/Contact"),
    CONTACT_ID("/sobjects/Contact/{CONTACT_ID}"),
    ACCOUNT("/sobjects/Account"),
    ACCOUNT_ID("/sobjects/Account/{ACCOUNT_ID}"),
    PRICEBOOK("/sobjects/Pricebook2"),
    PRICEBOOK_ID("/sobjects/Pricebook2/{PRICEBOOK_ID}"),
    CAMPAIGN("/sobjects/Campaign"),
    CAMPAIGN_ID("/sobjects/Campaign/{CAMPAIGN_ID}"),
    FEATURE_ID("/sobjects/Campaign/{CAMPAIGN_ID}");

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
