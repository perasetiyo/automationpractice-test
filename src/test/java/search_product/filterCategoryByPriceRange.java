package search_product;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;

import java.util.List;

public class filterCategoryByPriceRange extends BaseTest {
    @Test
    public void notContainPriceRangeTShirt1() {
        webDriver.get(HomePage.HOME_URL + "?id_category=5&controller=category#/price-16.84-17");
        boolean isDisplay = homePage.checkProductMesageVisibility();
        Assert.assertTrue(isDisplay);
    }

    @Test
    public void notContainPriceRangeTShirt2() {
        webDriver.get(HomePage.HOME_URL + "?id_category=5&controller=category#/price-16.84-17");
        String productAmount = homePage.getprodutAmount();
        Assert.assertEquals("Showing 0 item", productAmount);
    }
}
