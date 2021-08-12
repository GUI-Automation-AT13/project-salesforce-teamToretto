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
 * Salesforce user with admin profile.
 */
public class AdminUser extends User {

    /**
     * Admin user constructor.
     */
    public AdminUser() {
        Properties properties = PropertiesReader.getProperties("users/AdminUser.properties");
        setUsername(properties.getProperty("user"));
        setPassword(properties.getProperty("password"));
        setAlias(properties.getProperty("alias"));
    }
}
