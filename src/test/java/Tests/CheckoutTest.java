package Tests;

import Base.BaseTest;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    Faker faker = new Faker();
    String name = faker.name().firstName();
    String lastname = faker.name().lastName();
    String zip = faker.numerify("#####");

    @BeforeMethod
    public void loginUser(){
        driver.manage().deleteAllCookies();
        loginPage.login(standardUser,validPassword);


    }

    @Test
    public void standardUserCheckout() {
        inventoryPage.clickAddToCart(itemNumber);
        inventoryPage.clickOnACart();
        cartPage.clickCheckout();

        cartPage.fillOutForm(name, lastname, zip);
        cartPage.clickContinue();
        cartPage.clickFinish();

        Assert.assertTrue(cartPage.checkoutComplete.getText().equals("Thank you for your order!"));
    }

    @Test
    public void formFillingProperly(){
        inventoryPage.clickAddToCart(itemNumber);
        inventoryPage.clickOnACart();
        cartPage.clickCheckout();

        cartPage.fillOutForm(name, lastname, zip);


        Assert.assertEquals(cartPage.firstName.getAttribute("value"), name);
        Assert.assertEquals(cartPage.lastName.getAttribute("value"), lastname);
        Assert.assertEquals(cartPage.zipCode.getAttribute("value"), zip);

    }

    @Test
    public void cantSendFormWithEmptyFields(){
        inventoryPage.clickAddToCart(itemNumber);
        inventoryPage.clickOnACart();
        cartPage.clickCheckout();

        cartPage.fillOutForm("", "", "");
        cartPage.clickContinue();

        Assert.assertEquals(cartPage.userErrorCart.getText(), "Error: First Name is required");
    }

    @Test
    public void cannotCheckoutWithoutFirstName() {
        inventoryPage.clickAddToCart(itemNumber);
        inventoryPage.clickOnACart();
        cartPage.clickCheckout();

        cartPage.fillOutForm("", lastname, zip);
        cartPage.clickContinue();

        Assert.assertEquals(cartPage.userErrorCart.getText(), "Error: First Name is required");
    }

    @Test
    public void cannotCheckoutWithoutLastName() {
        inventoryPage.clickAddToCart(itemNumber);
        inventoryPage.clickOnACart();
        cartPage.clickCheckout();

        cartPage.fillOutForm(name, "", zip);
        cartPage.clickContinue();

        Assert.assertEquals(cartPage.userErrorCart.getText(), "Error: Last Name is required");
    }

    @Test
    public void cannotCheckoutWithoutZipCode() {
        inventoryPage.clickAddToCart(itemNumber);
        inventoryPage.clickOnACart();
        cartPage.clickCheckout();

        cartPage.fillOutForm(name, lastname, "");
        cartPage.clickContinue();

        Assert.assertEquals(cartPage.userErrorCart.getText(), "Error: Postal Code is required");
    }

    @Test
    public void cancelCheckoutReturnsToCart() {
        inventoryPage.clickAddToCart(itemNumber);
        inventoryPage.clickOnACart();
        cartPage.clickCheckout();

        cartPage.clickCancel();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));
    }

}




