/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.utils;

import static core.utils.Converter.removeWhiteSpace;
import java.util.Locale;
import java.util.ResourceBundle;
import salesforce.config.EnvConfig;

/**
 * Class to read internationalization file.
 */
public class Internalization {
    private static final String FILE_PATH = "internationalization/i18N%s";
    private static ResourceBundle resourceBundle;

    public Internalization(String featureName) {
        translateValue(featureName);
    }

    /**
     * Creates ResourceBundle.
     *
     * @param feature name file on internationalization
     * @return a String with the translated word
     */
    private void translateValue(final String feature) {
        resourceBundle = ResourceBundle.getBundle(String.format(FILE_PATH, feature),
                new Locale(EnvConfig.getInstance().getLanguage()));
    }

    /**
     * Translates a work using ResourceBundle.
     *
     * @param word is String to Translate.
     * @return a String according language.
     */
    public static String translate(String word) {
        try {
            return resourceBundle.getString(removeWhiteSpace(word));
        } catch (Exception e) {
            return word;
        }
    }
}
