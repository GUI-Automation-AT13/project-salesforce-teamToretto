/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.entities;

import java.util.Date;

/**
 * Represents a salesforce Entity.
 */
public class IndividualEntity {

    private String firstname;
    private String lastname;
    private Date birthdate;
    private boolean dontMarket;
    private String age;

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
     * @param firstnameValue represents the firstname
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
     * @param lastnameValue represents the lastname
     */
    public void setLastname(final String lastnameValue) {
        this.lastname = lastnameValue;
    }

    /**
     * Gets the birthdate value.
     *
     * @return Date
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the birthdate value.
     *
     * @param birthdateValue represents the birthdate date
     */
    public void setBirthdate(final Date birthdateValue) {
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
     * @param dontMarketValue represents the boolean for the dont market checkbox
     */
    public void setDontMarket(final boolean dontMarketValue) {
        this.dontMarket = dontMarketValue;
    }

    /**
     * Gets the Age value.
     *
     * @return String
     */
    public String getAge() {
        return age;
    }

    /**
     * Sets the Age value.
     *
     * @param ageValue represents an age
     */
    public void setAge(final String ageValue) {
        this.age = ageValue;
    }
}
