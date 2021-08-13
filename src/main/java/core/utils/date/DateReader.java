/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils.date;

import java.util.Calendar;
import org.openqa.selenium.InvalidArgumentException;

/**
 * Parses a String Date.
 */
public class DateReader {

    private int quantity;

    /**
     * Obtains the time units to be set.
     *
     * @param date is the string with a time unit.
     * @return a integer that represents the time unit.
     */
    public int getTimeUnit(final String date) {
        switch (getDate(date)) {
            case "second": return Calendar.SECOND;
            case "minute": return Calendar.MINUTE;
            case "hour": return Calendar.HOUR;
            case "day": return Calendar.DAY_OF_MONTH;
            case "month": return Calendar.MONTH;
            case "year": return Calendar.YEAR;
            default: throw new InvalidArgumentException("Invalid Argument: Unsupported String Format.");
        }
    }

    /**
     * Gets a string as second or minute or hour or day or month or year.
     *
     * @param date is the string with a time unit.
     * @return a string.
     */
    public String getDate(String date) {
        return date.contains("second") ? "second"
                : date.contains("minute") ? "minute"
                : date.contains("hour") ? "hour"
                : date.contains("day") ? "day"
                : date.contains("month") ? "month"
                : date.contains("year") ? "year"
                : null;
    }

    /**
     * Obtains the values to be set.
     *
     * @param date is the string with the values to be set on a date.
     * @return a integer with the values to set in a date.
     */
    public int getQuantity(final String date) {
        String numberOnly = date.replaceAll("[^0-9]", "");
        try {
            quantity = Integer.parseInt(numberOnly);
        } catch (IllegalArgumentException e) {
            throw new NumberFormatException("Invalid Argument: Unsupported String Format.");
        }
        if (quantity == 1) {
            if (date.contains("s ago") || date.contains("s from")) {
                throw new NumberFormatException("Invalid Argument: Unsupported String Format.");
            }
        }
        return quantity;
    }
}
