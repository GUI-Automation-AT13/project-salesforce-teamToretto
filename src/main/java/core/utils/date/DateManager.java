/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils.date;

import static salesforce.utils.Internalization.translate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.InvalidArgumentException;

/**
 * Handles dates formats to return them on a certain format.
 */
public class DateManager {
    private String dateToConvert;
    public Calendar calendar;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    /**
     * Converts a String to a Date.
     *
     * @param date is the string with a date format
     * @return a Date object
     */
    public Date manageDate(final String date) {
        if (date == null) {
            throw new NullPointerException("Invalid Argument: Unsupported String Format.");
        } else if (date.equals("")) {
            throw new InvalidArgumentException("Invalid Argument: Unsupported String Format.");
        }
        dateToConvert = date.toLowerCase();
        calendar = Calendar.getInstance();
        if (dateToConvert.matches("today|tomorrow|yesterday")) {
            convertWordToDate(dateToConvert);
            return calendar.getTime();
        }
        if (dateToConvert.contains("ago")) {
            DateReader dateReader = new DateReader();
            calendar.add(dateReader.getTimeUnit(date), -1 * dateReader.getQuantity(date));
            return calendar.getTime();
        }
        if (dateToConvert.contains("from now")) {
            DateReader dateReader = new DateReader();
            calendar.add(dateReader.getTimeUnit(date), dateReader.getQuantity(date));
            return calendar.getTime();
        }
        if (dateToConvert.contains("/")) {
            Date date1 = null;
            try {
                date1 = formatter.parse(date);
            } catch (ParseException e) {
                throw new InvalidArgumentException("Invalid Argument: Unsupported String Format.");
            }
            return date1;
        }
        throw new InvalidArgumentException("Invalid Argument: Unsupported String Format.");
    }

    /**
     * Converts a word to a Date.
     *
     * @param wordDate is the string with a date format
     */
    private void convertWordToDate(final String wordDate) {
        switch (wordDate) {
            case "today": calendar.add(Calendar.DAY_OF_MONTH, 0);
                break;
            case "tomorrow": calendar.add(Calendar.DAY_OF_MONTH, 1);
                break;
            case "yesterday": calendar.add(Calendar.DAY_OF_MONTH, -1);
                break;
            default:
                throw new InvalidArgumentException("Invalid Argument: Unsupported String Format.");
        }
    }

    /**
     * Generates actual date.
     *
     * @param dataFormat is format of data
     * @return a string with actual date
     */
    public static String generateDateActual(final String dataFormat) {
        DateFormat dateFormat = new SimpleDateFormat(dataFormat);
        Date date = new Date();
        String dateType = dateFormat.format(date);
        return dateType.contains("p. m.") ? dateType.replace("p. m.", translate("PM"))
                : dateType.contains("a. m.") ? dateType.replace("a. m.", translate("AM"))
                : dateType.contains("PM") ? dateType.replace("PM", translate("PM"))
                : dateType.contains("AM") ? dateType.replace("AM", translate("AM"))
                : "";
    }

    /**
     * Modifies date and add months.
     *
     * @param date      to change
     * @param addMonths adds months
     * @return a new date
     * @throws ParseException format is wrong or date
     */
    public static String addMonthsDate(final String date, final int addMonths) {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        try {
            calendar.setTime(dateFormat.parse(date));
        } catch (ParseException e) {
            throw new InvalidArgumentException("Format is wrong or date incorrect");
        }
        calendar.add(Calendar.DAY_OF_MONTH, addMonths * 30 + 1);
        return dateFormat.format(calendar.getTime());
    }
}
