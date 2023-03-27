package com.simulacion;

import java.util.List;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.id;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Jorge Hernandez Araya | jorge09ha User: viwofaj499@necktai.com
 * password: TestCase2023
 */
public class TestCases {

    WebDriver driver; //declarar el web driver

    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/simulacion/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.techzilla.cr/");
        driver.manage().window().maximize();
    }

    public void test1() throws InterruptedException {
        launchBrowser();
        driver.navigate().to("https://www.techzilla.cr/mi-cuenta/");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".wd-header-my-account .wd-tools-text")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("username")).sendKeys("viwofaj499@necktai.com");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("TestCase2023");
        Thread.sleep(1000);
        driver.findElement(By.name("login")).click();
        Thread.sleep(1000);
        try {
            WebElement result = driver.findElement(By.cssSelector(".woocommerce-error"));
            System.out.println("No se pudo iniciar sesión");
            JOptionPane.showMessageDialog(null, "No se pudo iniciar sesión", "TEST ERROR", 0);
            closeBrowser();
        } catch (Exception e) {
            System.out.println("Inicio de sesión correcto");
            JOptionPane.showMessageDialog(null, "Inicio de sesión correcto", "OK TEST", 1);
            closeBrowser();
        }
    }

    public void test2() throws InterruptedException {
        launchBrowser();
        driver.navigate().to("https://www.techzilla.cr/mi-cuenta/");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".wd-header-my-account .wd-tools-text")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("username")).sendKeys("viwofaj499@necktai.com");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("TestCase2033");
        Thread.sleep(1000);
        driver.findElement(By.name("login")).click();
        Thread.sleep(1000);
        try {
            WebElement result = driver.findElement(By.cssSelector(".woocommerce-error"));
            JOptionPane.showMessageDialog(null, "No se pudo iniciar sesión", "OK TEST", 1);
            closeBrowser();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inicio de sesión correcto", "TEST ERROR", 0);
            closeBrowser();
        }
    }

    public void test3() throws InterruptedException {
        launchBrowser();
        driver.navigate().to("https://www.techzilla.cr/mi-cuenta/");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".wd-header-my-account .wd-tools-text")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("username")).sendKeys("viwofaj499@necktai.com");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("TestCase2023");
        Thread.sleep(1000);
        driver.findElement(By.name("login")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".wd-header-my-account .wd-tools-text")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Cerrar sesión")).click();
        Thread.sleep(1000);
        String expectedUrl = "https://www.techzilla.cr/mi-cuenta/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            JOptionPane.showMessageDialog(null, "Cerrar sesión se completo corretamente", "OK TEST", 1);
            closeBrowser();
        } else {
            JOptionPane.showMessageDialog(null, "No se completo cerrar sesión", "TEST ERROR", 0);
            closeBrowser();
        }
    }

    public void test4() throws InterruptedException {
        launchBrowser();
        Thread.sleep(1000);
        driver.findElement(By.name("s")).sendKeys("Procesador intel");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".searchsubmit:nth-child(4)")).click();
        String expectedUrl = "https://www.techzilla.cr/?s=Procesador+intel&post_type=product&product_cat=0";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            JOptionPane.showMessageDialog(null, "Test Completado", "OK TEST", 1);
            closeBrowser();
        } else {
            JOptionPane.showMessageDialog(null, "Error en completar", "TEST ERROR", 0);
            closeBrowser();
        }

    }

    public void test5() throws InterruptedException {

    }

    public void test6() throws InterruptedException {

    }

    public void closeBrowser() {
        driver.quit();
    }
}
