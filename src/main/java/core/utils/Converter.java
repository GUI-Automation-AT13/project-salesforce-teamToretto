/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils;

/**
 * Removes all white space in string.
 *
 */
public class Converter {

    /**
     * Removes all white space in string.
     *
     * @param words to removes white space.
     * @return a new string without space.
     */
    public static String removeWhiteSpace(final String words) {
        return words.replaceAll("\\s+", "");
    }
}
