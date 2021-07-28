package unittests;

import core.date.DateManager;
import org.openqa.selenium.InvalidArgumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Calendar;
import java.util.Date;

public class DateManagerTest {

    private Calendar calendar;
    private Calendar dateToConvert;
    private DateManager dateManager;

    @BeforeMethod
    public void clean() {
        calendar = Calendar.getInstance();
        dateToConvert = Calendar.getInstance();
        dateManager = new DateManager();
    }

    @Test
    public void shouldReturnTodayDate() {
        Date date = dateManager.manageDate("TODAY");
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendar.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnTomorrowsDate() {
        Date date = dateManager.manageDate("TOMORROW");
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendar.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnYesterdayDate() {
        Date date = dateManager.manageDate("YESTERDAY");
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendar.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturn2DaysAgoDate() {
        Date date = dateManager.manageDate("2 days ago");
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendar.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturn1DayAgoDate() {
        Date date = dateManager.manageDate("1 day ago");
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendar.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturn3YearsAgoDate() {
        Date date = dateManager.manageDate("3 years ago");
        calendar.add(Calendar.YEAR, -3);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.YEAR);
        int expected = calendar.get(Calendar.YEAR);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturn15MinutesFromNowDate() {
        Date date = dateManager.manageDate("15 minutes from now");
        calendar.add(Calendar.MINUTE, 15);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.MINUTE);
        int expected = calendar.get(Calendar.MINUTE);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturn5MonthsFromNowDate() {
        Date date = dateManager.manageDate("5 months from now");
        calendar.add(Calendar.MONTH, 5);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.MONTH);
        int expected = calendar.get(Calendar.MONTH);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturn5HoursFromNowDate() {
        Date date = dateManager.manageDate("5 hours from now");
        calendar.add(Calendar.HOUR, 5);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.HOUR);
        int expected = calendar.get(Calendar.HOUR);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturn50SecondsFromNowDate() {
        Date date = dateManager.manageDate("50 seconds from now");
        calendar.add(Calendar.SECOND, 50);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.SECOND);
        int expected = calendar.get(Calendar.SECOND);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnMMddyyyyFormDate() {
        Date date = dateManager.manageDate("07/14/2021");
        dateToConvert.setTime(date);
        int actualMonth = dateToConvert.get(Calendar.MONTH);
        int expectedMonth = Calendar.JULY;
        int actualDay = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expectedDay = 14;
        int actualYear = dateToConvert.get(Calendar.YEAR);
        int expectedYear = 2021;
        Assert.assertEquals(actualDay, expectedDay);
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualYear, expectedYear);
    }

    @Test(expectedExceptions = {InvalidArgumentException.class},
            expectedExceptionsMessageRegExp = "Invalid Argument: Unsupported String Format.*")
    public void testConvertStringToDateWithInvalidKeyWord() {
        dateManager.manageDate("15 minutes antes");

    }

    @Test(expectedExceptions = {NullPointerException.class},
            expectedExceptionsMessageRegExp = "Invalid Argument: Unsupported String Format.*")
    public void testConvertStringToDateWithNullValues() {
        dateManager.manageDate(null);
    }

    @Test(expectedExceptions = {InvalidArgumentException.class},
            expectedExceptionsMessageRegExp = "Invalid Argument: Unsupported String Format.*")
    public void testConvertStringToDateWithEmptyValues() {
        dateManager.manageDate("");
    }

    @Test(expectedExceptions = {NumberFormatException.class},
            expectedExceptionsMessageRegExp = "Invalid Argument: Unsupported String Format.*")
    public void testConvertStringToDateWithTwoValidKeyWords() {
        dateManager.manageDate("Today ago");
    }

    @Test(expectedExceptions = {InvalidArgumentException.class},
            expectedExceptionsMessageRegExp = "Invalid Argument: Unsupported String Format.*")
    public void testConvertStringToDateWithInvalidTimeUnit() {
        dateManager.manageDate("15 dias ago");
    }

    @Test(expectedExceptions = {NumberFormatException.class},
            expectedExceptionsMessageRegExp = "Invalid Argument: Unsupported String Format.*")
    public void testConvertStringToDateWithInvalidTimeNumberFormat() {
        dateManager.manageDate("dos days ago");
    }

    @Test(expectedExceptions = {InvalidArgumentException.class},
            expectedExceptionsMessageRegExp = "Invalid Argument: Unsupported String Format.*")
    public void testConvertStringToDateWithInvalidDateFormat() {
        dateManager.manageDate("July/19/2021");
    }

    @Test(expectedExceptions = {NumberFormatException.class},
            expectedExceptionsMessageRegExp = "Invalid Argument: Unsupported String Format.*")
    public void testConvertStringToDateWithPluralWords() {
        dateManager.manageDate("1 days ago");
    }
}
