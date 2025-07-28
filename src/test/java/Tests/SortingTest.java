package Tests;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingTest extends BaseTest {
    @BeforeMethod
    public void loginUser() {
        loginPage.login(standardUser, validPassword);
        inventoryPage.clickBurgerMenu();
        sidebarPage.clickResetApp();
        driver.navigate().refresh();

        select = new Select(inventoryPage.sortingOptions);
    }

    @Test
    public void sortAToZSortsItemsProperly() {
        select.selectByValue("az");

        List<String> original = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            original.add(inventoryPage.itemTitles.get(i).getText().trim());
        }

        List<String> sorted = new ArrayList<>(original);
        Collections.sort(sorted);

        Assert.assertEquals(original, sorted);

    }

    @Test
    public void sortZToASortsItemsProperly() {
        select.selectByValue("za");

        List<String> original = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            original.add(inventoryPage.itemTitles.get(i).getText().trim());
        }

        List<String> sorted = new ArrayList<>(original);
        sorted.sort(Collections.reverseOrder());

        Assert.assertEquals(original, sorted);
    }

    @Test
    public void sortHighToLowSortsItemsProperly() {
        select.selectByValue("hilo");

        List<Double> originalPrices = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            originalPrices.add(Double.parseDouble(inventoryPage.itemPrices.get(i)
                    .getText().replace("$", "").trim()));

        }

        List<Double> sortedPrices = new ArrayList<>(originalPrices);
        Collections.sort(sortedPrices, Collections.reverseOrder());

        Assert.assertEquals(originalPrices, sortedPrices);
    }

    @Test
    public void sortLowToHighSortsItemsProperly() {
        select.selectByValue("lohi");

        List<Double> originalPrices = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            originalPrices.add(Double.parseDouble(inventoryPage.itemPrices.get(i)
                    .getText().replace("$", "").trim()));

        }

        List<Double> sortedPrices = new ArrayList<>(originalPrices);
        Collections.sort(sortedPrices);

        Assert.assertEquals(originalPrices, sortedPrices);
    }

}
