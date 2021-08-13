/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.config.users;

/**
 * Salesforce user with admin profile.
 */
public class AdminUser extends User {

    /**
     * Admin user constructor.
     */
    public AdminUser(String username, String password, String alias) {
        super(username, password, alias);
    }
}
