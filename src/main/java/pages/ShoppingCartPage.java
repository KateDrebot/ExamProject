package pages;


import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends ParentPage {
    public ShoppingCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrlPage() {
        return "/cart";
    }
}
