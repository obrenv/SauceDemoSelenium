package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class CheckoutTest extends BaseTest {

    @Test
    public void testStandardUserCheckout() {
        loginPage.login(standardUser,validPassword);

        inventoryPage.clickAddToCart();
        inventoryPage.clickOnACart();
        cartPage.clickCheckout();

        cartPage.filloutForm("Obren", "Obrenovic", "18000");
        cartPage.clickContinue();
        cartPage.clickFinish();

        Assert.assertTrue(cartPage.checkoutComplete.getText().equals("Thank you for your order!"));
    }

}
