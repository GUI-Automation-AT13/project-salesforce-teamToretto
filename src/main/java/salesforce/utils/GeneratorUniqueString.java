package salesforce.utils;

import core.utils.RandomCustom;

import java.util.HashMap;
import java.util.Map;

public final class GeneratorUniqueString {

    private GeneratorUniqueString() {
    }

    /**
     * Replaces the name with a name + custom random.
     *
     * @param mapAnalyzed map to analyze
     * @return new map with different name
     */
    public static Map<String, String> nameUnique(final Map<String, String> mapAnalyzed) {
        Map<String, String> mapNew = new HashMap<String, String>(mapAnalyzed);
        for (String value : mapNew.keySet()) {
            if (containsName(value)) {
                mapNew.put(value, mapNew.get(value) + RandomCustom.random());
                break;
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
    public static boolean containsName(final String word) {
        return word.toLowerCase().matches(".*name.*");
    }
}
