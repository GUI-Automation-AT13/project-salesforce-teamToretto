package salesforce.ui.pages.lightning.campaign;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * This class is of Campaign Page.
 */
public class CampaignPage extends BasePage {

    @FindBy(css = ".forceActionLink > div")
    private WebElement createCampaignBtn;

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(createCampaignBtn));
    }

    /**
     * Returns a Campaing page form to create.
     *
     * @return a object CreateCampaignPage.
     */
    public CreateCampaignPage clickCreateCampaignBtn() {
        createCampaignBtn.click();
        return new CreateCampaignPage();
    }
}
