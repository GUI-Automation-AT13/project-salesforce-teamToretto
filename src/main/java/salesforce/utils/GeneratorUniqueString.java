package salesforce.utils;

import static salesforce.utils.Internalization.translate;

import core.utils.RandomCustom;
import java.util.HashMap;
import java.util.Map;

/**
 * Generates unique String.
 */
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
                break;
            }
        }
        return appliedInternalization(mapNew);
    }

    /**
     * Verifies has word name.
     *
     * @param word a string
     * @return a boolean
     */
    private static boolean containsName(final String word, final String nameFeature) {
        return word.toLowerCase().matches(".*name.*") & !"Contract".equals(nameFeature)
                & !"Individual".equals(nameFeature);
    }

    /**
     * Translates maps with Internalization.
     *
     * @param mapAnalyzed a map to translates
     * @return a new map with translate
     */
    private static Map<String, String> appliedInternalization(final Map<String, String> mapAnalyzed) {
        Map<String, String> mapNew = new HashMap<String, String>();
        mapAnalyzed.keySet().forEach(key -> mapNew.put(key, translate(mapAnalyzed.get(key))));
        return mapNew;
    }
}
