package salesforce.api.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceBook{
//    public Attributes attributes;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("IsDeleted")
    public Boolean isDeleted;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("CreatedDate")
    public String createdDate;
    @JsonProperty("CreatedById")
    public String createdById;
    @JsonProperty("LastModifiedDate")
    public String lastModifiedDate;
    @JsonProperty("LastModifiedById")
    public String lastModifiedById;
    @JsonProperty("SystemModstamp")
    public String systemModstamp;
    @JsonProperty("LastViewedDate")
    public String lastViewedDate;
    @JsonProperty("LastReferencedDate")
    public String lastReferencedDate;
    @JsonProperty("IsActive")
    public Boolean isActive;
    @JsonProperty("IsArchived")
    public Boolean isArchived;
    @JsonProperty("Description")
    public Object description;
    @JsonProperty("IsStandard")
    public Boolean isStandard;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public String getSystemModstamp() {
        return systemModstamp;
    }

    public void setSystemModstamp(String systemModstamp) {
        this.systemModstamp = systemModstamp;
    }

    public String getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastViewedDate(String lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public String getLastReferencedDate() {
        return lastReferencedDate;
    }

    public void setLastReferencedDate(String lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Boolean getStandard() {
        return isStandard;
    }

    public void setStandard(Boolean standard) {
        isStandard = standard;
    }
}
