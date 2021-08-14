/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils;

import salesforce.utils.Urls;

/**
 * Removes all white space in string.
 */
public class Converter {

    /**
     * Removes all white space in string.
     *
     * @param words to removes white space.
     * @return a new string without space.
     */
    public static String removeWhiteSpace(final String words) {
        if (null == words) {
            return "";
        }
        return words.replaceAll("\\s+", "");
    }


    /**
     * Convert String to Url enum.
     *
     * @param namePage is string with name page
     * @param mode is classic or Lightning to salesforce
     * @return enum type Urls
     */
    public static Urls converterStringToEnum(final String namePage, final String mode) {
        return Urls.valueOf((namePage + "_" + mode).replace(' ', '_').toUpperCase());
    }
}
