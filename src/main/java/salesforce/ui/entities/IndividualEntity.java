/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.entities;

/**
 * Represents a Salesforce Individual Object.
 */
public class IndividualEntity {

    private String salutation;

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    private String firstname;
    private String lastname;
    private String birthdate;
    private boolean dontProcess;
    private boolean dontMarket;
    private boolean exportIndividualsData;
    private boolean okToStorePiiDataElsewhere;
    private boolean blockGeolocationTracking;
    private boolean dontProfile;
    private boolean dontTrack;
    private boolean forgetThisIndividual;
    private String individualsAge;

    public boolean isDontProcess() {
        return dontProcess;
    }

    public void setDontProcess(boolean dontProcess) {
        this.dontProcess = dontProcess;
    }

    public boolean isExportIndividualsData() {
        return exportIndividualsData;
    }

    public void setExportIndividualsData(boolean exportIndividualsData) {
        this.exportIndividualsData = exportIndividualsData;
    }

    public boolean isOkToStorePiiDataElsewhere() {
        return okToStorePiiDataElsewhere;
    }

    public void setOkToStorePiiDataElsewhere(boolean okToStorePiiDataElsewhere) {
        this.okToStorePiiDataElsewhere = okToStorePiiDataElsewhere;
    }

    public boolean isBlockGeolocationTracking() {
        return blockGeolocationTracking;
    }

    public void setBlockGeolocationTracking(boolean blockGeolocationTracking) {
        this.blockGeolocationTracking = blockGeolocationTracking;
    }

    public boolean isDontProfile() {
        return dontProfile;
    }

    public void setDontProfile(boolean dontProfile) {
        this.dontProfile = dontProfile;
    }

    public boolean isDontTrack() {
        return dontTrack;
    }

    public void setDontTrack(boolean dontTrack) {
        this.dontTrack = dontTrack;
    }

    public boolean isForgetThisIndividual() {
        return forgetThisIndividual;
    }

    public void setForgetThisIndividual(boolean forgetThisIndividual) {
        this.forgetThisIndividual = forgetThisIndividual;
    }

    public String getIndividualsAge() {
        return individualsAge;
    }

    public void setIndividualsAge(String individualsAge) {
        this.individualsAge = individualsAge;
    }

    /**
     * Gets the firstname value.
     *
     * @return String
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the firstname value.
     *
     * @param firstnameValue represents the Individual firstname
     */
    public void setFirstname(final String firstnameValue) {
        this.firstname = firstnameValue;
    }

    /**
     * Gets the lastname value.
     *
     * @return String
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the lastname value.
     *
     * @param lastnameValue represents the Individual lastname
     */
    public void setLastname(final String lastnameValue) {
        this.lastname = lastnameValue;
    }

    /**
     * Gets the birthdate value.
     *
     * @return Date
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the birthdate value.
     *
     * @param birthdateValue represents the Individual birthdate date
     */
    public void setBirthdate(final String birthdateValue) {
        this.birthdate = birthdateValue;
    }

    /**
     * Gets the Don't Market value.
     *
     * @return boolean
     */
    public boolean isDontMarket() {
        return dontMarket;
    }

    /**
     * Sets the Don't Market value.
     *
     * @param dontMarketValue represents the boolean value for the individual dont market value option
     */
    public void setDontMarket(final boolean dontMarketValue) {
        this.dontMarket = dontMarketValue;
    }

    /**
     * Returns the full name.
     *
     * @return String
     */
    public String getFullName() {
        return this.firstname.concat(" ").concat(lastname);
    }

    /**
     * Returns the full name with salutation.
     *
     * @return String
     */
    public String getFullnameWithSalutation() {
        return String.format("%s %s %s", salutation, firstname, lastname);
    }
}
