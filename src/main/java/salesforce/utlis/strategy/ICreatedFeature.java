package salesforce.utlis.strategy;

import java.util.List;
import java.util.Map;

public interface ICreatedFeature {
    List<String> getValueField(Map<String, String> table);
}
