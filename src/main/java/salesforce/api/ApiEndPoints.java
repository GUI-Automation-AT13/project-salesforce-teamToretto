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
    CONTRACT("/sobjects/Contract"),
    CONTRACT_ID("/sobjects/Contract/{CONTRACT_ID}"),
    INDIVIDUAL("/sobjects/Individual"),
    INDIVIDUAL_ID("/sobjects/Individual/{INDIVIDUAL_ID}"),
    WORKTYPE("/sobjects/WorkType"),
    WORKTYPE_ID("/sobjects/WorkType/{WORKTYPE_ID}"),
    LIST_CAMPAIGN_ID("/query/?q=SELECT id from Campaign"),
    LIST_CONTRACT_ID("/query/?q=SELECT id from Contract"),
    LIST_INDIVIDUAL_ID("/query/?q=SELECT id from Individual"),
    LIST_WORKTYPE_ID("/query/?q=SELECT id from WorkType");

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

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
