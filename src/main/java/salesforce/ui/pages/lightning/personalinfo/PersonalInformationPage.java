package salesforce.ui.pages.lightning.personalinfo;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import salesforce.ui.pages.BasePage;

/**
 * This class has webElement for personal information pages.
 */
public class PersonalInformationPage extends BasePage {

    private By aliasTxtBox = By.id("PersonalInformationSetup:editPage:pageBlock:alias");

    /**
     * Initializes web element actions.
     *
     * @param webDriverManager to be managed for the webElementActions
     */
    public PersonalInformationPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }

    /**
     * Gets text of alias.
     *
     * @return a String with alias.
     */
    public String getAliasTxt() {
        return webElementAction.getTextOfByFieldByLocator(aliasTxtBox);
    }

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForVisibilityOfLocator(aliasTxtBox);
    }
}
