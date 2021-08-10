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
        while (matcher.find())
            list.add(String.valueOf(matcher.group(1)));
        return list;
    }
}
