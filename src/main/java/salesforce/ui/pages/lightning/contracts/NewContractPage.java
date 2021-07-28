package salesforce.ui.pages.lightning.contracts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.BasePage;
import java.util.HashMap;

public class NewContractPage extends BasePage {
    @FindBy(css = "input[placeholder='Search Accounts...']")
    private WebElement accountName;
    @FindBy(xpath = "//mark[normalize-space()='TestAccount']")
    private WebElement accountSelector;
    @FindBy(css = "input[placeholder='Search Contacts...']")
    private WebElement customerSignedBy;
    @FindBy(xpath = "//div[@title='TestContact']")
    private WebElement contactSelector;
    @FindBy(xpath = "(//div/input[@class = ' input'])[2]")
    private WebElement customerSignedTittle;
    @FindBy(xpath = "(//div/input[@class = ' input'])[3]")
    private WebElement customerSignedDate;
    @FindBy(css = "input[placeholder='Search Price Books...']")
    private WebElement priceBook;
    @FindBy(xpath = "//mark[normalize-space()='Standard']")
    private WebElement priceBookSelector;
    @FindBy(xpath = "(//div/input[@class =' input'])[1]")
    private WebElement contractStartDate;
    @FindBy(css = ".input.uiInputSmartNumber")
    private WebElement contractTermMonths;
    @FindBy(css = ".select[aria-required='false']")
    private WebElement ownerExpirationNotice;
    @FindBy(linkText = "15 Days")
    private static HashMap<String, String> ownerExpirationNoticeSelector = new HashMap<>();
    @FindBy(xpath = "(//div/input[@class = ' input'])[4]")
    private WebElement companySignedDate;
    @FindBy(css = "textarea[placeholder='Billing Street']")
    private WebElement billingStreet;
    @FindBy(css = "input[placeholder='Billing City']")
    private WebElement billingCity;
    @FindBy(css = "input[placeholder='Billing State/Province']")
    private WebElement billingState;
    @FindBy(css = "input[placeholder='Billing Zip/Postal Code']")
    private WebElement billingPostalCode;
    @FindBy(css = "input[placeholder='Billing Country']")
    private WebElement billingCountry;
    @FindBy(xpath = "(//textarea[@class=\" textarea\" ])[1]")
    private WebElement specialTerms;
    @FindBy(xpath = "(//textarea[@class=\" textarea\" ])[last()]")
    private WebElement description;
    @FindBy(css = "button[title='Save']")
    private WebElement save;
    @FindBy(css = "button[title='Save & New']")
    private WebElement saveAndNew;
    @FindBy(css = "button[title='Cancel']")
    private WebElement cancel;

    static {
        ownerExpirationNoticeSelector.put("15 Days", "15 Days");
        ownerExpirationNoticeSelector.put("30 Days", "30 Days");
        ownerExpirationNoticeSelector.put("45 Days", "45 Days");
        ownerExpirationNoticeSelector.put("60 Days", "60 Days");
        ownerExpirationNoticeSelector.put("90 Days", "90 Days");
        ownerExpirationNoticeSelector.put("120 Days", "120 Days");
    }

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisible(save);
    }

    /**
     * Sets the account name on a contract.
     *
     * @param newAccountName .
     */
    public void setAccountName(final String newAccountName) {
        webElementAction.setInputField(this.accountName, newAccountName);
    }

    /**
     * Selects the account name on a contract.
     */
    public void clickAccountSelector() {
        webElementAction.clickField(this.accountSelector);
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
     * Selects the contact name on a contract.
     */
    public void clickContactSelector() {
        webElementAction.clickField(this.contactSelector);
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
        webElementAction.setInputField(customerSignedDate, newCustomerSignedDate);
    }

    /**
     * Sets the priceBook element.
     *
     * @param newPriceBook to be typed.
     */
    public void setPriceBook(final String newPriceBook) {
        webElementAction.setInputField(this.priceBook, newPriceBook);
    }

    /**
     * Sets the priceBook element.
     */
    public void selectPriceBook() {
        webElementAction.clickField(this.priceBookSelector);
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
     */
    public void clickOwnerExpirationNotice() {
        webElementAction.clickField(this.ownerExpirationNotice);
    }

    /**
     * Sets the ownerExpirationNotice element on the selector.
     *
     * @param value for the xpath
     */
    public void selectOwnerExpirationNotice(final String value) {
        webElementAction.clickFieldByLocator(ownerExpirationNoticeSelector.get(value));
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
    public CreatedContractPage clickSave() {
        this.save.click();
        return new CreatedContractPage();
    }

    /**
     * Clicks on the save and new button and goes to a new contract to be created.
     *
     * @return a NewContractPage.
     */
    public NewContractPage clickSaveAndNew() {
        this.saveAndNew.click();
        return new NewContractPage();
    }

    /**
     * Clicks on the cancel button.
     *
     * @return a ContractsPage.
     */
    public ContractsPage clickCancel() {
        this.cancel.click();
        return new ContractsPage();
    }
}
