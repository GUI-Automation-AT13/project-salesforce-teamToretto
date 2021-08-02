package org.salesforce.hooks;

import core.selenium.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import salesforce.config.EnvConfig;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.lightning.HomePage;
import salesforce.ui.pages.lightning.LoginPage;

public class GeneralHooks {
    private Logger log = Logger.getLogger(getClass());
    public PageTransporter pageTransporter;
    public SoftAssert softAssert;

    public GeneralHooks(final PageTransporter pageTransporter, final SoftAssert softAssert) {
        log.info("GeneralHooks constructor");
        this.pageTransporter = pageTransporter;
        this.softAssert = softAssert;
    }

    @Before(value = "@CreateWorkType or @CreateCampaign or @CreateContract or @CreateIndividual", order  = 1)
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

    @After(value = "@CreateWorkType or @CreateCampaign or @CreateContract or @CreateIndividual", order = 100)
    public void tearDown() {
        log.info("Close Driver");
        WebDriverManager.getInstance().quitWebDriver();
    }
}
