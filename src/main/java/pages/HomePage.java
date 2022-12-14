package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.elements.HeaderElement;

public class HomePage extends ParentPage {


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrlPage() {
        return "/";
    }

    private HeaderElement headerElement = new HeaderElement(webDriver);
    // private HeaderUserLogInElement headerUserLogInElement=new HeaderUserLogInElement(webDriver);
    //private HeaderElement headerElement=new HeaderElement(webDriver);

    public HeaderElement getHeaderElement() {
//        if(headerElement.isLinkLogOutDisplayed()){
//            return headerUserLogInElement;
//        }else {
//            return headerElement;
//        }
        return headerElement;
    }

    public HomePage openStartPage() {
        try {
            webDriver.get(baseUrl);
            logger.info("Start page was opened");
        } catch (Exception e) {
            logger.info("can't open website");
            Assert.fail("can't open website");
        }
        return this;
    }


    public HomePage checkIsRedirectToHomePage() {
        checkUrl();
        return this;
    }
}
