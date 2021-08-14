package salesforce.utils;

import salesforce.config.EnvConfig;

/**
 * This class has urls salesforce.
 */
public enum Urls {
    PATH_LOGIN("https://login.salesforce.com/"),
    FEATURE_URL_LIGHTNING("lightning/o/%s/list?filterName=Recent"),
    WORKTYPE_CLASSIC(EnvConfig.getInstance().getBaseUrl() + "08q/o"),
    TOKEN("https://login.salesforce.com/services/oauth2/token"),
    OPERATING_HOURS(EnvConfig.getInstance().getBaseUrl() + "services/data/v52.0/sobjects/OperatingHours");

    private String value;

    Urls(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}
