package worktype;

import base.BaseTests;
import org.testng.annotations.Test;
import salesforce.config.EnvConfig;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.lightning.HomePage;
import salesforce.ui.pages.lightning.contracts.ContractsPage;
import salesforce.ui.pages.lightning.contracts.CreatedContractPage;
import salesforce.ui.pages.lightning.contracts.NewContractPage;
import salesforce.ui.pages.lightning.worktype.CreatedWorkTypePage;
import salesforce.ui.pages.lightning.worktype.NewWorkTypePage;
import salesforce.ui.pages.lightning.worktype.WorkTypesPage;

import static org.testng.Assert.assertEquals;

public class WorkTypeTest extends BaseTests {
    private HomePage homePage;
    private WorkTypesPage workTypesPage;
    private NewWorkTypePage newWorkTypePage;
    private CreatedWorkTypePage createdWorkTypePage;

    @Test
    public void createWorkTypeLightningSalesforce() {
        LoginPage loginPage = new LoginPage();
        homePage = loginPage.loginSuccessful(EnvConfig.getInstance().getUser(),
                EnvConfig.getInstance().getPassword());
        workTypesPage = pageTransporter.navigateToWorkTypePageLightning();
        newWorkTypePage = workTypesPage.clickNewButton();
        newWorkTypePage.setInputField("Work Type Name", "Work Type created");
        newWorkTypePage.setInputField("Description", "Descriptions-test-22");
        newWorkTypePage.setInputField("Estimated Duration", "68");
        newWorkTypePage.setEstimatedDurationComboBox("Minutes");
        newWorkTypePage.setInputField("Block Time Before Appointment", "52");
        newWorkTypePage.setComboBoxField("Block Time Before Unit", "Hour(s)");
        newWorkTypePage.setInputField("Block Time After Appointment", "5");
        newWorkTypePage.setComboBoxField("Block Time After Unit", "Hour(s)");
        newWorkTypePage.setInputField("Timeframe Start", "4");
        newWorkTypePage.setComboBoxField("Time Frame Start Unit", "Day(s)");
        newWorkTypePage.setInputField("Timeframe End", "5");
        newWorkTypePage.setComboBoxField("Time Frame End Unit", "Day(s)");
        createdWorkTypePage = newWorkTypePage.clickSaveButton();
        assertEquals(createdWorkTypePage.getNameOfWorkType(), "Work Type created");
        assertEquals(createdWorkTypePage.getDescription(), "Descriptions-test-22");
        assertEquals(createdWorkTypePage.getTxtField("Estimated Duration"), "68,00");
        assertEquals(createdWorkTypePage.getTxtField("Block Time Before Appointment"), "52");
        assertEquals(createdWorkTypePage.getTxtField("Block Time After Appointment"), "5");
        assertEquals(createdWorkTypePage.getTxtField("Timeframe Start"), "4");
        assertEquals(createdWorkTypePage.getTxtField("Timeframe End"), "5");
    }
}
