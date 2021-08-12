/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import salesforce.ui.pages.classic.ClassicHomePage;
import salesforce.ui.pages.lightning.HomePage;

/**
 * Page object model for the salesforce login page.
 */
public class LoginPage extends BasePage {

    private final By userNameTxtBox = By.id("username");

    private final By passwordTxtBox = By.id("password");

    private final By loginBtn = By.id("Login");

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public LoginPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webDriverActions.waitForVisibilityOfLocator(loginBtn);
    }

    /**
     * Sets the user name.
     *
     * @param userName to be set.
     * @return the user name instance.
     */
    private LoginPage setUserName(final String userName) {
        webDriverActions.setInputField(userNameTxtBox, userName);
        return this;
    }

    /**
     * Sets the user password.
     *
     * @param password to be set.
     * @return the user password instance.
     */
    private LoginPage setPassword(final String password) {
        webDriverActions.setInputField(passwordTxtBox, password);
        return this;
    }

    /**
     * Clicks the login button.
     */
    private void clickLoginBtn() {
        webDriverActions.clickByLocator(loginBtn);
    }

    /**
     * login with successful values.
     *
     * @param userName to be set.
     * @param password to be set.
     * @return the home page.
     */
    public ClassicHomePage loginClassicSuccessful(final String userName, final String password) {
        setUserName(userName);
        setPassword(password);
        clickLoginBtn();
        return new ClassicHomePage(webDriverManager);
    }

    /**
     * login with successful values.
     *
     * @param userName to be set
     * @param password to be set
     * @return the home page
     */
    public HomePage loginSuccessful(final String userName, final String password) {
        setUserName(userName);
        setPassword(password);
        clickLoginBtn();
        return new HomePage(webDriverManager);
    }
}
