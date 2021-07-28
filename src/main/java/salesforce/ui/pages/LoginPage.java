package salesforce.ui.pages;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.classic.ClassicHomePage;
import salesforce.ui.pages.lightning.HomePage;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement userNameTxtBox;

    @FindBy(id = "password")
    private WebElement passwordTxtBox;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    /**
     * Waits for the page to be loaded.
     */
    @Override
    protected void waitForPageLoaded() {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(loginBtn));
    }

    /**
     * Sets the user name.
     *
     * @param userName to be set.
     * @return the user name instance.
     */
    private LoginPage setUserName(final String userName) {
        userNameTxtBox.sendKeys(userName);
        return this;
    }

    /**
     * Sets the user password.
     *
     * @param password to be set.
     * @return the user password instance.
     */
    private LoginPage setPassword(final String password) {
        passwordTxtBox.sendKeys(password);
        return this;
    }

    /**
     * Clicks the login button.
     */
    private void clickLoginBtn() {
        loginBtn.click();
    }

    /**
     * login with successful values.
     *
     * @param userName to be set.
     * @param password to be set.
     * @return the home page.
     */
    public ClassicHomePage loginClassicSuccessful(final String userName, final String password) {
        setUserName(userName);
        setPassword(password);
        clickLoginBtn();
        return new ClassicHomePage();
    }
    /**
     * login with successful values.
     *
     * @param userName to be set.
     * @param password to be set.
     * @return the home page.
     */
    public HomePage loginSuccessful(final String userName, final String password) {
        setUserName(userName);
        setPassword(password);
        clickLoginBtn();
        return new HomePage();
    }
}
