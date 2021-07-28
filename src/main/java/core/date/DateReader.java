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
import java.util.Calendar;

public class DateReader {
    private int timeUnit;
    private int quantity;

    /**
     * Obtains the time units to be set.
     *
     * @param date is the string with a time unit.
     * @return a integer that represents the time unit.
     */
    public int getTimeUnit(final String date) {
        timeUnit = 0;

        if (date.contains("second")) {
            timeUnit = Calendar.SECOND;
            return timeUnit;
        }
        if (date.contains("minute")) {
            timeUnit = Calendar.MINUTE;
            return timeUnit;
        }
        if (date.contains("hour")) {
            timeUnit = Calendar.HOUR;
            return timeUnit;
        }
        if (date.contains("day")) {
            timeUnit = Calendar.DAY_OF_MONTH;
            return timeUnit;
        }
        if (date.contains("month")) {
            timeUnit = Calendar.MONTH;
            return timeUnit;
        }
        if (date.contains("year")) {
            timeUnit = Calendar.YEAR;
            return timeUnit;
        }
        throw new InvalidArgumentException("Invalid Argument: Unsupported String Format.");

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
