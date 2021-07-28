package Contracts;

import base.ContractBaseTest;
import org.testng.annotations.Test;
import salesforce.config.EnvConfig;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.lightning.HomePage;
import salesforce.ui.pages.lightning.contracts.ContractsPage;
import salesforce.ui.pages.lightning.contracts.CreatedContractPage;
import salesforce.ui.pages.lightning.contracts.NewContractPage;

public class ContractTest extends ContractBaseTest {
    private HomePage homePage;
    private ContractsPage contractsPage;
    private NewContractPage newContractPage;
    private CreatedContractPage createdContractPage;

    @Test(groups = {"CreateContractWithFullValues"})
    public void createAContractWitFullValues(){
        LoginPage loginPage = new LoginPage();
        homePage = loginPage.loginSuccessful(EnvConfig.getInstance().getUser(),
                EnvConfig.getInstance().getPassword());
        contractsPage = pageTransporter.navigateToContractsPageLightning();
        newContractPage = contractsPage.clickNewContractButton();
        newContractPage.setAccountName("TestAccount");
        newContractPage.clickAccountSelector();
        newContractPage.setContractTermMonths("2");
        newContractPage.setContractStartDate("7/15/2021");
        newContractPage.setCustomerSignedBy("TestContact");
        newContractPage.clickContactSelector();
        newContractPage.setCustomerSignedTittle("tittle");
        newContractPage.setCustomerSignedDate("7/15/2021");
        newContractPage.setPriceBook("Standard");
        newContractPage.selectPriceBook();
        newContractPage.clickOwnerExpirationNotice();
        newContractPage.selectOwnerExpirationNotice("30 Days");
        newContractPage.setCompanySignedDate("7/19/2021");
        newContractPage.setBillingStreet("Billing Street");
        newContractPage.setBillingCity("Billing City");
        newContractPage.setBillingStreet("Billing Street");
        newContractPage.setBillingState("Billing state");
        newContractPage.setBillingPostalCode("Billing postal code");
        newContractPage.setBillingCountry("Billing country");
        newContractPage.setSpecialTerms("SpecialTerms");
        newContractPage.setDescription("Description");
        createdContractPage = newContractPage.clickSave();
        createdContractPage.clickDetails();
        softAssert.assertEquals(createdContractPage.getTextByField("Account Name"),
                "TestAccount");
        softAssert.assertEquals(createdContractPage.getTextByField("Contract Term (months)"),
                "2");
        softAssert.assertEquals(createdContractPage.contractStartDateText(),
                "7/15/2021");
        softAssert.assertEquals(createdContractPage.getTextByField("Customer Signed By"),
                "TestContact");
        softAssert.assertEquals(createdContractPage.getTextByField("Customer Signed Title"),
                "tittle");
        softAssert.assertEquals(createdContractPage.getTextByField("Customer Signed Date"),
                "7/15/2021");
        softAssert.assertEquals(createdContractPage.getTextByField("Price Book"),
                "Standard");
        softAssert.assertEquals(createdContractPage.getTextByField("Owner Expiration Notice"),
                "30 Days");
        softAssert.assertEquals(createdContractPage.getTextByField("Company Signed Date"),
                "7/19/2021");
        softAssert.assertEquals(createdContractPage.getTextByField("Special Terms"),
                "SpecialTerms");
        softAssert.assertEquals(createdContractPage.getTextByField("Description"),
                "Description");
        softAssert.assertAll();
    }
    @Test(groups = {"CreateContractWithMinimumValues"})
    public void createAContractWitMinimumValues(){
        LoginPage loginPage = new LoginPage();
        homePage = loginPage.loginSuccessful(EnvConfig.getInstance().getUser(),
                EnvConfig.getInstance().getPassword());
        contractsPage = pageTransporter.navigateToContractsPageLightning();
        newContractPage = contractsPage.clickNewContractButton();
        newContractPage.setAccountName("TestAccount");
        newContractPage.clickAccountSelector();
        newContractPage.setContractTermMonths("2");
        newContractPage.setContractStartDate("7/15/2021");
        createdContractPage = newContractPage.clickSave();
        createdContractPage.clickDetails();
        softAssert.assertEquals(createdContractPage.getTextByField("Account Name"),
                "TestAccount");
        softAssert.assertEquals(createdContractPage.getTextByField("Contract Term (months)"),
                "2");
        softAssert.assertEquals(createdContractPage.contractStartDateText(),
                "7/15/2021");
        softAssert.assertAll();
    }
}
