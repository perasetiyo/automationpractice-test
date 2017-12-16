package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private JavascriptExecutor javascriptExecutor;

    public static String CART_URL = "http://automationpractice.com/index.php?controller=order";

    @FindBy(css = "#center_column > form > p > button > span")
    private WebElement buttonProccedCheckout;

    @FindBy(name = "processAddress")
    private WebElement buttonConfirmAddress;

    @FindBy(name = "processCarrier")
    private WebElement buttonConfirmShipping;

    @FindBy(css = "#form > div > p.checkbox > label")
    private WebElement labelAgreement;

    @FindBy(className = "bankwire")
    private WebElement buttonPayByBankWire;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        this.webDriverWait = new WebDriverWait(webDriver, 10);
        this.javascriptExecutor = (JavascriptExecutor) this.webDriver;
    }

    public void open() {
        this.webDriver.get(CART_URL);
    }

    public String getProductName(int index) {
        String path = String.format("//tr[%d]/td[2]/p/a", index);
        this.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
        String name = this.webDriver.findElement(By.xpath(path)).getText();
        return name;
    }

    public String getTotalPayment() {
        this.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("total_price")));
        String totalPayment = this.webDriver.findElement(By.id("total_price")).getText();
        return totalPayment;
    }

    public void clickButtonProccedCheckout() {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.valueOf(buttonProccedCheckout))));
        buttonProccedCheckout.click();
    }

    public void clickButtonConfirmAddress() {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name(String.valueOf(buttonConfirmAddress))));
        buttonConfirmAddress.click();
    }

    public void clickButtonConfirmShipping() {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.valueOf(labelAgreement))));
        labelAgreement.click();
        buttonConfirmShipping.click();
    }

    public void clickPayByBankWire() {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.className(String.valueOf(buttonPayByBankWire))));
        buttonPayByBankWire.click();
    }

    public String getTotalPaymentInPaymentStatus() {
        this.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='price']")));
        String totalPaymentInPaymentStatus = this.webDriver.findElement(By.xpath("//span[@class='price']")).getText();
        return totalPaymentInPaymentStatus;
    }
}
