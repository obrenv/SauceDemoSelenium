package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @BeforeClass
    public void randomNumber() {
        itemNumber = (int) (Math.random() * 6);
    }

    @BeforeMethod
    public void loginUser() {
        loginPage.login(standardUser, validPassword);
        inventoryPage.clickBurgerMenu();
        sidebarPage.clickResetApp();
        driver.navigate().refresh();
    }


    @Test
    public void addToCart() {
        Assert.assertTrue(inventoryPage.emptyCartIcon.getText().equals(""));

        inventoryPage.clickAddToCart(itemNumber);
        Assert.assertTrue(inventoryPage.cartIcon.getText().equals("1"));
    }

    @Test
    public void removeFromCart() {
        Assert.assertTrue(inventoryPage.emptyCartIcon.getText().equals(""));
        inventoryPage.clickAddToCart(itemNumber);
        Assert.assertTrue(inventoryPage.cartIcon.getText().equals("1"));
        inventoryPage.clickRemove(itemNumber);
        Assert.assertTrue(inventoryPage.emptyCartIcon.getText().equals(""));
    }

    @Test
    public void addAllItemsToCart() {

        inventoryPage.addAllItems();
        Assert.assertEquals(inventoryPage.cartIcon.getText(), "6");
    }

    @Test
    public void addedItemMatchesItemInTheCart() {
        String itemName = inventoryPage.itemTitles.get(itemNumber).getText();
        String itemDescription = inventoryPage.itemDescriptions.get(itemNumber).getText();
        String itemPrice = inventoryPage.itemPrices.get(itemNumber).getText();

        inventoryPage.clickAddToCart(itemNumber);
        inventoryPage.clickOnACart();

        Assert.assertEquals(itemName, cartPage.itemTitles.get(0).getText());
        Assert.assertEquals(itemDescription, cartPage.itemDescriptions.get(0).getText());
        Assert.assertEquals(itemPrice, cartPage.itemPrices.get(0).getText());
    }


    // Add items via individual item page

    @Test
    public void addAllItemsViaItemPage() {
        for (int i = 0; i < 6; i++) {
            inventoryPage.itemTitles.get(i).click();
            itemPage.clickAddToCart();
            driver.navigate().back();
        }

        Assert.assertEquals(inventoryPage.cartIcon.getText(), "6");

    }

    @Test
    public void addAndRemoveAllItemsViaItemPage() {
        for (int i = 0; i < 6; i++) {
            inventoryPage.itemTitles.get(i).click();
            itemPage.clickAddToCart();
            driver.navigate().back();
        }

        Assert.assertEquals(inventoryPage.cartIcon.getText(), "6");

    }

    @Test
    public void addAndRemoveEachItemViaItemPage() {
        for (int i = 0; i < 6; i++) {
            inventoryPage.itemTitles.get(i).click();
            itemPage.clickAddToCart();
            itemPage.clickRemoveFromCart();
            driver.navigate().back();
        }

        Assert.assertTrue(inventoryPage.emptyCartIcon.getText().equals(""));

    }


}
