package org.salesforce.hooks;

import core.selenium.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import salesforce.config.EnvConfig;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.lightning.HomePage;
import salesforce.ui.pages.lightning.LoginPage;

public class GeneralHooks {
    public PageTransporter pageTransporter;
    public SoftAssert softAssert;

    public GeneralHooks(final PageTransporter pageTransporter, final SoftAssert softAssert) {
        this.pageTransporter = pageTransporter;
        this.softAssert = softAssert;
    }

    @Before(order  = 1)
    public void setUp() {
        login();
    }

    public void login() {
        LoginPage loginpage = pageTransporter.navigateToLoginPage();
        String username = EnvConfig.getInstance().getUser();
        String password = EnvConfig.getInstance().getPassword();
        loginpage.setUsernameTextbox(username);
        loginpage.setPasswordTextbox(password);
        HomePage homePage = loginpage.login();
        Assert.assertTrue(homePage.labelObjectManageriIsVisible());
    }

    @After(order = 100)
    public void tearDown() {
        WebDriverManager.getInstance().quitWebDriver();
    }
}
