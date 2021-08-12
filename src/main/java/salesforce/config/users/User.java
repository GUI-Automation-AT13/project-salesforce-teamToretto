/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.config.users;

/**
 * Represents a Salesforce user.
 */
public abstract class User {

    private String username;
    private String password;
    private String alias;

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
        return password;
    }

    /**
     * Sets the user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the user's alias.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Gets the user's alias.
     *
     * @return String
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
}
