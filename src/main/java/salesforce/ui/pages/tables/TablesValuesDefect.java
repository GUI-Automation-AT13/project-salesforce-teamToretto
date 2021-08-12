package salesforce.ui.pages.tables;

import org.openqa.selenium.InvalidArgumentException;
import salesforce.config.EnvConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static core.utils.date.DateManager.addMonthsDate;
import static core.utils.date.DateManager.generateDateActual;

public class TablesValuesDefect {
    public List<String> getExpectedValues(String factureName, Map<String, String> tableFeature){
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

    private List<String> workTypeTableValue( Map<String, String> tableFeature){
        return new ArrayList<String>(tableFeature.values());
    }

    private List<String> contractTableValue( Map<String, String> tableFeature){
        tableFeature.put("Contract End Date", addMonthsDate(tableFeature.get("Contract Start Date"),
                Integer.parseInt(tableFeature.get("Contract Term (months)"))));
        return new ArrayList<String>(tableFeature.values());
    }

    private List<String> campaignTableValue( Map<String, String> tableFeature){
        tableFeature.put("Responses in Campaign", "0");
        tableFeature.put("Owner Alias", EnvConfig.getInstance().getAdminUser().getAlias());
        return new ArrayList<String>(tableFeature.values());
    }

    private List<String> individualTableValue( Map<String, String> tableFeature){
        tableFeature.put("Alias", EnvConfig.getInstance().getAdminUser().getAlias());
        tableFeature.put("Last Modified By Alias", EnvConfig.getInstance().getAdminUser().getAlias());
        tableFeature.put("Created By Alias", EnvConfig.getInstance().getAdminUser().getAlias());
        tableFeature.put("Last Modified Date", generateDateActual("M/d/yyyy, h:mm a"));
        return new ArrayList<String>(tableFeature.values());
    }
}
