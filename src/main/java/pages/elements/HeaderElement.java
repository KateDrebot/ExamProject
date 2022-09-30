package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.LoginPage;

public class HeaderElement extends CommonActionsWithElements {

    @FindBy(xpath = ".//a[@href='/login']")
    private WebElement linkLogIn;
    @FindBy(xpath = ".//a[@href='/logout']")
    private WebElement linkLogOut;
    @FindBy(xpath = ".//div[@class='header-links']/UL//LI[1]")
    private WebElement linkUserName;

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage clickOnLogInHeader() {
        clickOnElement(linkLogIn);
        return new LoginPage(webDriver);
    }

    public boolean isLinkLogOutDisplayed() {
        return isElementDisplayed(linkLogOut);
    }

    public boolean isLinkLogInDisplayed() {
        return isElementDisplayed(linkLogIn);
    }

    public String checkUserNameInHeader() {
        return linkUserName.getText();
    }

}
