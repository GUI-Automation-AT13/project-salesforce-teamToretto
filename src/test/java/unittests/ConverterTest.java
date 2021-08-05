package unittests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static core.utils.Converter.removeWhiteSpace;

public class ConverterTest {

    @Test
    public void convertEmptyString() {
        String actual = removeWhiteSpace("");
        String expected = "";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void removeEmptySpaceInString() {
        String actual = removeWhiteSpace("Removes all white space in string");
        String expected = "Removesallwhitespaceinstring";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void returnEmpTyStringWithInputNull() {
        String actual = removeWhiteSpace(null);
        String expected = "";
        Assert.assertEquals(actual, expected);
    }
}
