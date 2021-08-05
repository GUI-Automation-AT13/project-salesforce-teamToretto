/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * Page Object Model for the Salesforce's Login page.
 */
public class LoginPage extends BasePage {

    private By usernameTextbox = By.className("username");
    private By passwordTextbox = By.className("password");
    private By loginButton = By.id("Login");

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager .
     */
    public LoginPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Sets the given username to the username textbox.
     *
     * @param username represents the username value to be put on the username text box
     */
    public void setUsernameTextbox(final String username) {
        webElementAction.setInputField(usernameTextbox, username);
    }

    /**
     * Sets the given password to the password textbox.
     *
     * @param password represents the password value to be put on the password text box
     */
    public void setPasswordTextbox(final String password) {
        webElementAction.setInputField(passwordTextbox, password);
    }

    /**
     * Clicks on the login button.
     *
     * @return HomePage
     */
    public HomePage login() {
        webElementAction.clickByLocator(loginButton);
        return new HomePage(webDriverManager);
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(loginButton);
    }
}
