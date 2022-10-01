package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.LoginPage;
import pages.RegisterPage;

public class HeaderElementLogined extends HeaderElement {

    @FindBy(xpath = ".//a[@href='/login']")
    private WebElement linkLogIn;

    @FindBy(className = "ico-register")
    private WebElement linkRegister;

    public HeaderElementLogined(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage clickOnLogInHeader() {
        clickOnElement(linkLogIn);
        return new LoginPage(webDriver);
    }

    public RegisterPage clickOnRegisterHeader() {
        clickOnElement(linkRegister);
        return new RegisterPage(webDriver);
    }

    public boolean isLinkLogInDisplayed() {
        return isElementDisplayed(linkLogIn);
    }


}
