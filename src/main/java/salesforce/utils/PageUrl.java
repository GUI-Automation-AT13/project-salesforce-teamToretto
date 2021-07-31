package salesforce.utils;

import salesforce.config.EnvConfig;

/**
 * This class is for concats baseUrl with feature page.
 */
public class PageUrl {

    private static String baseUrl = EnvConfig.getInstance().getBaseUrl();

    /**
     * Gets a url of page of feature.
     *
     * @param feature is a name of the feature.
     * @return a complete url of feature.
     */
    public static String getFeaturePage(String feature) {
        String url = baseUrl.concat("lightning/o/" + feature + "/list?filterName=Recent");
        return url;
    }
}
