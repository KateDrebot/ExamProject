package loginTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin(){
        homePage.openStartPage()
                .getHeaderElement().clickOnLogInHeader()
                .checkIsRedirectToLoginPage()
                .enterEmailIntoEmailInput(TestData.VALID_EMAIL)
                .enterPasswordIntoPasswordInput(TestData.VALID_PASSWORD)
                .clickOnButtonLogIn();

        Assert.assertTrue("Link 'LogOut' isn't displayed",homePage.getHeaderElement().isLinkLogOutDisplayed());
        Assert.assertEquals(TestData.VALID_EMAIL,homePage.getHeaderElement().checkUserNameInHeader());

    }
}
