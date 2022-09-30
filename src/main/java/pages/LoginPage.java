package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@value='Log in']")
    private WebElement buttonLogIn;
    @FindBy(id = "Email")
    private WebElement inputEmail;
    @FindBy(id = "Password")
    private WebElement inputPassword;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrlPage() {
        return "login";
    }

    public LoginPage checkIsRedirectToLoginPage() {

        checkUrl();
        Assert.assertTrue("Login Page wasn't loaded", isElementDisplayed(buttonLogIn));
        return this;
    }

    public LoginPage enterEmailIntoEmailInput(String email) {
        enterTextIntoElement(inputEmail, email);
        return this;
    }

    public LoginPage enterPasswordIntoPasswordInput(String password) {
        enterTextIntoElement(inputPassword, password);
        return this;
    }

    public HomePage clickOnButtonLogIn(){
        clickOnElement(buttonLogIn);
        return new HomePage(webDriver);
    }

}
