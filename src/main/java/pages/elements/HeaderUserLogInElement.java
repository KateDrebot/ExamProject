package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderUserLogInElement extends HeaderElement{

    @FindBy(xpath = ".//a[@href='/logout']")
    private WebElement linkLogOut;

    @FindBy(xpath = ".//div[@class='header-links']/UL//LI[1]")
    private WebElement linkUserName;

    public HeaderUserLogInElement(WebDriver webDriver) {
        super(webDriver);
    }
    public String checkUserNameInHeader() {
        return linkUserName.getText();
    }

}
