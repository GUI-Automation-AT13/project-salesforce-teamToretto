/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.config.users;

import salesforce.utils.encrypt.AesUtil;

/**
 * Represents a Salesforce user.
 */
public abstract class User {

    private String username;
    private String password;
    private String alias;

    /**
     * User constructor.
     *
     * @param username represents the user's username
     * @param password represents the user's password
     * @param alias represents the user's alias
     */
    public User(final String username, final String password, final String alias) {
        this.username = username;
        this.password = password;
        this.alias = alias;
    }

    /**
     * Gets the user's username.
     *
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the user's password.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the user's username.
     *
     * @return String
     */
    public String getPassword() {
        return AesUtil.decryptText(password);
    }

    /**
     * Sets the user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user's alias.
     *
     * @return String
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the user's alias.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
}
