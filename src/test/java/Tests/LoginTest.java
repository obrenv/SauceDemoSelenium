package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

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

    //Negative cases


    @Test
    public void standardUserCannottLoginWithWrongPassword() {
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

    //Logout functionality

    @Test
    public void userCanLogout() {

        loginPage.login(standardUser, validPassword);
        inventoryPage.clickBurgerMenu();
        sidebarPage.clicklLogout();


        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/";

        Assert.assertEquals(expectedURL, currentURL);
    }

    //Special cases

    @Test
    public void performanceGlitchUserLoginDuration() {
        long start = System.currentTimeMillis();

        loginPage.login(performanceGlitchUser, validPassword);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.inventoryContainer));

        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("Login took " + duration + " milliseconds");
    }

    @Test
    public void performanceGlitchUserVsStandardUserLoginDuration() {


        long performanceGlitchStart = System.currentTimeMillis();
        loginPage.login(performanceGlitchUser, validPassword);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.inventoryContainer));

        long performanceGlitchEnd = System.currentTimeMillis();
        long performanceGlitchDuration = performanceGlitchEnd - performanceGlitchStart;


        inventoryPage.clickBurgerMenu();
        sidebarPage.clicklLogout();

        long standardStart = System.currentTimeMillis();
        loginPage.login(standardUser, validPassword);

        long standardEnd = System.currentTimeMillis();
        long standardDuration = standardEnd - standardStart;


        System.out.println("Login of standard user took " + standardDuration + " milliseconds");
        System.out.println("Login of performance glitch user took " + performanceGlitchDuration + " milliseconds");
    }


}
