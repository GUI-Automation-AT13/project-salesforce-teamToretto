/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.utils.strategy;

import java.util.Map;

/**
 * Implements in feature new.
 */
public interface FeatureNew {
    void fillUpField(Map<String, String> table);

    CreatedFeature clickSaveButton();
}
