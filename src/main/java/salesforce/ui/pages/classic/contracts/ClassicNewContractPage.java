package salesforce.ui.pages.classic.contracts;

import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;

/**
 * Page object model for the salesforce classic new contract page.
 */
public class ClassicNewContractPage extends BasePage {

    private By accountName = By.cssSelector("#ctrc7");
    private By customerSignedBy = By.cssSelector("#ctrc16");
    private By customerSignedTittle = By.cssSelector("#CustomerSignedTitle");
    private By customerSignedDate = By.cssSelector("#ctrc6");
    private By priceBook = By.cssSelector("#ctrc17");
    private By contractStartDate = By.cssSelector("#ctrc5");
    private By contractTermMonths = By.cssSelector("#ctrc40");
    private By ownerExpirationNotice = By.cssSelector("#ctrc13");
    private By companySignedDate = By.cssSelector("#CompanySignedDate");
    private By billingStreet = By.cssSelector("#ctrc25street");
    private By billingCity = By.cssSelector("#ctrc25city");
    private By billingState = By.cssSelector("#ctrc25state");
    private By billingPostalCode = By.cssSelector("#ctrc25zip");
    private By billingCountry = By.cssSelector("#ctrc25country");
    private By specialTerms = By.cssSelector("#SpecialTerms");
    private By description = By.cssSelector("#Description");
    private By save = By.cssSelector("td[id='bottomButtonRow'] input[title='Save']");
    private By saveAndNew = By.cssSelector("td[id='bottomButtonRow'] input[title='Save & New']");
    private By cancel = By.cssSelector("td[id='bottomButtonRow'] input[title='Cancel']");
    private String ownerExpirationNoticeSelector = "//option[. = '%s Days']";

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(accountName);
    }

    /**
     * Sets the account name on a contract.
     *
     * @param newAccountName represents an account name
     */
    public void setAccountName(final String newAccountName) {
        webElementAction.setInputField(this.accountName, newAccountName);
    }

    /**
     * Sets the CustomerSignedBy element.
     *
     * @param newCustomerSignedBy to be typed.
     */
    public void setCustomerSignedBy(final String newCustomerSignedBy) {
        webElementAction.setInputField(this.customerSignedBy, newCustomerSignedBy);
    }

    /**
     * Sets the CustomerSignedTittle element.
     *
     * @param newCustomerSignedTittle to be typed.
     */
    public void setCustomerSignedTittle(final String newCustomerSignedTittle) {
        webElementAction.setInputField(this.customerSignedTittle, newCustomerSignedTittle);
    }

    /**
     * Sets the customerSignedDate element.
     *
     * @param newCustomerSignedDate to be typed.
     */
    public void setCustomerSignedDate(final String newCustomerSignedDate) {
        webElementAction.setInputField(this.customerSignedDate, newCustomerSignedDate);
    }

    /**
     * Sets the priceBook element.
     *
     * @param newPriceBook to be typed.
     */
    public void setPriceBook(final String newPriceBook) {
        if (newPriceBook == "Standard") {
            webElementAction.clickByLocator(priceBook);
            webElementAction.clickByLocator(By.xpath("//option[. = 'Standard']"));
        }
    }

    /**
     * Sets the contractStartDate element.
     *
     * @param newContractStartDate to be typed.
     */
    public void setContractStartDate(final String newContractStartDate) {
        webElementAction.setInputField(this.contractStartDate, newContractStartDate);
    }

    /**
     * Sets the contractTermMonths element.
     *
     * @param newContractTermMonths to be typed.
     */
    public void setContractTermMonths(final String newContractTermMonths) {
        webElementAction.setInputField(this.contractTermMonths, newContractTermMonths);
    }

    /**
     * Sets the ownerExpirationNotice element.
     *
     * @param newOwnerExpirationNotice to be typed.
     */
    public void setOwnerExpirationNotice(final String newOwnerExpirationNotice) {
        webElementAction.getElement(this.ownerExpirationNotice);
        webElementAction.clickOnElement(ownerExpirationNoticeSelector, newOwnerExpirationNotice);

    }

    /**
     * Sets the companySignedDate element.
     *
     * @param newCompanySignedDate to be typed.
     */
    public void setCompanySignedDate(final String newCompanySignedDate) {
        webElementAction.setInputField(this.companySignedDate, newCompanySignedDate);
    }

    /**
     * Sets the billingStreet element.
     *
     * @param newBillingStreet to be typed.
     */
    public void setBillingStreet(final String newBillingStreet) {
        webElementAction.setInputField(this.billingStreet, newBillingStreet);
    }

    /**
     * Sets the billingCity element.
     *
     * @param newBillingCity to be typed.
     */
    public void setBillingCity(final String newBillingCity) {
        webElementAction.setInputField(this.billingCity, newBillingCity);
    }

    /**
     * Sets the billingState element.
     *
     * @param newBillingState to be typed.
     */
    public void setBillingState(final String newBillingState) {
        webElementAction.setInputField(this.billingState, newBillingState);
    }

    /**
     * Sets the billingPostalCode element.
     *
     * @param newBillingPostalCode to be typed.
     */
    public void setBillingPostalCode(final String newBillingPostalCode) {
        webElementAction.setInputField(this.billingPostalCode, newBillingPostalCode);
    }

    /**
     * Sets the billingCountry element.
     *
     * @param newBillingCountry to be typed.
     */
    public void setBillingCountry(final String newBillingCountry) {
        webElementAction.setInputField(this.billingCountry, newBillingCountry);
    }

    /**
     * Sets the specialTerms element.
     *
     * @param newSpecialTerms to be typed.
     */
    public void setSpecialTerms(final String newSpecialTerms) {
        webElementAction.setInputField(this.specialTerms, newSpecialTerms);
    }

    /**
     * Sets the description element.
     *
     * @param newDescription to be typed.
     */
    public void setDescription(final String newDescription) {
        webElementAction.setInputField(this.description, newDescription);
    }

    /**
     * Clicks on the save button.
     *
     * @return a CreatedContractPage.
     */
    public ClassicCreatedContractPage clickSave() {
        webElementAction.clickByLocator(save);
        return new ClassicCreatedContractPage();
    }

    /**
     * Clicks on the save and new button and goes to a new contract to be created.
     *
     * @return a NewContractPage.
     */
    public ClassicNewContractPage clickSaveAndNew() {
        webElementAction.clickByLocator(saveAndNew);
        return new ClassicNewContractPage();
    }

    /**
     * Clicks on the cancel button.
     *
     * @return a ContractsPage.
     */
    public ClassicContractsPage clickCancel() {
        webElementAction.clickByLocator(cancel);
        return new ClassicContractsPage();
    }

}
