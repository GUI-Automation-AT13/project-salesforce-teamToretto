package unittests;

import core.utils.StringConverter;
import org.testng.Assert;
import org.testng.annotations.Test;
import static core.utils.StringConverter.removeWhiteSpace;

public class StringConverterTest {

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

    @Test
    public void toPascalCaseShouldReturnWordInPascalCase() {
        String actual = StringConverter.toPascalCase("word");
        String expected = "Word";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void toPascalCaseShouldReturnWORDInPascalCase() {
        String actual = StringConverter.toPascalCase("WORD");
        String expected = "Word";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void toCamelCaseShouldReturnWordInCamelCase() {
        String actual = StringConverter.toCamelCase("Word");
        String expected = "word";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void toCamelCaseShouldReturnWORDInCamelCase() {
        String actual = StringConverter.toCamelCase("WORD");
        String expected = "word";
        Assert.assertEquals(actual, expected);
    }
}
