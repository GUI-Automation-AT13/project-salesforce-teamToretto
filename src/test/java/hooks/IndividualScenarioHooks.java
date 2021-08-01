/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package hooks;

import core.selenium.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.Assert;
import salesforce.config.EnvConfig;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.lightning.HomePage;
import salesforce.ui.pages.lightning.LoginPage;
import salesforce.ui.pages.lightning.individuals.IndividualFormPage;
import salesforce.ui.pages.lightning.individuals.IndividualListPage;

public class IndividualScenarioHooks {

    private PageTransporter pageTransporter;
    private LoginPage loginPage;
    private IndividualFormPage individualFormPage;

    public IndividualScenarioHooks(PageTransporter pageTransporter) {
        this.pageTransporter = pageTransporter;
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

    @After(value = "@CreateIndividual")
    public void setLast() {
        IndividualListPage individualListPage = pageTransporter.navigateToIndividualListPage();
        individualListPage.deleteLastModifiedRecord();
        String actual = individualListPage.getDeletedSuccessMessage();
        String expected = "was deleted.";
        Assert.assertTrue(actual.contains(expected));
    }

    @After(order = 100)
    public void tearDown() {
        WebDriverManager.getInstance().quitWebDriver();
    }
}
