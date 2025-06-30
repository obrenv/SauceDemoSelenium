package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Base.BaseTest.driver;

public class SidebarPage {

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    //--------------------------------------------------

    public void clicklLogout() {
        logoutButton.click();
    }

}
