package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
            String name = getElementName(webElement);
            webElement.click();
            logger.info("Button '" + name + "' was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(String xpathLocator) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(xpathLocator));
            clickOnElement(webElement);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }

    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            webDriverWait10.until(ExpectedConditions.textToBePresentInElement(webElement, webElement.getText()));
            if (webElement.isDisplayed()) {
                logger.info("element '" + getElementName(webElement) + "' is displayed");
                return true;
            }
            logger.info("element '" + getElementName(webElement) + "' isn't displayed");
            return false;

        } catch (Exception e) {
            logger.info("element '" + getElementName(webElement) + "' can't displayed: " + e);//("Element isn't displayed");
            return false;
        }
    }

    protected boolean isElementDisplayed(String xpathLocator) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(xpathLocator));
            return isElementDisplayed(webElement);

        } catch (Exception e) {
            logger.info("Element isn't displayed");
            return false;
        }

    }

    protected void enterTextIntoElement(WebElement webElement, String text) {
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));//.elementToBeClickable(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info("text '" + text + "' was inputted to element '" + getElementName(webElement) + "'");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void selectRadioButton(String xpath, String value) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(String.format(xpath, value)));
            String name = getElementName(webElement);
            webElement.click();
            logger.info("'" + name + "' was selected");

        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private String getElementName(WebElement webElement) {
        try {
            return webElement.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can't work with element " + e);
        Assert.fail("Can't work with element " + e);
    }
}
