/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Removes all white space in string.
 */
public class StringConverter {

    private static final String WORD_SEPARATOR = " ";

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
     * Converts the given String to camel case format.
     *
     * @param text represents the text to be converted
     * @return a String
     */
    public static String toCamelCase(final String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        String camelCase = Arrays
                .stream(text.split(WORD_SEPARATOR))
                .map(word -> word.isEmpty()
                        ? word
                        : Character.toTitleCase(word.charAt(0)) + word
                        .substring(1)
                        .toLowerCase())
                .collect(Collectors.joining(WORD_SEPARATOR));
        String firstLetter = text.substring(0, 1);
        String remainingLetters = text.substring(1);
        return firstLetter.toLowerCase() + remainingLetters.toLowerCase();
    }

    /**
     * Converts a text to pascal case.
     *
     * @param text represents the text to be converted
     * @return a String
     */
    public static String toPascalCase(final String text) {
        toCamelCase(text);
        String firstLetter = text.substring(0, 1);
        String remainingLetters = text.substring(1);
        String camelCaseString = "";
        return firstLetter.toUpperCase() + remainingLetters.toLowerCase();
    }
}
