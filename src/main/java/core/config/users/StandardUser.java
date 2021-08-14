/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.config.users;

/**
 * Salesforce user with standar profile.
 */
public class StandardUser extends User {

    /**
     * Standard user constructor.
     */
    public StandardUser(String username, String password, String alias) {
        super(username, password, alias);
    }
}
