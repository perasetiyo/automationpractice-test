package search_product;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class SearchBySpecificCategory extends BaseTest {
    @Test
    public void byValidProductName() {
        homePage.searchProduct("Dress");
        String productName = homePage.getSpecificProductName(1);
        boolean isContainKeyword = productName.contains("Dress");
        Assert.assertEquals(true, isContainKeyword);
    }

    @Test
    public void searchCategory() {
        homePage.clickDresses();
        List<WebElement> products = homePage.getProducts();
        for (WebElement p : products) {
            boolean isContainKeyword = p.getAttribute("title").contains("Dress");
            Assert.assertTrue(isContainKeyword);
        }
    }
}
