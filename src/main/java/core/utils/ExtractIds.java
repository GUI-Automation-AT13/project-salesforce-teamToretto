/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class extract list of ids as list.
 */
public class ExtractIds {

    /**
     * Returns a list with all the ids.
     *
     * @param json result jsonn as string.
     * @return list of Ids.
     */
    public static List<String> extractIdsFromJson(String json) {
        List<String> list = new ArrayList<String>();
        Matcher matcher = Pattern.compile("\"Id\":\"(.*?)\"").matcher(json);
        while (matcher.find()) {
            list.add(String.valueOf(matcher.group(1)));
        }
        return list;
    }
}
