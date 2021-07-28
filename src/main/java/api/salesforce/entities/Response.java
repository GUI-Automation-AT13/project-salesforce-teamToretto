package api.salesforce.entities;

import java.util.List;

/**
 * This class defines a created object response.
 */
public class Response {
    public String id;
    public boolean success;
    public List<Object> errors;

    /**
     * Gets the id.
     *
     * @return the id.
     */
    public String getId() {
        return id;
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
     * Gets the success.
     *
     * @return the success.
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets the success.
     *
     * @param newSuccess to be set.
     */
    public void setSuccess(final boolean newSuccess) {
        this.success = newSuccess;
    }

    /**
     * Gets the errors.
     *
     * @return the errors.
     */
    public List<Object> getErrors() {
        return errors;
    }

    /**
     * Sets the errors.
     *
     * @param newErrors to be set.
     */
    public void setErrors(final List<Object> newErrors) {
        this.errors = newErrors;
    }
}
