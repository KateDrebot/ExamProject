package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterResultPage extends ParentPage {
    @FindBy(xpath = ".//input[@value='Continue']")
    private WebElement buttonContinue;

    public RegisterResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrlPage() {
        return "/registerresult";
    }

    public RegisterResultPage checkIsRedirectToRegisterResultPage() {
        checkUrlWithPattern();
        //TODO isDisplayed
        return this;
    }

    public HomePage clickOnContinueButton() {
        clickOnElement(buttonContinue);
        return new HomePage(webDriver);
    }
}
