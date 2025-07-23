package Base;

import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.SidebarPage;
import Tests.AddToCartTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

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

        //Disabling "leaked password" popup message
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("profile.password_manager_leak_detection", false);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-save-password-bubble");

        options.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(options);


        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        inventoryPage = new InventoryPage();
        loginPage = new LoginPage();
        sidebarPage = new SidebarPage();
        cartPage = new CartPage();

        //Loading xlsx file
        InputStream fileStream = getClass()
                .getClassLoader()
                .getResourceAsStream("users.xlsx");

        excelReader = new ExcelReader(fileStream);

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
