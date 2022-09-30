package loginTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        homePage.openStartPage()
                .getHeaderElement().clickOnLogInHeader()
                .checkIsRedirectToLoginPage()
                .enterEmailIntoEmailInput(TestData.VALID_EMAIL)
                .enterPasswordIntoPasswordInput(TestData.VALID_PASSWORD)
                .clickOnButtonLogIn()
                .checkIsRedirectToHomePage();

        Assert.assertTrue("Link 'LogOut' isn't displayed", homePage.getHeaderElement().isLinkLogOutDisplayed());
        Assert.assertEquals(TestData.VALID_EMAIL, homePage.getHeaderElement().checkUserNameInHeader());

    }

    @Test
    public void invalidLogin() {
        String errors = "No customer account found";//.//li[text()='No customer account found']
        String er = "The credentials provided are incorrect";//.//li[text()='The credentials provided are incorrect']
        String s = "Please enter a valid email address.";//.//span[text()='Please enter a valid email address.']
        homePage.openStartPage()
                .getHeaderElement().clickOnLogInHeader()
                .enterEmailIntoEmailInput("1")
                .enterPasswordIntoPasswordInput("1")
                .clickOnButtonLogIn();

        Assert.assertTrue("Link 'LogOut' is displayed", homePage.getHeaderElement().isLinkLogInDisplayed());

        loginPage.isTextInAlertDisplayed(s);


    }
}
