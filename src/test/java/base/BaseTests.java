package base;

import core.selenium.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import salesforce.config.EnvConfig;
import salesforce.ui.PageTransporter;

public class BaseTests {
    public PageTransporter pageTransporter = new PageTransporter();
    public SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void setup() {
        WebDriverManager.getInstance().getWebDriver().get(EnvConfig.getInstance().getLoginUrl());
        WebDriverManager.getInstance().getWebDriver().manage().window().maximize();
    }
    @AfterClass
    public void tearDown(){
        WebDriverManager.getInstance().getWebDriver().quit();
    }
}
