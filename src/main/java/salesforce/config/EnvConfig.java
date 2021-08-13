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
import salesforce.config.users.AdminUser;
import salesforce.config.users.StandardUser;

/**
 * This class sets the environment configuration.
 */
public final class EnvConfig {

    private EnvConfig() {
        initialize();
    }

    private String loginUrl;
    private String baseUrl;
    private AdminUser adminUser;
    private AdminUser adminUserPassword;
    private StandardUser standardUser;
    private static EnvConfig envConfig;
    private String language;
    private String key;

    /**
     * Returns the language.
     *
     * @return the language.
     */
    public String getLanguage() {
        return language;
    }

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
     * Returns the Admin User.
     *
     * @return AdminUser.
     */
    public AdminUser getAdminUser() {
        return adminUser;
    }

    /**
     * Returns the Standard User.
     *
     * @return StandarUser
     */
    public StandardUser getStandardUser() {
        return standardUser;
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
     * Retrieves the encryption key either from a property file or an env variable.
     *
     * @return a String representing the key
     */
    public String getKey() {
        String encryptKey = System.getenv("ENCRYPT_KEY");
        System.out.println("System env===" + encryptKey);
        if (encryptKey != null) {
            System.out.println("System en2===" + encryptKey);
            return encryptKey;
        } else {
            Properties properties = PropertiesReader.getProperties("config.properties");
            return properties.getProperty("encryptKey");
        }
    }

    /**
     * Sets the configuration.
     */
    private void initialize() {
        Properties properties = PropertiesReader.getProperties("config.properties");
        loginUrl = properties.getProperty("loginURL");
        baseUrl = properties.getProperty("baseURL");
        language = properties.getProperty("language");
        adminUser = new AdminUser();
        standardUser = new StandardUser();
    }
}