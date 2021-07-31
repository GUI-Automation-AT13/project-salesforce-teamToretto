package org.salesforce.hooks;

import core.selenium.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.asserts.SoftAssert;
import salesforce.config.EnvConfig;
import salesforce.ui.PageTransporter;

public class GeneralHooks {
    public PageTransporter pageTransporter = new PageTransporter();
    public SoftAssert softAssert = new SoftAssert();

    @Before(value = "@CreateWorkType")
    public void setup() {
        WebDriverManager.getInstance().getWebDriver().get(EnvConfig.getInstance().getLoginUrl());
        WebDriverManager.getInstance().getWebDriver().manage().window().maximize();
    }
    @After(value = "@CreateWorkType")
    public void tearDown(){
        WebDriverManager.getInstance().getWebDriver().quit();
    }
}
