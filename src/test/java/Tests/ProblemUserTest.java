package Tests;

import Base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

//remove button ne radi
//sortiranje ne radi
//

public class ProblemUserTest extends BaseTest {
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





}
