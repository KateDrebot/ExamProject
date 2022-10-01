package registrationTest;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Assert;
import org.junit.Test;

public class RegisterTest extends BaseTest {
    final static String RADIO_BUTTON_MALE = "M";
    final static String RADIO_BUTTON_FEMALE = "F";
    final static String UNIQUE_VALUE = Util.getDateAndTimeFormatted();
    final static String FIRST_NAME = "FIRST" + UNIQUE_VALUE;
    final static String LAST_NAME = "LAST" + UNIQUE_VALUE;
    final static String EMAIL = UNIQUE_VALUE + "@" + UNIQUE_VALUE + ".com";
    final static String PASSWORD = "123456";

    @Test
    public void registerNewCustomer() {

        homePage.openStartPage()
                .getHeaderElementLogined().clickOnRegisterHeader()
                .checkIsRedirectToRegisterPage().selectMaleFemaleRadioButton(RADIO_BUTTON_FEMALE)
                .enterFirstNameIntoFirstNameInput(FIRST_NAME)
                .enterLastNameIntoLastNameInput(LAST_NAME)
                .enterEmailIntoEmailInput(EMAIL)
                .enterPasswordIntoPasswordInput(PASSWORD)
                .enterConfirmPasswordIntoConfirmPasswordInput(PASSWORD)
                .clickOnRegisterButton()
                .checkIsRedirectToRegisterResultPage()
                .clickOnContinueButton()
                .checkIsRedirectToHomePage()
                .getHeaderElementLogouted().checkUserNameInHeader(EMAIL);
        ;
        Assert.assertTrue("Customer doesn't create", homePage.getHeaderElementLogouted().isLinkLogOutDisplayed());
        //Assert.assertEquals("Name customer", EMAIL, homePage.getHeaderElementLogouted().checkUserNameInHeader());

        homePage.getHeaderElementLogouted().clickOnLogOutButton()
                .checkIsRedirectToHomePage()
                .getHeaderElementLogined().clickOnLogInHeader()
                .checkIsRedirectToLoginPage()
                .enterEmailIntoEmailInput(EMAIL)
                .enterPasswordIntoPasswordInput(PASSWORD)
                .clickOnButtonLogIn()
                .checkIsRedirectToHomePage()
                .getHeaderElementLogouted().clickOnCustomerName()
                .checkIsRedirectToCustomerInfoPage()
                .checkRadioButton(RADIO_BUTTON_FEMALE)
                .checkFirstName(FIRST_NAME)
                .checkLastName(LAST_NAME)
                .checkEmail(EMAIL)
        ;
    }
}
