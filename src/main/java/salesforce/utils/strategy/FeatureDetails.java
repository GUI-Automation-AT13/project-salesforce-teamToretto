package salesforce.utils.strategy;

import java.util.List;
import java.util.Map;

/**
 * Implements details on a feature created.
 */
public interface FeatureDetails {
    List<String> getValueField(Map<String, String> table);

    String getCreateDayTxt();

}
