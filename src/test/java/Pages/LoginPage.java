package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BaseTest {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(css = "h3[data-test=error]")
    public WebElement lockedUserError;

    @FindBy(className = "inventory_item_img")
    public List<WebElement> bugSlike;

    //-----------------------------------------

    public void clickLogin() {
        loginButton.click();
    }

    public void login(String user, String pass) {
        username.clear();
        username.sendKeys(user);
        password.clear();
        password.sendKeys(pass);
        loginButton.click();
    }

}
