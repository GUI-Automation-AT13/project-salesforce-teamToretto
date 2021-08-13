/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.config.users;

import core.utils.PropertiesReader;
import java.util.Properties;

/**
 * Salesforce user with standar profile.
 */
public class StandardUser extends User {

    /**
     * Standar user constructor.
     */
    public StandardUser() {
        Properties properties = PropertiesReader.getProperties("users/StandardUser.properties");
        setUsername(properties.getProperty("user"));
        setPassword(properties.getProperty("password"));
    }
}
