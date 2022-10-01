package pages.elements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CustomerInfoPage;
import pages.HomePage;

public class HeaderElementLogouted extends HeaderElement {
    @FindBy(xpath = ".//a[@href='/logout']")
    private WebElement linkLogOut;
    @FindBy(xpath = ".//div[@class='header-links']/UL//LI[1]")
    private WebElement linkUserName;

    public HeaderElementLogouted(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isLinkLogOutDisplayed() {
        return isElementDisplayed(linkLogOut);
    }

    public void checkUserNameInHeader(String userName) {
        Assert.assertEquals("User name", userName, linkUserName.getText());

    }

    public HomePage clickOnLogOutButton() {
        clickOnElement(linkLogOut);
        return new HomePage(webDriver);
    }

    public CustomerInfoPage clickOnCustomerName() {
        clickOnElement(linkUserName);
        return new CustomerInfoPage(webDriver);
    }

}
