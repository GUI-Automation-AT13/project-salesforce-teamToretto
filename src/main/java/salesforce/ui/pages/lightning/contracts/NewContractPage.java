/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.contracts;

import static salesforce.utils.Internalization.translate;

import core.selenium.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;
import salesforce.utils.strategy.CreatedFeature;
import salesforce.utils.strategy.FeatureNew;
import salesforce.utils.supplier.VoidSupplier;

/**
 * Page Object Model for the salesforce new contract page.
 */
public class NewContractPage extends BasePage implements FeatureNew {
    private By accountName = By.cssSelector("input[placeholder='" + translate("SearchAccounts") + "']");
    private By accountSelector = By.xpath("//mark[normalize-space()='TestAccount']");
    private By customerSignedBy = By.cssSelector("input[placeholder='" + translate("SearchContacts") + "']");
    private By contactSelector = By.xpath("//div[@title='TestContact']");
    private By customerSignedTittle = By.xpath("(//div/input[@class = ' input'])[2]");
    private By customerSignedDate = By.xpath("(//div/input[@class = ' input'])[3]");
    private By priceBook = By.cssSelector("input[placeholder='" + translate("SearchPriceBooks") + "']");
    private By priceBookSelector = By.xpath("//mark[normalize-space()='Standard']");
    private By contractStartDate = By.xpath("(//div/input[@class =' input'])[1]");
    private By contractTermMonths = By.cssSelector(".input.uiInputSmartNumber");
    private By ownerExpirationNotice = By.cssSelector(".select[aria-required='false']");
    private static HashMap<String, String> ownerExpirationNoticeSelector = new HashMap<>();
    private By companySignedDate = By.xpath("(//div/input[@class = ' input'])[4]");
    private By billingStreet = By.cssSelector("textarea[placeholder='" + translate("BillingStreet") + "']");
    private By billingCity = By.cssSelector("input[placeholder='" + translate("BillingCity") + "']");
    private By billingState = By.cssSelector("input[placeholder='" + translate("BillingStateProvince") + "']");
    private By billingPostalCode = By.cssSelector("input[placeholder='" + translate("BillingZipPostalCode") + "']");
    private By billingCountry = By.cssSelector("input[placeholder='" + translate("BillingCountry") + "']");
    private By specialTerms = By.xpath("(//textarea[@class=\" textarea\" ])[1]");
    private By description = By.xpath("(//textarea[@class=\" textarea\" ])[last()]");
    private By save = By.cssSelector("button[title='" + translate("Save") + "']");
    private By saveAndNew = By.cssSelector("button[title='" + translate("SaveAndNew") + "']");
    private By cancel = By.cssSelector("button[title='" + translate("Cancel") + "']");

    static {
        ownerExpirationNoticeSelector.put("15 Days", "15 " + translate("Days"));
        ownerExpirationNoticeSelector.put("30 Days", "30 " + translate("Days"));
        ownerExpirationNoticeSelector.put("45 Days", "45 " + translate("Days"));
        ownerExpirationNoticeSelector.put("60 Days", "60 " + translate("Days"));
        ownerExpirationNoticeSelector.put("90 Days", "90 " + translate("Days"));
        ownerExpirationNoticeSelector.put("120 Days", "120 " + translate("Days"));
    }

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager .
     */
    public NewContractPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(save);
    }

    /**
     * Sets the account name on a contract.
     *
     * @param newAccountName .
     */
    public void setAccountName(final String newAccountName) {
        webElementAction.setInputField(this.accountName, newAccountName);
        clickAccountSelector();
    }

    /**
     * Selects the account name on a contract.
     */
    public void clickAccountSelector() {
        webElementAction.clickByLocator(this.accountSelector);
    }

    /**
     * Sets the CustomerSignedBy element.
     *
     * @param newCustomerSignedBy to be typed.
     */
    public void setCustomerSignedBy(final String newCustomerSignedBy) {
        webElementAction.setInputField(this.customerSignedBy, newCustomerSignedBy);
        clickContactSelector();
    }

    /**
     * Selects the contact name on a contract.
     */
    public void clickContactSelector() {
        webElementAction.clickByLocator(this.contactSelector);
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
        selectPriceBook();
    }

    /**
     * Sets the priceBook element.
     */
    public void selectPriceBook() {
        webElementAction.clickByLocator(this.priceBookSelector);
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
        webElementAction.clickByLocator(this.ownerExpirationNotice);
    }

    /**
     * Sets the ownerExpirationNotice element on the selector.
     *
     * @param value for the xpath
     */
    public void selectOwnerExpirationNotice(final String value) {
        clickOwnerExpirationNotice();
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
        webElementAction.clickByLocator(save);
        return new CreatedContractPage(webDriverManager);
    }

    /**
     * Clicks on the save and new button and goes to a new contract to be created.
     *
     * @return a NewContractPage.
     */
    public NewContractPage clickSaveAndNew() {
        webElementAction.clickByLocator(saveAndNew);
        return new NewContractPage(webDriverManager);
    }

    /**
     * Clicks on the cancel button.
     *
     * @return a ContractsPage.
     */
    public ContractsPage clickCancel() {
        webElementAction.clickByLocator(cancel);
        return new ContractsPage(webDriverManager);
    }

    @Override
    public void fillUpField(Map<String, String> table) {
        HashMap<String, VoidSupplier> actionsContractMap = mapActionsContract(table);
        table.keySet().forEach(key -> actionsContractMap.get(key).run());
    }

    /**
     * Saves actions in New work type page in map.
     *
     * @param contractMap is map
     * @return a map with action of fields
     */
    private HashMap<String, VoidSupplier> mapActionsContract(final Map<String, String> contractMap) {
        HashMap<String, VoidSupplier> mapActions = new HashMap<>();
        mapActions.put("Account Name", () -> setAccountName(contractMap.get("Account Name")));
        mapActions.put("Contract Term (months)", () -> setContractTermMonths(contractMap
                .get("Contract Term (months)")));
        mapActions.put("Contract Start Date", () -> setContractStartDate(contractMap.get("Contract Start Date")));
        mapActions.put("Customer Signed By", () -> setCustomerSignedBy(contractMap.get("Customer Signed By")));
        mapActions.put("Customer Signed Title", () -> setCustomerSignedTittle(contractMap
                .get("Customer Signed Title")));
        mapActions.put("Customer Signed Date", () -> setCustomerSignedDate(contractMap
                .get("Customer Signed Date")));
        mapActions.put("Price Book", () -> setPriceBook(contractMap.get("Price Book")));
        mapActions.put("Owner Expiration Notice", () -> selectOwnerExpirationNotice(contractMap
                .get("Owner Expiration Notice")));
        mapActions.put("Company Signed Date", () -> setCompanySignedDate(contractMap.get("Company Signed Date")));
        mapActions.put("Billing Street", () -> setBillingStreet(contractMap.get("Billing Street")));
        mapActions.put("Billing City", () -> setBillingCity(contractMap.get("Billing City")));
        mapActions.put("Billing state", () -> setBillingState(contractMap.get("Billing state")));
        mapActions.put("Billing postal code", () -> setBillingPostalCode(contractMap.get("Billing postal code")));
        mapActions.put("Billing country", () -> setBillingCountry(contractMap.get("Billing country")));
        mapActions.put("Special Terms", () -> setSpecialTerms(contractMap.get("Special Terms")));
        mapActions.put("Description", () -> setDescription(contractMap.get("Description")));
        return mapActions;
    }

    @Override
    public CreatedFeature clickSaveButton() {
        webElementAction.clickByLocator(save);
        return new CreatedContractPage(webDriverManager);
    }
}
