package salesforce.ui.pages.lightning.contracts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.pages.BasePage;
import java.util.HashMap;

public class CreatedContractPage extends BasePage {

    @FindBy(xpath = "(//span[text()='Details'])[last()]")
    private WebElement details;
    @FindBy(xpath = "(//ul//li//div//span[@title=\"Account Name\"] /following-sibling::div)[last()]")
    private WebElement accountNameTitle;
    @FindBy(xpath = "(//ul//li//div//span[@title=\"Contract Start Date\"] /following-sibling::div)[last()]")
    private WebElement contractStartDateTitle;
    @FindBy(xpath = "(//ul//li//div//span[@title=\"Contract End Date\"] /following-sibling::div)[last()]")
    private WebElement contractEndDateTitle;
    @FindBy(xpath = "//div[./div[./span[text()='Contract Owner']]]//a")
    private WebElement contractOwner;
    @FindBy(xpath = "//div[./div[./span[text()='Status']]]//span//span")
    private WebElement status;
    @FindBy(xpath = "(//div[./div[./span[text()='Contract Start Date']]]//span//span)[last()]")
    private WebElement contractStartDate;
    @FindBy(xpath = "//div[./div[./span[text()='Account Name']]]//a")
    private WebElement accountName;
    @FindBy(xpath = "//div[./div[./span[text()='Contract End Date']]]//span//span")
    private WebElement contractEndDate;
    @FindBy(xpath = "//div[./div[./span[text()='Customer Signed By']]]//a")
    private WebElement customerSignedBy;
    @FindBy(xpath = "//div[./div[./span[text()='Contract Term (months)']]]//span//span")
    private WebElement contractTerm;
    @FindBy(xpath = "//div[./div[./span[text()='Customer Signed Title']]]//span//span")
    private WebElement customerSignedTitle;
    @FindBy(xpath = "//div[./div[./span[text()='Owner Expiration Notice']]]//span//span")
    private WebElement ownerExpirationNotice;
    @FindBy(xpath = "//div[./div[./span[text()='Customer Signed Date']]]//span//span")
    private WebElement customerSignedDate;
    @FindBy(xpath = "//div[./div[./span[text()='Company Signed By']]]//button/preceding-sibling::span")
    private WebElement companySignedBy;
    @FindBy(xpath = "//div[./div[./span[text()='Price Book']]]//a")
    private WebElement priceBook;
    @FindBy(xpath = "//div[./div[./span[text()='Company Signed Date']]]//button/preceding-sibling::span")
    private WebElement companySignedDate;
    @FindBy(xpath = "//div[./div[./span[text()='Special Terms']]]//span//span")
    private WebElement specialTerms;
    @FindBy(xpath = "//div[./div[./span[text()='Description']]]//span//span")
    private WebElement description;
    private static final String BASE_XPATH = "//div[./div[./span[text()='%s']]]";
    private static final HashMap<String, String> XPATH_COMPLEMENTS = new HashMap<>();
    static {
        XPATH_COMPLEMENTS.put("Contract Owner", "//a");
        XPATH_COMPLEMENTS.put("Status", "//span//span");
        XPATH_COMPLEMENTS.put("Account Name", "//a");
        XPATH_COMPLEMENTS.put("Contract End Date", "//span//span");
        XPATH_COMPLEMENTS.put("Customer Signed By", "//a");
        XPATH_COMPLEMENTS.put("Contract Term (months)", "//span//span");
        XPATH_COMPLEMENTS.put("Customer Signed Title", "//span//span");
        XPATH_COMPLEMENTS.put("Owner Expiration Notice", "//span//span");
        XPATH_COMPLEMENTS.put("Customer Signed Date", "//span//span");
        XPATH_COMPLEMENTS.put("Company Signed By", "//button/preceding-sibling::span");
        XPATH_COMPLEMENTS.put("Price Book", "//a");
        XPATH_COMPLEMENTS.put("Company Signed Date", "//button/preceding-sibling::span");
        XPATH_COMPLEMENTS.put("Special Terms", "//span//span");
        XPATH_COMPLEMENTS.put("Description", "//span//span");
    }

    /**
     * Gets the text inside the element.
     *
     * @return the text set on the account name assigned to a contract.
     */
    public CreatedContractPage clickDetails() {
        webElementAction.clickField(details);
        webElementAction.dropDownTillTheEnd();
        return this;
    }
    /**
     * Gets the text inside the element.
     *
     * @param field
     * @return the text set on the field requested contract.
     */
    public String getTextByField(final String field) {
        String xpathComplement = XPATH_COMPLEMENTS.get(field);
        String xpath = String.format(BASE_XPATH, field).concat(xpathComplement);
        return webElementAction.getTextOfElementByField(xpath);
    }

    /**
     * Gets the text inside the element.
     *
     * @return the text set on the field requested contract.
     */
    public String contractStartDateText() {
        return webElementAction.getTextOfElement(contractStartDate);
    }

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisible(accountNameTitle);
    }
}
