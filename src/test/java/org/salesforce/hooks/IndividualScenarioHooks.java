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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;
import salesforce.ui.pages.lightning.individuals.IndividualsPage;
import salesforce.utils.PageTransporter;

/**
 * This class defines hooks for the individuals feature.
 */
public class IndividualScenarioHooks {

    private Logger log = LogManager.getLogger(getClass());
    private WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;
    private SoftAssert softAssert;

    /**
     * This class defines hooks for the individuals feature.
     */
    public IndividualScenarioHooks(final WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(this.webDriverManager);
    }

    /**
     * Deletes an individual via UI.
     */
    @After(value = "@CreateIndividual")
    public void deleteIndividual() {
        log.info("Delete Individual");
        IndividualsPage individualsPage = pageTransporter.navigateToIndividualListPage();
        individualsPage.deleteLastModifiedRecord();
    }
}
