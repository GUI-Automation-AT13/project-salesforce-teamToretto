package api.salesforce.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * This class builds an account body.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {

    @JsonProperty("Id")
    public String id;
    @JsonProperty("Name")
    public String name;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * Sets the Id.
     *
     * @param  newId name
     */
    public void setId(final String newId) {
        this.id = newId;
    }
    /**
     * gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the Id.
     *
     * @param  newName name
     */
    public void setName(final String newName) {
        this.name = newName;
    }
}