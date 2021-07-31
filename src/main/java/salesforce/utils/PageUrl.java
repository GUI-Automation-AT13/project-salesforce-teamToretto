package salesforce.utils;

import salesforce.config.EnvConfig;

public class PageUrl {

    private static String baseUrl = EnvConfig.getInstance().getBaseUrl();

    /**
     * .
     *
     * @param feature .
     * @return .
     */
    public static String getFeaturePage(String feature) {
        String url = baseUrl.concat("lightning/o/" + feature + "/list?filterName=Recent");
        return url;
    }

}
