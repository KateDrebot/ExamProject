package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerInfoPage extends ParentPage {

    private String radioButtonXPath = ".//input[@type='radio' and @value='%s']";
    @FindBy(id = "FirstName")
    private WebElement inputFirstName;
    @FindBy(id = "LastName")
    private WebElement inputLastName;
    @FindBy(id = "Email")
    private WebElement inputEmail;

    public CustomerInfoPage checkIsRedirectToCustomerInfoPage() {
        checkUrl();
        return this;
    }

    public CustomerInfoPage checkRadioButton(String radioButton) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(String.format(radioButtonXPath, radioButton)));
            Assert.assertEquals("Value element", radioButton, webElement.getAttribute("value"));
        } catch (Exception e) {
            Assert.fail("Can't work with element " + e);
        }

        return this;
    }

    public CustomerInfoPage checkFirstName(String firstName) {
        Assert.assertEquals("Value element", firstName, inputFirstName.getAttribute("value"));
        return this;
    }

    public CustomerInfoPage checkLastName(String lastName) {
        Assert.assertEquals("Value element", lastName, inputLastName.getAttribute("value"));
        return this;
    }

    public CustomerInfoPage checkEmail(String email) {
        Assert.assertEquals("Value element", email, inputEmail.getAttribute("value"));
        return this;
    }

    public CustomerInfoPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrlPage() {
        return "/customer/info";
    }
}
