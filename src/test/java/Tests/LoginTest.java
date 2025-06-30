package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testStandardUserCanLogin() {
        loginPage.login(standardUser, validPassword);

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
    }

    @Test
    public void testLockedOutUserCannotLogin() {
        loginPage.login(lockedOutUser, validPassword);

        Assert.assertEquals(loginPage.lockedUserError.getText(),
                "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void testProblemUserCanLogin() {
        loginPage.login(problemUser, validPassword);

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
    }

    @Test
    public void testPerformanceGlitchUserCanLogin() {
        loginPage.login(performanceGlitchUser, validPassword);

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
    }

    @Test
    public void TestErrorUserCanLogin() {
        loginPage.login(errorUser, validPassword);

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
    }

    @Test
    public void TestVisualUserCanLogin() {
        loginPage.login(visualUser, validPassword);

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
    }

    @Test
    public void testStandardUserCanLogout() {
        loginPage.login(standardUser, validPassword);

        inventoryPage.clickBurgerMenu();
        sidebarPage.clicklLogout();

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/"));
    }

}
