package core.utils;

public class Converter {

    /**
     * Removes all white space in string
     *
     * @param words to removes white space
     * @return a new string without space
     */
    public static String removeWhiteSpace(final String words) {
        return words.replaceAll("\\s+","");
    }
}
