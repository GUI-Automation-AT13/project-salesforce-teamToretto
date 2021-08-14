/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils;

import core.config.EnvConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

/**
 * Generates the report file for tests scenarios.
 */
public class ReportGenerator {

    /**
     * Generates the report file for tests scenarios.
     */
    public static void generateReport() {
        File reportOutputDirectory = new File("build/cucumber");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("build/cucumber/cucumber.json");
        String buildNumber = "1";
        String projectName = "SeleniumProject";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
        configuration.setBuildNumber(buildNumber);
        configuration.addClassifications("Platform", System.getProperty("os.name"));
        configuration.addClassifications("Browser", EnvConfig.getInstance().getBrowser().toLowerCase());
        configuration.addClassifications("Branch", "release/1.0");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
    }
}
