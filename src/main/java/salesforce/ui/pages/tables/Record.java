/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a Salesforce Table Record.
 */
public class Record {

    Map<String, String> record;

    /**
     * Constructor for a record out of a map.
     *
     * @param map is the map for the record values and column name keys.
     */
    public Record(final Map<String, String> map) {
        this.record = map;
    }

    /**
     * Constructor for a record initializating the map.
     */
    public Record() {
        this.record = new HashMap<String, String>();
    }

    /**
     * Returns a value given they key.
     */
    public String get(final String key) {
        return record.get(key);
    }

    /**
     * Inserts a value in the record map.
     */
    public String set(final String key, final String value) {
        return record.put(key, value);
    }

    /**
     * Gets the keys from the record map.
     *
     * @return a List
     */
    public List<String> getKeys() {
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, String> entry : record.entrySet()) {
            keys.add(entry.getKey());
        }
        return keys;
    }

    /**
     * Gets the values from the record.
     *
     * @return a List
     */
    public List<String> getValues() {
        List<String> values = new ArrayList<>();
        for (Map.Entry<String, String> entry : record.entrySet()) {
            values.add(entry.getValue());
        }
        return values;
    }

    /**
     * Checks if there is a value contining the given text.
     *
     * @param text represent the text to match with
     * @return a boolean
     */
    public boolean thereIsValueContainingText(final String text) {
        List<String> values = getValues();
        for (String value : values) {
            if (value.toLowerCase().contains(text.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
