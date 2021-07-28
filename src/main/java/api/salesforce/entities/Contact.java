package api.salesforce.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * This class defines a Contact.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String accountId;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String lastName;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String firstName;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String email;

    /**
     * Gets the email.
     *
     * @return the email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * Sets the newEmail.
     *
     * @param newEmail to be set.
     */
    public void setEmail(final String newEmail) {
        this.email = newEmail;
    }

    /**
     * Gets the Id.
     *
     * @return the Id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param newId to be set.
     */
    public void setId(final String newId) {
        this.id = newId;
    }

    /**
     * Gets the AccountId.
     *
     * @return the AccountId.
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * Sets the accountId.
     *
     * @param newAccountId to be set.
     */
    public void setAccountId(final String newAccountId) {
        this.accountId = newAccountId;
    }

    /**
     * Gets the LastName.
     *
     * @return the LastName.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the lastName.
     *
     * @param newLastName to be set.
     */
    public void setLastName(final String newLastName) {
        this.lastName = newLastName;
    }

    /**
     * Gets the FirstName.
     *
     * @return the FirstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the firstName.
     *
     * @param newFirstName to be set.
     */
    public void setFirstName(final String newFirstName) {
        this.firstName = newFirstName;
    }

    /**
     * Gets the Name.
     *
     * @return the Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param newName to be set.
     */
    public void setName(final String newName) {
        this.name = newName;
    }

}
