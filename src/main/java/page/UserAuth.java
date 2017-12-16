package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserAuth {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private JavascriptExecutor js;

    public static String LOGIN_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @FindBy(id = "email")
    private WebElement fieldEmail;

    @FindBy(id = "passwd")
    private WebElement fieldPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement buttonSignIn;

    public UserAuth(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        this.webDriverWait = new WebDriverWait(webDriver, 5);
        this.js = (JavascriptExecutor) this.webDriver;
    }

    public void open() {
        this.webDriver.get(LOGIN_URL);
    }

    public void inputEmail(String email) {
        this.fieldEmail.sendKeys(email);
    }

    public void inputPassword(String password) {
        this.fieldPassword.sendKeys(password);
    }

    public void clickButtonLogin() {
        this.buttonSignIn.click();
    }

    public void signIn(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        clickButtonLogin();
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(1) > a > span")));
    }
}
