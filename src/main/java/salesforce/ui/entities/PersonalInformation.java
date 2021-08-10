package salesforce.ui.entities;

public class PersonalInformation {
    private String zoneinfo;
    private boolean emailVerified;
    private String userId;
    private String organizationId;
    private String nickname;
    private String name;
    private String preferredUsername;
    private String givenName;
    private String familyName;
    private String email;
    private String alias;

    public String getAlias() {
        return alias;
    }

    public void setAlias(final String alias) {
        this.alias = alias;
    }

    public void setZoneinfo(final String zoneinfo) {
        this.zoneinfo = zoneinfo;
    }

    public String getZoneinfo() {
        return zoneinfo;
    }

    public void setEmailVerified(final boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setOrganizationId(final String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPreferredUsername(final String preferredUsername) {
        this.preferredUsername = preferredUsername;
    }

    public String getPreferredUsername() {
        return preferredUsername;
    }

    public void setGivenName(final String givenName) {
        this.givenName = givenName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setFamilyName(final String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
