package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Base.BaseTest.driver;

public class ItemPage {
    public ItemPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart")
    public WebElement addToCartButton;

    @FindBy(id = "remove")
    public WebElement removeFromCart;



//-----------------------------------------methods

    public void clickAddToCart(){
        addToCartButton.click();
    }

    public void clickRemoveFromCart(){
        removeFromCart.click();
    }
}
