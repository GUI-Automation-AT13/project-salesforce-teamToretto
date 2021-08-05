package unittests;

import core.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class PropertiesReaderTest {
    private Properties propertiesReader;
    private String pathPropertiesField = "src/test/resources/tests/test.properties";

    @Test
    public void readPropertyFieldAWorld(){
        propertiesReader = PropertiesReader.getProperties(pathPropertiesField);
        String actual = propertiesReader.getProperty("world");
        String expected = "testPassed";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void readPropertyFieldDontExistReturnNull(){
        propertiesReader = PropertiesReader.getProperties(pathPropertiesField);
        String actual = propertiesReader.getProperty("Not found");
        String expected = null;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void readPropertyFieldAPosition(){
        propertiesReader = PropertiesReader.getProperties(pathPropertiesField);
        String actual = propertiesReader.getProperty("position");
        String expected = "500";
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = {RuntimeException.class},
            expectedExceptionsMessageRegExp = "Unable to read the properties file or File not found")
    public void fieldNotFoundInPropertyReader(){
        propertiesReader = PropertiesReader.getProperties("test.properties");
    }
}
