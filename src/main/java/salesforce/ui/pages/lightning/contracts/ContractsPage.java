/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.contracts;

import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.FeatureNew;
import salesforce.utils.strategy.FeaturesPage;

/**
 * Page Object Model for the salesforce contracts page.
 */
public class ContractsPage extends BasePage implements FeaturesPage {

    private By newContractButton = By.cssSelector("a[title='New']");

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(newContractButton);
    }

    /**
     * Logs in successfully.
     *
     * @return a ProductPage instance
     */
    public NewContractPage clickNewContractButton() {
        webElementAction.clickByLocator(newContractButton);
        return new NewContractPage();
    }

    @Override
    public FeatureNew clickNewButton() {
        return null;
    }
}
