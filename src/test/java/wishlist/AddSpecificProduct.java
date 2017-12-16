package wishlist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.HomePage;
import page.UserAuth;
import page.WishListPage;

import java.util.List;

public class AddSpecificProduct {
    private static final String PROJECT_PATH = System.getProperty("user.dir");

    private WebDriver webDriver;
    private HomePage homePage;
    private UserAuth userAuth;
    private WishListPage wishListPage;

    @BeforeClass
    public void suiteSetup() {
        System.setProperty("webdriver.chrome.driver", PROJECT_PATH + "/resource/driver/chromedriver");
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        userAuth = new UserAuth(webDriver);
        wishListPage = new WishListPage(webDriver);

        homePage.open();
        userAuth.open();
        userAuth.signIn("automationpractice-test01@email.com", "123456");
        homePage.open();
    }

    @AfterClass
    public void suiteTeardown() {
        webDriver.quit();
    }

    @Test
    public void addCategoryTShirt() {
        homePage.clickTShirt();
        homePage.addSpecificProductToWishlist(1);
        wishListPage.open();
        wishListPage.clickProductInWishlist(1);
        List<WebElement> productsWishlist = wishListPage.getProductsWishlist();
        Assert.assertNotEquals(0, productsWishlist.size());
    }

}
