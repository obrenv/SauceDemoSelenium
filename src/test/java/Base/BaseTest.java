package Base;

import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.SidebarPage;
import Tests.AddToCartTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;

    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public SidebarPage sidebarPage;
    public CartPage cartPage;

    public ExcelReader excelReader;

    protected String standardUser;
    protected String validPassword;

    protected String lockedOutUser;
    protected String problemUser;
    protected String performanceGlitchUser;
    protected String errorUser;
    protected String visualUser;


    @BeforeMethod
    public void pageSetUp() throws IOException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        inventoryPage = new InventoryPage();
        loginPage = new LoginPage();
        sidebarPage = new SidebarPage();
        cartPage = new CartPage();

        excelReader = new ExcelReader
                ("C:\\Users\\sinad\\IdeaProjects\\SaucedemoSelenium\\src\\test\\java\\users.xlsx");

        standardUser = excelReader.getStringData("Sheet1", 1, 0);
        validPassword = excelReader.getStringData("Sheet1", 1, 1);

        lockedOutUser = excelReader.getStringData("Sheet1", 2, 0);
        problemUser = excelReader.getStringData("Sheet1", 3, 0);
        performanceGlitchUser = excelReader.getStringData("Sheet1", 4, 0);
        errorUser = excelReader.getStringData("Sheet1", 5, 0);
        visualUser = excelReader.getStringData("Sheet1", 6, 0);


    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
