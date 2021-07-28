/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package salesforce.config;

import core.utils.PropertiesReader;
import java.util.Properties;

/**
 * This class sets the environment configuration.
 */
public final class EnvConfig {

    private EnvConfig() {
        initialize();
    }

    private String loginUrl;
    private String baseUrl;
    private String user;
    private String password;
    private static EnvConfig envConfig;

    /**
     * Returns the loginUrl.
     *
     * @return the loginUrl.
     */
    public String getLoginUrl() {
        return loginUrl;
    }

    /**
     * Returns the baseUrl.
     *
     * @return the baseUrl.
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Returns the user.
     *
     * @return the user.
     */
    public String getUser() {
        return user;
    }

    /**
     * Returns the password.
     *
     * @return the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the envConfig.
     *
     * @return the envConfig.
     */
    public static EnvConfig getInstance() {
        if (envConfig == null) {
            envConfig = new EnvConfig();
        }
        return envConfig;
    }

    /**
     * Sets the configuration.
     */
    private void initialize() {
        Properties properties = PropertiesReader.getProperties("config.properties");
        loginUrl = properties.getProperty("loginURL");
        baseUrl = properties.getProperty("baseURL");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }

}