package salesforce.utils;

import salesforce.config.EnvConfig;
import java.util.Locale;
import java.util.ResourceBundle;
import static core.utils.Converter.removeWhiteSpace;

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
        return resourceBundle.getString(removeWhiteSpace(word));
    }
}
