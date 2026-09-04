import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setPrintAssertionsDescription;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SauceDemoTest {
    @BeforeAll
    static void beforeAll() {
        //Configuracion de web driver
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    private static WebDriver driver;
    private static String formMessageResult;


    @Test
    void sauceDemoTest() {
        driver.get("https://www.saucedemo.com/");


        WebElement usuario = driver.findElement(By.id("user-name"));
        usuario.sendKeys("standard_user");

        WebElement contrasenia = driver.findElement(By.id("password"));
        contrasenia.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        WebElement mochila =  driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        mochila.click();

        WebElement carrito = driver.findElement(By.id("shopping_cart_container"));
        carrito.click();

        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        WebElement nombre = driver.findElement(By.id("first-name"));
        nombre.sendKeys("Joaquin");

        WebElement apellido = driver.findElement(By.id("last-name"));
        apellido.sendKeys("Pereira");

        WebElement codigoPostal = driver.findElement(By.id("postal-code"));
        codigoPostal.sendKeys("11550");

        WebElement botonContinuar = driver.findElement(By.id("continue"));
        botonContinuar.click();

        WebElement botonFinalizar = driver.findElement(By.cssSelector("#finish"));
        botonFinalizar.click();

        String mensajeConfirmacion = driver.findElement(By.xpath("//h2[@data-test='complete-header']")).getText();
        Assertions.assertThat(mensajeConfirmacion).as("Thank you for your order!");


    }
    @AfterAll
    static void afterAll() {
        driver.quit();
    }

}