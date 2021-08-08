package core.utils;

import core.utils.date.DateManager;
import java.util.UUID;

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
        String[] uniqueID = UUID.randomUUID().toString().split("-");
        return uniqueID[2];
    }
}
