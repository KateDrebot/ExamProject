package loginTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        homePage.openStartPage()
                .getHeaderElementLogined().clickOnLogInHeader()
                //.getHeaderElement().clickOnLogInHeader()
                .checkIsRedirectToLoginPage()
                .enterEmailIntoEmailInput(TestData.VALID_EMAIL)
                .enterPasswordIntoPasswordInput(TestData.VALID_PASSWORD)
                .clickOnButtonLogIn()
                .checkIsRedirectToHomePage()
                .getHeaderElementLogouted().checkUserNameInHeader(TestData.VALID_EMAIL);

        Assert.assertTrue("Link 'LogOut' isn't displayed", homePage.getHeaderElementLogouted().isLinkLogOutDisplayed());
        // homePage.getHeaderElement().isLinkLogOutDisplayed());
        //Assert.assertEquals(TestData.VALID_EMAIL, homePage.getHeaderElementLogouted().checkUserNameInHeader());
        //homePage.getHeaderElement().checkUserNameInHeader());

    }

    @Test
    public void invalidLogin() {
        String errors = "No customer account found";//.//li[text()='No customer account found']
        String er = "The credentials provided are incorrect";//.//li[text()='The credentials provided are incorrect']
        String s = "Please enter a valid email address.";//.//span[text()='Please enter a valid email address.']
        homePage.openStartPage()
                .getHeaderElementLogined().clickOnLogInHeader()
                //.getHeaderElement().clickOnLogInHeader()
                .enterEmailIntoEmailInput("1")
                .enterPasswordIntoPasswordInput("1")
                .clickOnButtonLogIn();

        Assert.assertTrue("Link 'LogOut' is displayed", homePage.getHeaderElementLogined().isLinkLogInDisplayed());
        // homePage.getHeaderElement().isLinkLogInDisplayed());

        loginPage.isTextInAlertDisplayed(s);


    }
}
