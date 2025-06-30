package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddToCart() {
       loginPage.login(standardUser,validPassword);
       Assert.assertTrue(inventoryPage.emptyCartIcon.getText().equals(""));
       inventoryPage.clickAddToCart();
       Assert.assertTrue(inventoryPage.cartIcon.getText().equals("1"));
    }

    @Test
    public void testRemoveFromCart() {
        loginPage.login(standardUser,validPassword);
        Assert.assertTrue(inventoryPage.emptyCartIcon.getText().equals(""));
        inventoryPage.clickAddToCart();
        Assert.assertTrue(inventoryPage.cartIcon.getText().equals("1"));
        inventoryPage.clickRemove();
        Assert.assertTrue(inventoryPage.emptyCartIcon.getText().equals(""));
    }
}
