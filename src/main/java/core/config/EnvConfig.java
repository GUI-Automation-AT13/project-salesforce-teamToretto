/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.config;

import core.config.users.AdminUser;
import core.config.users.StandardUser;
import core.config.users.User;
import core.selenium.driverfactory.Browser;
import core.utils.PropertiesReader;
import java.util.Properties;
import salesforce.utils.encrypt.AesUtil;

/**
 * This class sets the environment configuration.
 */
public final class EnvConfig {

    private static EnvConfig envConfig;
    private Properties properties;
    private final String envPropertiesPath = "environments/%s/Env.properties";
    private final String userPropertiesPath = "environments/%s/users/%s";
    private final String adminUserProperties = "AdminUser.properties";
    private final String standardUserProperties = "StandardUser.properties";

    private String version;
    private String service;
    private String login;
    private String loginUrl;
    private String browser;
    private int implicitTime;
    private int explicitTime;
    private int sleepTime;
    private String language;

    private String testEnvironment;
    private String baseUrl;
    private AdminUser adminUser;
    private StandardUser standardUser;
    private String clientId;
    private String clientSecret;

    /**
     * EnvConfig constructor.
     */
    private EnvConfig() {
        initialize();
    }

    /**
     * Gets the service version.
     *
     * @return a String
     */
    public String getVersion() {
        return version;
    }

    /**
     * Gets the service url path.
     *
     * @return a String
     */
    public String getService() {
        return service;
    }

    /**
     * Gets the login url for the API.
     *
     * @return a String
     */
    public String getLoginApi() {
        return login;
    }

    /**
     * Gets the browser to run the tests on.
     *
     * @return a String
     */
    public String getBrowser() {
        String browser = System.getenv("BROWSER");
        if (browser != null) {
            return browser;
        }
        browser = System.getProperty("BROWSER");
        if (browser != null) {
            return browser;
        }
        return this.browser;
    }

    /**
     * Gets the implicit time.
     *
     * @return int represents the driver implicit time
     */
    public int getImplicitTime() {
        return implicitTime;
    }

    /**
     * Gets the explicit time.
     *
     * @return int represents the driver explicit time
     */
    public int getExplicitTime() {
        return explicitTime;
    }

    /**
     * Gets the sleep time.
     *
     * @return int represents the driver sleep time
     */
    public int getSleepTime() {
        return sleepTime;
    }

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
        return AesUtil.decryptText(baseUrl);
    }

    /**
     * Returns the Admin User.
     *
     * @return AdminUser.
     */
    public User getAdminUser() {
        return adminUser;
    }

    /**
     * Returns the Standard User.
     *
     * @return StandarUser
     */
    public User getStandardUser() {
        return standardUser;
    }

    /**
     * Gets the Salesforce client id.
     *
     * @return a String
     */
    public String getClientId() {
        return AesUtil.decryptText(clientId);
    }

    /**
     * Gets the Salesforce client secret.
     *
     * @return a String
     */
    public String getClientSecret() {
        return AesUtil.decryptText(clientSecret);
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
        if (encryptKey != null) {
            return encryptKey;
        } else {
            Properties properties = PropertiesReader.getProperties("key.properties");
            return properties.getProperty("encryptKey");
        }
    }

    /**
     * Sets the configuration.
     */
    private void initialize() {
        testEnvironment = getTestEnvironment();
        initializeGeneralProperties();
        initializeEnvironmentProperties();
        initializeUserProperties();
    }

    private void initializeGeneralProperties() {
        properties = PropertiesReader.getProperties("config.properties");
        loginUrl = getProperty("loginURL");
        version = getProperty("VERSION");
        service = getProperty("SERVICE");
        login = getProperty("LOGIN");
        browser = getProperty("browser");
        implicitTime = Integer.valueOf(getProperty("implicitTime"));
        explicitTime = Integer.valueOf(getProperty("explicitTime"));
        sleepTime = Integer.valueOf(getProperty("sleepTime"));
        language = getProperty("language");
    }

    private void initializeEnvironmentProperties() {
        properties = PropertiesReader.getProperties(String.format(envPropertiesPath, testEnvironment));
        baseUrl = properties.getProperty("baseURL");
        clientId = properties.getProperty("CLIENT_ID");
        clientSecret = properties.getProperty("CLIENT_SECRET");
    }

    private void initializeUserProperties() {
        setPropertiesPath(String.format(userPropertiesPath, testEnvironment, adminUserProperties));
        adminUser = new AdminUser(getProperty("user"), getProperty("password"), getProperty("alias"));
        setPropertiesPath(String.format(userPropertiesPath, testEnvironment, standardUserProperties));
        standardUser = new StandardUser(getProperty("user"), getProperty("password"), getProperty("alias"));
    }

    /**
     * Retrieves a user given its user property file name.
     *
     * @param userType represents the user property file name
     */
    public User getUser(final String userType) {
        properties = PropertiesReader.getProperties(String.format(userPropertiesPath, testEnvironment, userType));
        return new StandardUser(properties.getProperty("user"), properties.getProperty("password"),
                properties.getProperty("alias"));
    }

    /**
     * Sets the properties path to the provided path.
     *
     * @param path represents the path that the properties will point to
     */
    private void setPropertiesPath(final String path) {
        properties = PropertiesReader.getProperties(path);
    }

    /**
     * Gets a property from the Properties instance.
     *
     * @param property represents the property to retrieve
     * @return a String
     */
    private String getProperty(final String property) {
        return properties.getProperty(property);
    }

    /**
     * Returns the environment configuration to run the tests on.
     *
     * @return a String
     */
    private String getTestEnvironment() {
        properties = PropertiesReader.getProperties("config.properties");
        String environment = System.getenv("TEST_ENVIRONMENT");
        return environment != null ? environment : properties.getProperty("testEnvironment");
    }
}