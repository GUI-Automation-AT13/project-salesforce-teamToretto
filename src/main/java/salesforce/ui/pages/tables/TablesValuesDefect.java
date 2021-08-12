/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.tables;

import static core.utils.date.DateManager.addMonthsDate;
import static core.utils.date.DateManager.generateDateActual;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.InvalidArgumentException;
import salesforce.config.EnvConfig;
import salesforce.config.users.AdminUser;

/**
 * This class contains expected values of tables.
 */
public class TablesValuesDefect {

    /**
     * Select the table according feature.
     *
     * @param factureName name of feature
     * @param tableFeature is table with some values
     * @return a list with expected values of table
     */
    public List<String> getExpectedValues(String factureName, Map<String, String> tableFeature) {
        switch (factureName.toLowerCase()) {
            case "worktype":
                return workTypeTableValue(tableFeature);
            case "contract":
                return contractTableValue(tableFeature);
            case "individual":
                return individualTableValue(tableFeature);
            case "campaign":
                return campaignTableValue(tableFeature);
            default:
                throw new InvalidArgumentException("Invalid feature or add this feature");
        }
    }

    /**
     * Sets some default or autogenerate value of work type and gets this values.
     *
     * @param tableFeature is some values of table
     * @return a list with values of table
     */
    private List<String> workTypeTableValue(Map<String, String> tableFeature) {
        return new ArrayList<String>(tableFeature.values());
    }

    /**
     * Sets some default or autogenerate value of contract and gets this values.
     *
     * @param tableFeature is some values of table
     * @return a list with values of table
     */
    private List<String> contractTableValue(Map<String, String> tableFeature) {
        tableFeature.put("Contract End Date", addMonthsDate(tableFeature.get("Contract Start Date"),
                Integer.parseInt(tableFeature.get("Contract Term (months)"))));
        return new ArrayList<String>(tableFeature.values());
    }

    /**
     * Sets some default or autogenerate value of campaign and gets this values.
     *
     * @param tableFeature is some values of table
     * @return a list with values of table
     */
    private List<String> campaignTableValue(Map<String, String> tableFeature) {
        tableFeature.put("Responses in Campaign", "0");
        tableFeature.put("Owner Alias", EnvConfig.getInstance().getAdminUser().getAlias());
        return new ArrayList<String>(tableFeature.values());
    }

    /**
     * Sets some default or autogenerate value of Individual and gets this values.
     *
     * @param tableFeature is some values of table
     * @return a list with values of table
     */
    private List<String> individualTableValue(Map<String, String> tableFeature) {
        tableFeature.put("Alias", EnvConfig.getInstance().getAdminUser().getAlias());
        tableFeature.put("Last Modified By Alias", EnvConfig.getInstance().getAdminUser().getAlias());
        tableFeature.put("Created By Alias", EnvConfig.getInstance().getAdminUser().getAlias());
        tableFeature.put("Last Modified Date", generateDateActual("M/d/yyyy, h:mm a"));
        return new ArrayList<String>(tableFeature.values());
    }
}
