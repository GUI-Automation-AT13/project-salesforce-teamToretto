/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Jorge Rodrigo Cáceres Velasco
 */
package core.date;

import org.openqa.selenium.InvalidArgumentException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
            case "today":
                calendar.add(Calendar.DAY_OF_MONTH, 0);
                break;
            case "tomorrow":
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                break;
            case "yesterday":
                calendar.add(Calendar.DAY_OF_MONTH, -1);
                break;
            default:
                throw new InvalidArgumentException("Invalid Argument: Unsupported String Format.");
        }
    }

}
