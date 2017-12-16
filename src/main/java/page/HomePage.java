package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private JavascriptExecutor js;

    public static String HOME_URL = "http://automationpractice.com";

    @FindBy(css = "#header_logo > a > img")
    private WebElement logo;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
    private WebElement dresses;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
    private WebElement tshirt;

    @FindBy(id = "search_query_top")
    private WebElement searchField;

    @FindBy(css = "#searchbox > button")
    private WebElement buttonSearch;

    @FindBy(css = "#layered_price_slider > a:nth-child(2)")
    private WebElement minimumRange;

    @FindBy(css = "#center_column > div.product_list > p")
    private WebElement noProductFoundMessage;

    @FindBy(css = "#center_column > div.content_sortPagiBar.clearfix > div.top-pagination-content.clearfix > div.product-count")
    private WebElement productAmount;

    @FindBy(css = "#category > div.fancybox-overlay.fancybox-overlay-fixed > div > div > a")
    private WebElement buttonCloseWishlistInfo;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        this.webDriverWait = new WebDriverWait(webDriver, 5);
        this.js = (JavascriptExecutor) this.webDriver;
    }

    public void open() {
        this.webDriver.get(HOME_URL);
    }

    public void clickDresses() {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(this.dresses));
        this.dresses.click();
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class,'product_list')]//li[1]//h5/a")));
    }

    public void clickTShirt() {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(this.tshirt));
        this.tshirt.click();
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class,'product_list')]//li[1]//h5/a")));
    }

    public void inputOnSearchField(String keywords) {
        this.searchField.sendKeys(keywords);
    }

    public void clickButtonSearch() {
        this.buttonSearch.click();
    }

    public void searchProduct(String keywords) {
        inputOnSearchField(keywords);
        clickButtonSearch();
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//ul[contains(@class,'product_list')]//li[1]//h5"))));
    }

    public String getSpecificProductName(int index) {
        String productName = webDriver.findElement(By.xpath(String.format("//ul[contains(@class,'product_list')]//li[%d]//h5/a", index))).getAttribute("title");
        return productName;
    }

    public String getMessageOnSearchResult() {
        return this.webDriver.findElement(By.cssSelector("#center_column > p")).getText();
    }

    public void setMinimumRange(String minimumRange) {
        this.webDriver.get(String.format("http://automationpractice.com/index.php?id_category=5&controller=category#/price-%s-17", minimumRange));
    }

    public String getprodutAmount() {
        this.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#center_column > div.content_sortPagiBar.clearfix > div.top-pagination-content.clearfix > div.product-count")));
        WebElement amount = this.webDriver.findElement(By.cssSelector("#center_column > div.content_sortPagiBar.clearfix > div.top-pagination-content.clearfix > div.product-count"));
        String productAmount = amount.getText();
        return productAmount;
    }

    public List<WebElement> getProducts() {
        return this.webDriver.findElements(By.xpath("//ul[contains(@class,'product_list')]//li//h5/a"));
    }

    public boolean checkProductMesageVisibility() {
        try {
            webDriver.findElement(By.cssSelector(String.valueOf(noProductFoundMessage)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickViewOptionInList() {
        this.webDriver.findElement(By.id("list")).click();
    }

    public void addSpecificProductToWishlist(int index) {
        clickViewOptionInList();
        String path = String.format("//ul[contains(@class,'product_list')]//li[%d]/div/div/div[3]//div[contains(@class,'functional-buttons')]/div[1]/a", index);
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        this.webDriver.findElement(By.xpath(path)).click();
    }

    public void clickAddToCart(int index) {
        clickViewOptionInList();
        String path = String.format("//ul[contains(@class,'product_list')]/li[%d]/div//div[contains(@class,'button-container')]/a", index);
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        this.webDriver.findElement(By.xpath(path)).click();
    }
}
