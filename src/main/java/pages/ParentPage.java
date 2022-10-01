package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.elements.HeaderElementLogined;
import pages.elements.HeaderElementLogouted;

import static org.hamcrest.CoreMatchers.containsString;

abstract public class ParentPage extends CommonActionsWithElements {

    protected String baseUrl;
    private HeaderElementLogined headerElementLogined = new HeaderElementLogined(webDriver);
    private HeaderElementLogouted headerElementLogouted = new HeaderElementLogouted(webDriver);


    public ParentPage(WebDriver webDriver) {
        super(webDriver);

        baseUrl = "https://demowebshop.tricentis.com";
    }

    abstract String getRelativeUrlPage();

    public void checkUrl() {
        Assert.assertEquals("Invalid page", baseUrl + getRelativeUrlPage(), webDriver.getCurrentUrl());

    }

    public void checkUrlWithPattern() {
        Assert.assertThat("Invalid page", webDriver.getCurrentUrl(), containsString(baseUrl + getRelativeUrlPage()));
        logger.info(webDriver.getCurrentUrl());
    }

    public HeaderElementLogined getHeaderElementLogined() {
        return headerElementLogined;
    }

    public HeaderElementLogouted getHeaderElementLogouted() {
        return headerElementLogouted;
    }
}

