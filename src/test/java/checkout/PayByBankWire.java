package checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.CartPage;
import page.HomePage;
import page.UserAuth;

public class PayByBankWire {
    private static final String PROJECT_PATH = System.getProperty("user.dir");

    private WebDriver webDriver;
    private HomePage homePage;
    private UserAuth userAuth;
    private CartPage cartPage;

    @BeforeClass
    public void suiteSetup() {
        System.setProperty("webdriver.chrome.driver", PROJECT_PATH + "/resource/driver/chromedriver");
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        userAuth = new UserAuth(webDriver);
        cartPage = new CartPage(webDriver);

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
        homePage.clickAddToCart(1);
        cartPage.open();
        String name = cartPage.getProductName(1);
        String totalPayment = cartPage.getTotalPayment();
        cartPage.clickButtonProccedCheckout();
        cartPage.clickButtonConfirmAddress();
        cartPage.clickButtonConfirmShipping();
        cartPage.clickPayByBankWire();
        String totalPaymentInPaymentStatus = cartPage.getTotalPaymentInPaymentStatus();
        Assert.assertEquals(totalPayment, totalPaymentInPaymentStatus);
    }
}
