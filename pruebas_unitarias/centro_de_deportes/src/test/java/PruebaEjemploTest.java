import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaEjemploTest {
    private WebDriver driver;

    @BeforeEach
    void prepararPruebas() { // preparamos el contexto
        driver = new ChromeDriver();
    }

    @AfterEach
    void cerrarPruebas() { // restablece el contexto y cierra el navegador
        driver.quit();
    }

    @Test
    void IngresarAlCursoTATF2026()    {

        WebDriver driverChrome = new ChromeDriver(); //Instancia para inicializar Google Chrome

        WebDriverWait wait = new WebDriverWait(driverChrome, Duration.ofSeconds(10)); //Tiempo de espera

        driverChrome.manage().window().maximize(); //Maximizar pantalla del navegador

        driverChrome.get("https://capacitacion.ces.com.uy/login/index.php"); //Ingresar a la pagina

        // Ingresar usuario
        WebElement usuario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usuario.sendKeys("ci51026459");

        // Ingresar contraseña
        WebElement contrasenia = driverChrome.findElement(By.id("password"));
        contrasenia.sendKeys("Flairbartender21");

        // Seleccionar boton Acceder
        WebElement botonAcceder = driverChrome.findElement(By.id("loginbtn"));
        botonAcceder.click();

        // Seleccionar curso TATF
        WebElement cursoTATF = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("TALLER DE AUTOMATIZACIÓN DEL TESTING FUNCIONAL 202608A")));
        cursoTATF.click();

        // Validar texto del curso
        WebElement texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='page-context-header']")));
        assertEquals("TALLER DE AUTOMATIZACIÓN DEL TESTING FUNCIONAL 202608A", texto.getText());

        driverChrome.quit();
    }
}