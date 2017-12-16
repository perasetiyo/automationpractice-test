package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WishListPage {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private JavascriptExecutor javascriptExecutor;

    public static String WISHLIST_URL = "http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist";

    public WishListPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        this.webDriverWait = new WebDriverWait(webDriver, 10);
        this.javascriptExecutor = (JavascriptExecutor) this.webDriver;
    }

    public void open() {
        this.webDriver.get(WISHLIST_URL);
    }

    public void clickProductInWishlist(int index) {
        String path =  String.format("//div[@id='block-history']//tbody/tr[%d]/td[1]/a", index);
        this.webDriver.findElement(By.xpath(path)).click();
    }

    public List<WebElement> getProductsWishlist() {
        return this.webDriver.findElements(By.xpath("//div[@id='block-history']//tbody/tr"));
    }
}
