package stepdefinitions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginDemoSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Dado("que el usuario está en la página de login de OrangeHRM")
    public void usuarioEnPaginaLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }

    @Cuando("ingresa usuario {string} y contraseña {string}")
    public void ingresaCredenciales(String user, String pass) {
        loginPage.setUsername(user);
        loginPage.setPassword(pass);
    }

    @Cuando("hace clic en el botón Login")
    public void haceClicEnLogin() {
        loginPage.clickLogin();
    }

    @Entonces("debería ver el dashboard")
    public void deberiaVerDashboard() throws InterruptedException {
        // pequeña espera para que cargue
        Thread.sleep(2000);
        assertTrue(loginPage.getCurrentUrl().contains("/dashboard"));
    }

    @Entonces("debería ver el mensaje de error {string}")
    public void deberiaVerMensajeError(String mensajeEsperado) throws InterruptedException {
        Thread.sleep(2000);
        assertEquals(mensajeEsperado, loginPage.getErrorMessage());
    }
}
