package salesforce.utils;

import core.utils.RandomCustom;

import java.util.HashMap;
import java.util.Map;

import static salesforce.utils.Internalization.translate;

public final class GeneratorUniqueString {

    private GeneratorUniqueString() {
    }

    /**
     * Replaces the name with a name + custom random.
     *
     * @param mapAnalyzed map to analyze
     * @return new map with different name
     */
    public static Map<String, String> nameUnique(final Map<String, String> mapAnalyzed, final String nameFeature) {
        Map<String, String> mapNew = new HashMap<String, String>(mapAnalyzed);
        for (String value : mapNew.keySet()) {
            if (containsName(value, nameFeature)) {
                mapNew.put(value, translate(mapNew.get(value)) + RandomCustom.random());
            } else {
                mapNew.put(value, translate(mapNew.get(value)));
            }
        }
        return mapNew;
    }

    /**
     * Verifies has word name.
     *
     * @param word a string
     * @return a boolean
     */
    public static boolean containsName(final String word, final String nameFeature) {
        return word.toLowerCase().matches(".*name.*") & !"contract".equals(nameFeature);
    }
}
