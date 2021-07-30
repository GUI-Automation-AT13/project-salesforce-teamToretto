package salesforce.utlis.strategy;

import java.util.Map;

public interface IFeatureNew {
    void fillUpField(Map<String, String> table);

    ICreatedFeature clickSaveButton();
}
