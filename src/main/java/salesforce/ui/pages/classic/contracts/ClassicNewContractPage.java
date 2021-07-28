package salesforce.ui.pages.classic.contracts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.BasePage;

public class ClassicNewContractPage extends BasePage {
    @FindBy(css = "#ctrc7")
    private WebElement accountName;
    @FindBy(css = "#ctrc16")
    private WebElement customerSignedBy;
    @FindBy(css = "#CustomerSignedTitle")
    private WebElement customerSignedTittle;
    @FindBy(css = "#ctrc6")
    private WebElement customerSignedDate;
    @FindBy(css = "#ctrc17")
    private WebElement priceBook;
    @FindBy(css = "#ctrc5")
    private WebElement contractStartDate;
    @FindBy(css = "#ctrc40")
    private WebElement contractTermMonths;
    @FindBy(css = "#ctrc13")
    private WebElement ownerExpirationNotice;
    @FindBy(css = "#CompanySignedDate")
    private WebElement companySignedDate;
    @FindBy(css = "#ctrc25street")
    private WebElement billingStreet;
    @FindBy(css = "#ctrc25city")
    private WebElement billingCity;
    @FindBy(css = "#ctrc25state")
    private WebElement billingState;
    @FindBy(css = "#ctrc25zip")
    private WebElement billingPostalCode;
    @FindBy(css = "#ctrc25country")
    private WebElement billingCountry;
    @FindBy(css = "#SpecialTerms")
    private WebElement specialTerms;
    @FindBy(css = "#Description")
    private WebElement description;
    @FindBy(css = "td[id='bottomButtonRow'] input[title='Save']")
    private WebElement save;
    @FindBy(css = "td[id='bottomButtonRow'] input[title='Save & New']")
    private WebElement saveAndNew;
    @FindBy(css = "td[id='bottomButtonRow'] input[title='Cancel']")
    private WebElement cancel;

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisible(accountName);
    }

    /**
     * Sets the account name on a contract.
     *
     * @param newAccountName
     */
    public void setAccountName(final String newAccountName) {
        this.accountName.sendKeys(newAccountName);
    }

    /**
     * Sets the CustomerSignedBy element.
     *
     * @param newCustomerSignedBy to be typed.
     */
    public void setCustomerSignedBy(final String newCustomerSignedBy) {
        this.customerSignedBy.sendKeys(newCustomerSignedBy);
    }

    /**
     * Sets the CustomerSignedTittle element.
     *
     * @param newCustomerSignedTittle to be typed.
     */
    public void setCustomerSignedTittle(final String newCustomerSignedTittle) {
        this.customerSignedTittle.sendKeys(newCustomerSignedTittle);
    }

    /**
     * Sets the customerSignedDate element.
     *
     * @param newCustomerSignedDate to be typed.
     */
    public void setCustomerSignedDate(final String newCustomerSignedDate) {
        this.customerSignedDate.sendKeys(newCustomerSignedDate);
    }

    /**
     * Sets the priceBook element.
     *
     * @param newPriceBook to be typed.
     */
    public void setPriceBook(final String newPriceBook) {
        if (newPriceBook == "Standandar") {
            this.priceBook.click();
            priceBook.findElement(By.xpath("//option[. = 'Standard']")).click();
        }
    }

    /**
     * Sets the contractStartDate element.
     *
     * @param newContractStartDate to be typed.
     */
    public void setContractStartDate(final String newContractStartDate) {
        this.contractStartDate.sendKeys(newContractStartDate);
    }

    /**
     * Sets the contractTermMonths element.
     *
     * @param newContractTermMonths to be typed.
     */
    public void setContractTermMonths(final String newContractTermMonths) {
        this.contractTermMonths.sendKeys(newContractTermMonths);
    }

    /**
     * Sets the ownerExpirationNotice element.
     *
     * @param newOwnerExpirationNotice to be typed.
     */
    public void setOwnerExpirationNotice(final String newOwnerExpirationNotice) {
        this.ownerExpirationNotice.click();
        switch (newOwnerExpirationNotice) {
            case "15 Days":
                ownerExpirationNotice.findElement(By.xpath("//option[. = '15 Days']")).click();
            case "30 Days":
                ownerExpirationNotice.findElement(By.xpath("//option[. = '30 Days']")).click();
            case "45 Days":
                ownerExpirationNotice.findElement(By.xpath("//option[. = '45 Days']")).click();
            case "60 Days":
                ownerExpirationNotice.findElement(By.xpath("//option[. = '60 Days']")).click();
            case "90 Days":
                ownerExpirationNotice.findElement(By.xpath("//option[. = '90 Days']")).click();
            case "120 Days":
                ownerExpirationNotice.findElement(By.xpath("//option[. = '120 Days']")).click();
            default:
                break;
        }
    }

    /**
     * Sets the companySignedDate element.
     *
     * @param newCompanySignedDate to be typed.
     */
    public void setCompanySignedDate(final String newCompanySignedDate) {
        this.companySignedDate.sendKeys(newCompanySignedDate);
    }

    /**
     * Sets the billingStreet element.
     *
     * @param newBillingStreet to be typed.
     */
    public void setBillingStreet(final String newBillingStreet) {
        this.billingStreet.sendKeys(newBillingStreet);
    }

    /**
     * Sets the billingCity element.
     *
     * @param newBillingCity to be typed.
     */
    public void setBillingCity(final String newBillingCity) {
        this.billingCity.sendKeys(newBillingCity);
    }

    /**
     * Sets the billingState element.
     *
     * @param newBillingState to be typed.
     */
    public void setBillingState(final String newBillingState) {
        this.billingState.sendKeys(newBillingState);
    }

    /**
     * Sets the billingPostalCode element.
     *
     * @param newBillingPostalCode to be typed.
     */
    public void setBillingPostalCode(final String newBillingPostalCode) {
        this.billingPostalCode.sendKeys(newBillingPostalCode);
    }

    /**
     * Sets the billingCountry element.
     *
     * @param newBillingCountry to be typed.
     */
    public void setBillingCountry(final String newBillingCountry) {
        this.billingCountry.sendKeys(newBillingCountry);
    }

    /**
     * Sets the specialTerms element.
     *
     * @param newSpecialTerms to be typed.
     */
    public void setSpecialTerms(final String newSpecialTerms) {
        this.specialTerms.sendKeys(newSpecialTerms);
    }

    /**
     * Sets the description element.
     *
     * @param newDescription to be typed.
     */
    public void setDescription(final String newDescription) {
        this.description.sendKeys(newDescription);
    }

    /**
     * Clicks on the save button.
     *
     * @return a CreatedContractPage.
     */
    public ClassicCreatedContractPage clickSave() {
        this.save.click();
        return new ClassicCreatedContractPage();
    }

    /**
     * Clicks on the save and new button and goes to a new contract to be created.
     *
     * @return a NewContractPage.
     */
    public ClassicNewContractPage clickSaveAndNew() {
        this.saveAndNew.click();
        return new ClassicNewContractPage();
    }

    /**
     * Clicks on the cancel button.
     *
     * @return a ContractsPage.
     */
    public ClassicContractsPage clickCancel() {
        this.cancel.click();
        return new ClassicContractsPage();
    }

}
