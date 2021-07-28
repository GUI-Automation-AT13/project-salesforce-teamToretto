package Contracts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import salesforce.config.EnvConfig;
import salesforce.ui.pages.classic.ClassicHomePage;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.classic.contracts.ClassicContractsPage;
import salesforce.ui.pages.classic.contracts.ClassicCreatedContractPage;
import salesforce.ui.pages.classic.contracts.ClassicNewContractPage;

public class ClassicContractsTest extends BaseTests {

    private ClassicHomePage classicHomePage;
    private ClassicContractsPage classicContractsPage;
    private ClassicNewContractPage classicNewContractPage;
    private ClassicCreatedContractPage classicCreatedContractPage;

    @Test
    public void createContractWithRequiredValuesTest()  {
        LoginPage loginPage = new LoginPage();
        String accountName = "TestAccount";
        classicHomePage = loginPage.loginClassicSuccessful(EnvConfig.getInstance().getUser(),
                EnvConfig.getInstance().getPassword());
        classicContractsPage = pageTransporter.navigateToContractsPage();
        classicContractsPage.clickPopUP();
        classicNewContractPage = classicContractsPage.clickNew();
        classicNewContractPage.setAccountName(accountName);
        classicNewContractPage.setContractTermMonths("2");
        classicNewContractPage.setContractStartDate("7/15/2021");
        classicCreatedContractPage = classicNewContractPage.clickSave();
        Assert.assertEquals(classicCreatedContractPage.getAccountName(), "TestAccount");
    }
    @Test
    public void createContractWithAllValuesTest()  {
        LoginPage loginPage = new LoginPage();
        String accountName = "TestAccount";
        classicHomePage = loginPage.loginClassicSuccessful(EnvConfig.getInstance().getUser(),
                EnvConfig.getInstance().getPassword());
        classicContractsPage = pageTransporter.navigateToContractsPage();
        classicContractsPage.clickPopUP();
        classicNewContractPage = classicContractsPage.clickNew();
        classicNewContractPage.setAccountName(accountName);
        classicNewContractPage.setContractTermMonths("2");
        classicNewContractPage.setContractStartDate("7/15/2021");
        classicNewContractPage.setCustomerSignedBy("TestContact");
        classicNewContractPage.setCustomerSignedTittle("tittle");
        classicNewContractPage.setCustomerSignedDate("7/15/2021");
        classicNewContractPage.setPriceBook("Standard");
        classicNewContractPage.setOwnerExpirationNotice("90 Days");
        classicNewContractPage.setCompanySignedDate("7/19/2021");
        classicNewContractPage.setBillingStreet("Billing Street");
        classicNewContractPage.setBillingCity("Billing City");
        classicNewContractPage.setBillingStreet("Billing Street");
        classicNewContractPage.setBillingState("Billing state");
        classicNewContractPage.setBillingPostalCode("Billing postal code");
        classicNewContractPage.setBillingCountry("Billing country");
        classicNewContractPage.setSpecialTerms("SpecialTerms");
        classicNewContractPage.setDescription("Description");
        classicCreatedContractPage = classicNewContractPage.clickSave();
        Assert.assertEquals(classicCreatedContractPage.getAccountName(), "TestAccount");
    }

}
