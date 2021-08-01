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
import io.cucumber.java.Before;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import salesforce.config.EnvConfig;
import salesforce.ui.PageTransporter;
import salesforce.ui.pages.lightning.HomePage;
import salesforce.ui.pages.lightning.LoginPage;
import salesforce.ui.pages.lightning.individuals.IndividualFormPage;
import salesforce.ui.pages.lightning.individuals.IndividualListPage;

public class IndividualScenarioHooks {

    private PageTransporter pageTransporter;
    private SoftAssert softAssert;

    public IndividualScenarioHooks(final PageTransporter pageTransporter, final SoftAssert softAssert) {
        this.pageTransporter = pageTransporter;
        this.softAssert = softAssert;
    }

    @After(value = "@CreateIndividual")
    public void setLast() {
        IndividualListPage individualListPage = pageTransporter.navigateToIndividualListPage();
        individualListPage.deleteLastModifiedRecord();
        String actual = individualListPage.getDeletedSuccessMessage();
        String expected = "was deleted.";
        Assert.assertTrue(actual.contains(expected));
    }
}
