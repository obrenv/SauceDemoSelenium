package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Base.BaseTest.driver;

public class InventoryPage {

    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartButton;



    @FindBy(className = "shopping_cart_badge")
    public WebElement cartIcon;

    @FindBy(className = "shopping_cart_link")
    public WebElement emptyCartIcon;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenu;

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public List<WebElement> addToCartButtons;

    @FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory")
    public List<WebElement> removeFromCartButtons;

    @FindBy(id = "inventory_container")
    public WebElement inventoryContainer;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> itemTitles;

    @FindBy(className = "inventory_item_desc")
    public List<WebElement> itemDescriptions;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> itemPrices;

    @FindBy(css = ".inventory_item_img .inventory_item_img")

    public List<WebElement> itemImages;

    @FindBy(className = "product_sort_container")
    public WebElement sortingOptions;

    //-----------------------Methods

    public void clickAddToCart(int number){
        addToCartButtons.get(number).click();
    }

    public void clickRemove(int number){
        removeFromCartButtons.get(0).click();
    }

    public void clickBurgerMenu(){
        burgerMenu.click();
    }

    public void clickOnACart(){
        cartIcon.click();
    }

    public void addAllItems(){
        for (WebElement item : addToCartButtons){
            item.click();
        }
    }

}
