package org.salesforce.hooks;

import core.config.EnvConfig;
import core.selenium.WebDriverManager;
import core.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import salesforce.ui.entities.PersonalInformation;
import salesforce.ui.pages.lightning.HomePage;
import salesforce.ui.pages.lightning.LoginPage;
import salesforce.utils.PageTransporter;

/**
 * This class defines the general hooks.
 */
public class GeneralHooks {

    private Logger log = LogManager.getLogger(getClass());
    private PageTransporter pageTransporter;
    private WebDriverManager webDriverManager;
    private PersonalInformation personalInformation;

    /**
     * This class defines the general hooks.
     */
    public GeneralHooks(final WebDriverManager webDriverManager) {
        log.info("GeneralHooks constructor");
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(this.webDriverManager);
    }

    /**
     * Sets up the environment for the tests.
     */
    @Before(order  = 1)
    public void setUp() {
        log.info("Set up Methods");
        login();
    }

    /**
     * Logs in to the sales force page.
     */
    public void login() {
        LoginPage loginpage = pageTransporter.navigateToLoginPage();
        String username = EnvConfig.getInstance().getAdminUser().getUsername();
        String password = EnvConfig.getInstance().getAdminUser().getPassword();
        loginpage.setUsernameTextbox(username);
        loginpage.setPasswordTextbox(password);
        HomePage homePage = loginpage.login();
    }

    /**
     * Finishes the test and takes a screenshot.
     */
    @After(order = 1)
    public void tearDown(Scenario scenario) {
        log.info("Close Driver");
        ScreenshotUtil.captureScreenshot(webDriverManager.getWebDriver(), scenario);
        webDriverManager.quitWebDriver();
    }
}
