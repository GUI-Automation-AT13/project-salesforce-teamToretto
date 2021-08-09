package org.salesforce.hooks;

import core.selenium.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import salesforce.config.EnvConfig;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.lightning.HomePage;
import salesforce.ui.pages.lightning.LoginPage;

public class GeneralHooks {

    private Logger log = Logger.getLogger(getClass());
    private PageTransporter pageTransporter;
    private WebDriverManager webDriverManager;

    public GeneralHooks(final WebDriverManager webDriverManager) {
        log.info("GeneralHooks constructor");
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(this.webDriverManager);
    }

    @Before(order  = 1)
    public void setUp() {
        log.info("Set up Methods");
        login();
    }

    public void login() {
        LoginPage loginpage = pageTransporter.navigateToLoginPage();
        String username = EnvConfig.getInstance().getAdminUser().getUsername();
        String password = EnvConfig.getInstance().getAdminUser().getPassword();
        loginpage.setUsernameTextbox(username);
        loginpage.setPasswordTextbox(password);
        HomePage homePage = loginpage.login();
    }

    @After(order = 100)
    public void tearDown() {
        log.info("Close Driver");
        webDriverManager.quitWebDriver();
    }
}
