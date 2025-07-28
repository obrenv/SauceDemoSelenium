package Tests;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ProblemUserTest extends BaseTest {
    @BeforeClass
    public void randomNumber() {
        itemNumber = (int) (Math.random() * 6);
    }

    @BeforeMethod
    public void loginUser() {
        loginPage.login(problemUser, validPassword);
        inventoryPage.clickBurgerMenu();
        sidebarPage.clickResetApp();
        driver.navigate().refresh();
    }

    //Bug confirmation tests

    @Test
    public void problemUserImagesAreAllIdentical() {
        List<String> imageSrcs = new ArrayList<>();


        for (int i = 0; i < 6; i++) {
            String src = inventoryPage.itemImages.get(i).getAttribute("src");
            imageSrcs.add(src);
        }

        String referenceSrc = imageSrcs.get(0);

        boolean allImagesSame = imageSrcs.stream().allMatch(src -> src.equals(referenceSrc));

        Assert.assertTrue(allImagesSame, "Not all images are identical, test failed to confirm bug.");
    }

    @Test
    public void problemUserCannotClickThreeAddToCartButtons() {
        int nonClickableButtons = 0;

        for (int i = 0; i < inventoryPage.addToCartButtons.size(); i++) {
            try {
                inventoryPage.clickAddToCart(i);

                if (!inventoryPage.removeFromCartButtons.get(i).isDisplayed()) {
                    nonClickableButtons++;
                }
            } catch (Exception e) {

                nonClickableButtons++;
            }
        }

        Assert.assertEquals(nonClickableButtons, 3, "Expected 3 non-clickable Add to Cart buttons for problem user.");
    }

    @Test
    public void problemUserCannotClickRemoveButtonsAfterAddingItems() {
        for (int i = 0; i < inventoryPage.addToCartButtons.size(); i++) {
            inventoryPage.addToCartButtons.get(i).click();
        }

        for (int i = 0; i < inventoryPage.removeFromCartButtons.size(); i++) {
            inventoryPage.removeFromCartButtons.get(i).click();
        }

        Assert.assertTrue(inventoryPage.removeFromCartButtons.size() > 0);
        Assert.assertTrue(inventoryPage.cartIcon.isDisplayed());

    }


}


