/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils;

import salesforce.api.ApiEndPoints;

/**
 * This Class return a endpoint of feature.
 */
public class SelectFeature {

    /**
     * Returns a endpoint of the feature selected.
     *
     * @param nameFeature is a name of the feature.
     * @return A endpoint with feature id.
     */
    public ApiEndPoints selectNameFeature(String nameFeature) {
        switch (nameFeature) {
            case "CAMPAIGN_ID":  return ApiEndPoints.CAMPAIGN_ID;
            case "CONTRACT_ID":  return ApiEndPoints.CONTRACT_ID;
            case "INDIVIDUAL_ID":  return ApiEndPoints.INDIVIDUAL_ID;
            case "WORKTYPE_ID":  return ApiEndPoints.WORKTYPE_ID;
            default: return null;
        }
    }
}
