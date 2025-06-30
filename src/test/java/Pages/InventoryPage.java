package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Base.BaseTest.driver;

public class InventoryPage {
    //id = add-to-cart-sauce-labs-backpack

    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartButton;

    @FindBy(className = "shopping_cart_badge")
    public WebElement cartIcon;

    @FindBy(className = "shopping_cart_link")
    public WebElement emptyCartIcon;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeItem;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenu;

    //-----------------------Methods

    public void clickAddToCart(){
        addToCartButton.click();
    }

    public void clickRemove(){
        removeItem.click();
    }

    public void clickBurgerMenu(){
        burgerMenu.click();
    }

    public void clickOnACart(){
        cartIcon.click();
    }

}
