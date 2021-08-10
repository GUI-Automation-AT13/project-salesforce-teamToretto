/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils;

import core.utils.date.DateManager;
import java.util.UUID;

/**
 * This class generic a random string.
 */
public final class RandomCustom {

    private RandomCustom() {
    }

    /**
     * Generates random and custom value.
     *
     * @return a String random
     */
    public static String random() {
        return generateDate() + generateFourRandom();
    }

    /**
     * Generates actual date.
     *
     * @return a String with actual date
     */
    private static String generateDate() {
        DateManager dateManager = new DateManager();
        return DateManager.generateDateActual(" yyyy-MM-dd HH:mm ");
    }

    /**
     * Generates four random letters or numbers.
     *
     * @return a String with random value
     */
    private static String generateFourRandom() {
        String[] uniqueId = UUID.randomUUID().toString().split("-");
        return uniqueId[2];
    }
}
