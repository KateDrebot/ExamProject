package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends ParentPage {
    @FindBy(id = "FirstName")
    private WebElement inputFirstName;
    @FindBy(id = "LastName")
    private WebElement inputLastName;
    @FindBy(id = "Email")
    private WebElement inputEmail;
    @FindBy(id = "Password")
    private WebElement inputPassword;
    @FindBy(id = "ConfirmPassword")
    private WebElement inputConfirmPassword;
    @FindBy(id = "register-button")
    private WebElement buttonRegister;
    private String radioButtonXPath = ".//input[@type='radio' and @value='%s']";

    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrlPage() {
        return "/register";
    }

    public RegisterPage checkIsRedirectToRegisterPage() {
        checkUrl();
        Assert.assertTrue("RegisterPage isn't loaded", isElementDisplayed(buttonRegister));
        return this;
    }

    public RegisterPage selectMaleFemaleRadioButton(String value) {

        selectRadioButton(radioButtonXPath, value);
        return this;
    }

    public RegisterPage enterFirstNameIntoFirstNameInput(String firstName) {
        enterTextIntoElement(inputFirstName, firstName);
        return this;
    }

    public RegisterPage enterLastNameIntoLastNameInput(String lastName) {
        enterTextIntoElement(inputLastName, lastName);
        return this;
    }

    public RegisterPage enterEmailIntoEmailInput(String email) {
        enterTextIntoElement(inputEmail, email);
        return this;
    }

    public RegisterPage enterPasswordIntoPasswordInput(String password) {
        enterTextIntoElement(inputPassword, password);
        return this;
    }

    public RegisterPage enterConfirmPasswordIntoConfirmPasswordInput(String confirmPassword) {
        enterTextIntoElement(inputConfirmPassword, confirmPassword);
        return this;
    }

    public RegisterResultPage clickOnRegisterButton() {
        clickOnElement(buttonRegister);
        return new RegisterResultPage(webDriver);
    }

}
