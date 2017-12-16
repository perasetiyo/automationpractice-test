package search_product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import page.HomePage;

public class BaseTest {
    private static final String PROJECT_PATH = System.getProperty("user.dir");

    protected WebDriver webDriver;
    protected HomePage homePage;

    @BeforeClass
    public void suiteSetup() {
        System.setProperty("webdriver.chrome.driver", PROJECT_PATH + "/resource/driver/chromedriver");
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        homePage.open();
    }

    @AfterMethod
    public void testTeardown() {
        webDriver.navigate().refresh();
    }

    @AfterClass
    public void suiteTeardown() {
        webDriver.quit();
    }
}
