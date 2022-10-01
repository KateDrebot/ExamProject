package loginTest;

import baseTest.BaseTest;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import libs.TestData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class LoginParametriseTest extends BaseTest {
    final static String ERROR_CUSTOMER = "No customer account found";//.//li[text()='No customer account found']
    final static String ERROR_PASSWORD = "The credentials provided are incorrect";//.//li[text()='The credentials provided are incorrect']
    final static String ERROR_EMAIL = "Please enter a valid email address.";//.//span[text()='Please enter a valid email address.']

    @Test
    @Parameters({
            "1," + "1," + ERROR_EMAIL
            , TestData.VALID_EMAIL + ",qqq," + ERROR_PASSWORD
            , "1@q.q," + "123," + ERROR_CUSTOMER
    })
    @TestCaseName("registrationErrors : login ={0}, email = {1}, password = {2}")

    public void invalidLogin(String email, String password, String expectedError) {

        homePage.openStartPage()
                .getHeaderElementLogined().clickOnLogInHeader()
                //.getHeaderElement().clickOnLogInHeader()
                .enterEmailIntoEmailInput(email)
                .enterPasswordIntoPasswordInput(password)
                .clickOnButtonLogIn();
        loginPage.isTextInAlertDisplayed(expectedError);
        Assert.assertTrue("Link 'LogOut' is displayed", homePage.getHeaderElementLogined().isLinkLogInDisplayed());
        //homePage.getHeaderElement().isLinkLogInDisplayed());


    }
}
