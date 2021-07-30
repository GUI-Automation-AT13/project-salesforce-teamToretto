/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.lightning.individuals;

import core.selenium.WebDriverManager;
import java.util.HashMap;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.entities.IndividualEntity;
import salesforce.ui.pages.BasePage;

/**
 * Page Object Model for the salesforce individual form page.
 */
public class IndividualFormPage extends BasePage {


    private final String generalSalutationOptionSelector = "[title=\"%s\"]";
    private final String generalCheckboxSelector = "//div[label[contains(.,\"%s\")]]/input";
    private final String ageGeneralSelector = "//a[contains(text(),\'%s\')]";

    private By salutationSelector = By.cssSelector(".salutation a");
    private By firstnameTextbox = By.cssSelector(".firstName");
    private By lastnameTextbox = By.cssSelector(".lastName");
    private By birthdateDateField = By.cssSelector("input[class=' input']");
    private By individualAgeSelector = By.xpath("//div[span[span[contains(text(),'Age')]]]/div//a");
    private By age13Option = By.xpath("//a[contains(text(),\'13 or Older\')]");
    private By age16Option = By.xpath("//a[contains(text(),\'16 or Older\')]");
    private By saveButton = By.cssSelector("button[title=\"Save\"]");
    private By createdIndividualLabel = By.cssSelector(".slds-page-header__title > .uiOutputText");
    private By createdSuccessMessage = By.xpath("//span[contains(.,\"was created.\")]");

    /**
     * Clicks the saluatation selector.
     */
    public void clickOnSalutationDropDownMenu() {
        webElementAction.clickByLocator(salutationSelector);
    }

    /**
     * Clicks the Mr. option
     */
    public void clickOnMrOption() {
        webElementAction.clickOnElement(generalSalutationOptionSelector, "Mr.");
    }

    /**
     * Clicks the Mrs. option
     */
    public void clickOnMrsOption() {
        webElementAction.clickOnElement(generalSalutationOptionSelector, "Mrs.");
    }

    /**
     * Clicks the Ms. option
     */
    public void clickOnMsOption() {
        webElementAction.clickOnElement(generalSalutationOptionSelector, "Ms.");
    }

    /**
     * Clicks the Dr. option
     */
    public void clickOnDrOption() {
        webElementAction.clickOnElement(generalSalutationOptionSelector, "Dr.");
    }

    /**
     * Clicks the Prof. option
     */
    public void clickOnProfOption() {
        webElementAction.clickOnElement(generalSalutationOptionSelector, "Prof.");
    }

    /**
     * Sets the firstname value to the field.
     *
     * @param firstname represents a firstname
     */
    public void setFirstnameTextbox(final String firstname) {
        webElementAction.setInputField(firstnameTextbox, firstname);
    }

    /**
     * Sets the lastname value to the field.
     *
     * @param lastname represents the lastname to be set
     */
    public void setLastnameTextbox(final String lastname) {
        webElementAction.setInputField(lastnameTextbox, lastname);
    }

    /**
     * Sets the date for the birthdate field.
     *
     * @param date represents the date to be set
     */
    public void setBirthdateDateField(final String date) {
        webElementAction.setInputField(birthdateDateField, date);
    }

    /**
     * Clicks on the Don't Process checkbox.
     */
    public void clickOnDontProcessCheckbox() {
        webElementAction.clickOnElement(generalCheckboxSelector, "Don't Process");
    }

    /**
     * Clicks on the Don't Market checkbox.
     */
    public void clickOnDontMarketCheckbox() {
        webElementAction.clickOnElement(generalCheckboxSelector, "Don't Market");
    }

    /**
     * Clicks on the Export Individual's Data checkbox.
     */
    public void clickOnExportIndividualDataCheckbox() {
        webElementAction.clickOnElement(generalCheckboxSelector, "Export Individual's Data");
    }

    /**
     * Clicks on the OK to Store PII Data checkbox.
     */
    public void clickOnOkToStorePiiDataCheckbox() {
        webElementAction.clickOnElement(generalCheckboxSelector, "OK to Store PII Data");
    }

    /**
     * Clicks on the Block Geolocation checkbox.
     */
    public void clickOnBlockGeolocationCheckbox() {
        webElementAction.clickOnElement(generalCheckboxSelector, "Block Geolocation");
    }

    /**
     * Clicks on the Don't Profile checkbox.
     */
    public void clickOnDontProfileCheckbox() {
        webElementAction.clickOnElement(generalCheckboxSelector, "Don't Profile");
    }

    /**
     * Clicks on the Don't Track Checkbox.
     */
    public void clickOnDontTrackCheckbox() {
        webElementAction.clickOnElement(generalCheckboxSelector, "Don't Track");
    }

    /**
     * Clicks on the Forget This Individual checkbox.
     */
    public void clickOnForgetThisIndividualCheckbox() {
        webElementAction.clickOnElement(generalCheckboxSelector, "Forget this Individual");
    }

    /**
     * Clicks on the IndividualAgeSelector.
     */
    public void clickOnIndividualAgeSelector() {
        webElementAction.clickByLocator(individualAgeSelector);
    }

    /**
     * Clicks on the Age13 option.
     */
    public void clickOnAge13Option() {
        webElementAction.clickByLocator(age13Option);
    }

    /**
     * Clicks on the Age16 option.
     */
    public void clickOnAge16Option() {
        webElementAction.clickByLocator(age16Option);
    }

    /**
     * Clicks on the save button.
     *
     * @return IndividualRecordPage
     */
    public IndividualRecordPage clickOnsave() {
        webElementAction.clickByLocator(saveButton);
        return new IndividualRecordPage();
    }

    /**
     * Returns an alert message.
     *
     * @return String
     */
    public String getCreatedSuccessMessage() {
        return webElementAction.getTextOfByFieldByLocator(createdSuccessMessage);
    }

    /**
     * Checks if the createdIndividual label element is visible.
     *
     * @return a boolean
     */
    public Boolean isVisibleIndividualNameInHeader() {
        return webElementAction.isDisplayed(createdIndividualLabel);
    }

    /**
     * Returns the text of the IndividualName element.
     *
     * @return String
     */
    public String getCreatedIndividualNameInHeader() {
        return webElementAction.getTextOfByFieldByLocator(createdIndividualLabel);
    }

    /**
     * Creates an individual with the given parameters in a map.
     *
     * @param fields represents the field keys to be introduced
     * @param entity represents as pojo.
     * @return IndividualFormPage
     */
    public IndividualFormPage createIndividual(final Set<String> fields, final IndividualEntity entity) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("salutation", () -> clickOnSalutationOption(entity.getSalutation()));
        strategyMap.put("lastname", () -> setLastnameTextbox(entity.getLastname()));
        strategyMap.put("firstname", () -> setFirstnameTextbox(entity.getFirstname()));
        strategyMap.put("birthdate", () -> setBirthdateDateField(entity.getBirthdate()));
        strategyMap.put("dontProcess", () -> clickOnDontProcessCheckbox());
        strategyMap.put("dontMarket", () -> clickOnDontMarketCheckbox());
        strategyMap.put("exportIndividualsData", () -> clickOnExportIndividualDataCheckbox());
        strategyMap.put("okToStorePiiDataElsewhere", () -> clickOnIndividualAgeSelector());
        strategyMap.put("blockGeolocationTracking", () -> clickOnBlockGeolocationCheckbox());
        strategyMap.put("dontProfile", () -> clickOnDontProfileCheckbox());
        strategyMap.put("dontTrack", () -> clickOnDontTrackCheckbox());
        strategyMap.put("forgetThisIndividual", () -> clickOnForgetThisIndividualCheckbox());
        strategyMap.put("individualsAge", () -> clickOnIndividualAgeOption(entity.getIndividualsAge()));
        fields.forEach(field -> strategyMap.get(field).run());
        clickOnsave();
        return this;
    }

    /**
     * Clicks and selects an Individual age option.
     *
     * @param age represents the age
     */
    private void clickOnIndividualAgeOption(String age) {
        clickOnIndividualAgeSelector();
        webElementAction.clickOnElement(ageGeneralSelector, age);
    }

    /**
     * Clicks on a salutation option.
     *
     * @param salutation represents a salutation abbreviation.
     */
    private void clickOnSalutationOption(String salutation) {
        clickOnSalutationDropDownMenu();
        webElementAction.clickOnElement(generalSalutationOptionSelector, salutation);
    }

    /**
     * Method to wait for a page to load.
     */
    @Override
    protected void waitForPageLoaded() {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.presenceOfElementLocated(saveButton));
    }
}
