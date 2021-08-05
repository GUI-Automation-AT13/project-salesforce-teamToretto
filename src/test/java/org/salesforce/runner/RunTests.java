package org.salesforce.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"html:target/site/cucumber-pretty.html", "json:target/cucumber.json"},
        glue = {"org.salesforce"}
)
public class RunTests extends AbstractTestNGCucumberTests {
    public Logger LOGGER = Logger.getLogger(getClass());
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
    @BeforeTest
    public void beforeExecution() {
        LOGGER.info("----------- Before Execution -----------");
    }
    @AfterTest
    public void afterExecution() {
        LOGGER.info("----------- After Execution -----------");
    }
}
