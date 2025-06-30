package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    //-----------------------Methods

    public void clickCheckout() {
        checkoutButton.click();
    }

    public void filloutForm(String name, String lastname, String zip) {
        firstName.sendKeys(name);
        this.lastName.sendKeys(lastname);
        zipCode.sendKeys(zip);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickFinish() {
        finishButton.click();
    }

}
