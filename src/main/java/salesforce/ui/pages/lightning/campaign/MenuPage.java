/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.campaign;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.BasePage;

/**
 * This class is for menu page.
 */
public class MenuPage extends BasePage {

    @FindBy(xpath = "//div[@role=\'menu\']//a[./div[@title=\'Delete\']]")
    private WebElement deleteBtn;

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisible(deleteBtn);
    }
}
