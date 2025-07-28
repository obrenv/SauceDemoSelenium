package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Base.BaseTest.driver;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    public WebElement checkoutButton;


    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement zipCode;


    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(className = "complete-header")
    public WebElement checkoutComplete;


    @FindBy(css = "h3[data-test=error]")
    public WebElement userErrorCart;

    @FindBy(css = "[data-test=cancel]")
    public WebElement cancelButton;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> itemTitles;

    @FindBy(className = "inventory_item_desc")
    public List<WebElement> itemDescriptions;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> itemPrices;

    //-----------------------Methods

    public void clickCheckout() {
        checkoutButton.click();
    }

    public void fillOutForm(String name, String lastname, String zip) {
        firstName.sendKeys(name);
        this.lastName.sendKeys(lastname);
        zipCode.sendKeys(zip);
    }

    public void clickCancel() {
        cancelButton.click();
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickFinish() {
        finishButton.click();
    }

}
