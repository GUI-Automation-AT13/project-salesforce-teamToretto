/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.worktype;

import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utlis.strategy.IFeaturesPage;

/**
 * This class has webElement for work types page.
 */
public class WorkTypesPage extends BasePage implements IFeaturesPage {
    protected By newBtn = By.xpath("//a[@class='forceActionLink'][@role='button']");

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(newBtn);
    }

    /**
     * Changes the page to create work type.
     *
     * @return workTypeForm initialize.
     */
    public NewWorkTypePage clickNewButton() {
        webElementAction.clickByLocator(newBtn);
        return new NewWorkTypePage();
    }
}
