package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton   = By.xpath("//button[@type='submit']");
    private By errorMessage  = By.cssSelector(".oxd-alert-content-text");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Espera explícita de hasta 10 segundos
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Acciones
    public void setUsername(String username) {
        WebElement userField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        userField.clear();
        userField.sendKeys(username);
    }

    public void setPassword(String password) {
        WebElement passField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passField.clear();
        passField.sendKeys(password);
    }

    public void clickLogin() {
        WebElement button =
                wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        button.click();
    }

    public String getErrorMessage() {
        WebElement msg =
                wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return msg.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
