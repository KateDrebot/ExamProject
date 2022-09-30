package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActionsWithElements {
    protected WebDriver webDriver;

    Logger logger = Logger.getLogger(getClass());

    protected WebDriverWait webDriverWait10;

    public CommonActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            String name = webElement.getAccessibleName();
            webElement.click();
            logger.info("Button '" + name + "' was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            webDriverWait10.until(ExpectedConditions.textToBePresentInElement(webElement, webElement.getText()));
            if (webElement.isDisplayed()) {
                logger.info("element '" + webElement.getAccessibleName() + "' is displayed");
                return true;
            }
            logger.info("element '" + webElement.getAccessibleName() + "' isn't displayed");
            return false;

        } catch (Exception e) {
            logger.info("element '" + webElement.getAccessibleName() + "' can't displayed: " + e);
            return false;
        }
    }

    protected void enterTextIntoElement(WebElement webElement, String text) {
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));//.elementToBeClickable(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info("text '" + text + "' was inputted to element '" + webElement.getAccessibleName() + "'");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can't work with element " + e);
        Assert.fail("Can't work with element " + e);
    }
}
