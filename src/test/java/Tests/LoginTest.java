package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void standardUserCanLogin() {
        loginPage.login(standardUser, validPassword);

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
    }

    @Test
    public void lockedOutUserCannotLogin() {
        loginPage.login(lockedOutUser, validPassword);

        Assert.assertEquals(loginPage.userError.getText(),
                "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void problemUserCanLogin() {
        loginPage.login(problemUser, validPassword);

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
    }

    @Test
    public void performanceGlitchUserCanLogin() {
        loginPage.login(performanceGlitchUser, validPassword);

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
    }

    @Test
    public void errorUserCanLogin() {
        loginPage.login(errorUser, validPassword);

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
    }

    @Test
    public void visualUserCanLogin() {
        loginPage.login(visualUser, validPassword);

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
    }

    @Test
    public void standardUserCanLogout() {
        loginPage.login(standardUser, validPassword);

        inventoryPage.clickBurgerMenu();
        sidebarPage.clicklLogout();

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/"));
    }

    @Test
    public void standardUserCantLoginWithWrongPassword() {
        loginPage.login(standardUser, "stagod");

        Assert.assertEquals(loginPage.userError.getText(),
                "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void userCannotLoginWithEmptyUsernameAndPassword() {
        loginPage.login("", "");
        Assert.assertEquals(loginPage.userError.getText(),
                "Epic sadface: Username is required");
    }

    @Test
    public void userCannotLoginWithEmptyUsername() {
        loginPage.login("", validPassword);
        Assert.assertEquals(loginPage.userError.getText(),
                "Epic sadface: Username is required");
    }

    @Test
    public void userCannotLoginWithEmptyPassword() {
        loginPage.login(standardUser, "");
        Assert.assertEquals(loginPage.userError.getText(),
                "Epic sadface: Password is required");
    }

    @Test
    public void userCannotLoginWithInvalidUsername() {
        loginPage.login("invalid_user", validPassword);
        Assert.assertEquals(loginPage.userError.getText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void userCannotLoginWithInvalidUsernameAndPassword() {
        loginPage.login("invalid_user", "invalid_pass");
        Assert.assertEquals(loginPage.userError.getText(),
                "Epic sadface: Username and password do not match any user in this service");
    }


}
