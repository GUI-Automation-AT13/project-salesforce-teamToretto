/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.salesforce.hooks;

import core.selenium.WebDriverManager;
import io.cucumber.java.After;
import org.testng.asserts.SoftAssert;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.lightning.individuals.IndividualListPage;

public class IndividualScenarioHooks {

    private WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;
    private SoftAssert softAssert;

    public IndividualScenarioHooks(final WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(this.webDriverManager);
    }

    @After(value = "@CreateIndividual")
    public void setLast() {
        IndividualListPage individualListPage = pageTransporter.navigateToIndividualListPage();
        individualListPage.deleteLastModifiedRecord();
    }
}
