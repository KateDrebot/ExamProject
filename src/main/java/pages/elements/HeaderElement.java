package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.ShoppingCartPage;

public class HeaderElement extends CommonActionsWithElements {
    @FindBy(linkText = "/cart")//.//a[@class='ico-cart']
    private WebElement linkShoppingCart;

    public ShoppingCartPage clickOnShoppingCart() {
        clickOnElement(linkShoppingCart);
        return new ShoppingCartPage(webDriver);
    }

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

}
