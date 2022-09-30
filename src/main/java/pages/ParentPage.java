package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends CommonActionsWithElements {

    protected String baseUrl;

    public ParentPage(WebDriver webDriver) {
        super(webDriver);

        baseUrl = "https://demowebshop.tricentis.com";
    }

    abstract String getRelativeUrlPage();

    public void checkUrl() {
        Assert.assertEquals("Invalid page", baseUrl + getRelativeUrlPage(), webDriver.getCurrentUrl());

    }
}
